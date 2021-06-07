package googleSearchDockerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleSearchFirefox {

    static RemoteWebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{

        System.out.println("Running Test in Docker Container <<Firefox>>");

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setPlatform(Platform.LINUX);
        cap.setVersion("");

        driver = new RemoteWebDriver(new URL("http://192.168.1.9:4446/wd/hub"), cap);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Test(description = "Searching in Google")
    public void googleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Learn Automation Firefox");

        Thread.sleep(5000);

    }


    @AfterClass
    public static void tearDown(){
        if(driver!=null){
            System.out.println("Completed Test in Docker Container <<Firefox>>");
            driver.quit();
        }
    }























}
