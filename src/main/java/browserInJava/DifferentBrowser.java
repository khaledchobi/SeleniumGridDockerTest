package browserInJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DifferentBrowser {


    public static WebDriver driver;

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

		/*System.setProperty("webdriver.gecko.driver", projectPath+"/src/main/resources/Webdrivers/geckodriver");
		driver = new FirefoxDriver();*/

		/*System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/resources/Webdrivers/chromedriver");
		driver = new ChromeDriver();*/

        System.setProperty("webdriver.safari.driver", "");
        driver = new SafariDriver();

        /*System.setProperty("webdriver.opera.driver", projectPath+"/src/main/resources/Webdrivers/operadriver");
        driver = new OperaDriver();*/

        /*System.setProperty("webdriver.ie.driver", projectPath+"/src/main/resources/Webdrivers/IEDriverServer");
        driver = new InternetExplorerDriver();*/




        driver.get("https://www.google.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();





    }







}
