package freeCrmTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCrmTest {

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
    public void loginWithAdminUserTest(){

        driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();

        credentials = Data.getUserLoginInfo().get("admin");
        credentialsInfo = credentials.split("_");


        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(credentialsInfo[0]);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(credentialsInfo[1]);

        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);



    }

    @Test
    public void loginWithCustomerUserTest(){

        driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();
        credentials = Data.getUserLoginInfo().get("customer");
        credentialsInfo = credentials.split("_");


        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(credentialsInfo[0]);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(credentialsInfo[1]);

        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
