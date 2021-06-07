package crossBrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestCase {


    WebDriver driver;

    @Test
    // Here this parameters we will take from testng.xml
    @Parameters("Browser")
    public  void verifyPageTitle(String browserName) {

        if(browserName.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/SeleniumGridDockerTest/src/main/resources/Webdrivers/geckodriver");

            driver = new FirefoxDriver();

            System.out.println("Firefox Browser Execution");


        }

        else if(browserName.equalsIgnoreCase("Chrome")){

            System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/SeleniumGridDockerTest/src/main/resources/Webdrivers/chromedriver");

            driver = new ChromeDriver();

            System.out.println("Chrome Browser Execution");

        }

        else if(browserName.equalsIgnoreCase("Safari")){

            System.setProperty("webdriver.safari.driver", "");

            driver = new SafariDriver();

            System.out.println("Safari Browser Execution");

        }

        else if(browserName.equalsIgnoreCase("Opera")){

            System.setProperty("webdriver.opera.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/SeleniumGridDockerTest/src/main/resources/Webdrivers/operadriver");

            driver = new OperaDriver();

            System.out.println("Opera Browser Execution");

        }

        /*else if(browserName.equalsIgnoreCase("IE")){

            System.setProperty("webdriver.ie.driver", "-DpropertyName=value");

            driver = new InternetExplorerDriver();


        }*/

        //driver.manage().window().maximize();

        driver.get("http://www.google.com");

        System.out.println(driver.getTitle());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();


    }








}
