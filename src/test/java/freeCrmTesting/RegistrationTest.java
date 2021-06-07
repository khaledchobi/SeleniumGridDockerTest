package freeCrmTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    public WebDriver driver;
    public String credentials;
    public String credentialsInfo[];

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/SeleniumGridDockerTest/src/main/resources/Webdrivers/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");


    }


    @Test
    public void loginWithAdminUserTest() throws InterruptedException {

        driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();

        credentials = Data.getUserRegistrationInfo().get("newCustomer");
        credentialsInfo = credentials.split("_");


        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(credentialsInfo[0]);

        WebElement createAccountBtn = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createAccountBtn);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();

        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(credentialsInfo[1]);
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(credentialsInfo[2]);

        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(credentialsInfo[3]);


        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        selectDay.selectByValue(Data.dateMap().get(16));

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectMonth.selectByVisibleText(Data.monthMap().get(3));

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByValue(Data.yearMap().get(1981));



        driver.findElement(By.xpath("//input[@id='newsletter']")).click();



        driver.findElement(By.xpath("//button[@id='submitAccount']")).submit();

        //Thread.sleep(3000);

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
