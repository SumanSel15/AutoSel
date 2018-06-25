package auto.utility;
/*
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 12-May-18
 */

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Init {
  protected WebDriver driver = null;
  String baseURL, nodeURL;
  /**
   * This function is used for doing web driver setup.
 * @throws MalformedURLException 
 * @throws IOException 
   */
  @BeforeMethod(alwaysRun = true)
  
  
  public void setUp() throws MalformedURLException  {
    System.out.println("*** Setup ***");
    FirefoxProfile ffprofile = createFirefoxProfile();
    //String browser = "firefox";
    baseURL = "http://the-internet.herokuapp.com/";
    nodeURL = "http://localhost:4444/wd/hub";
    DesiredCapabilities capability = DesiredCapabilities.chrome();
    capability.setBrowserName("firefox");
    capability.setPlatform(Platform.WIN10);
    driver = new RemoteWebDriver(new URL(nodeURL), capability);
   /* try {
      browser = System.getProperty("browser");
    } catch (Exception e) {
      System.out.println("not set");
    }


    if (browser.equals("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equals("ie")) {
      driver = new InternetExplorerDriver();
    } else {
      driver = new FirefoxDriver(ffprofile);
    }*/
   driver.get("http://the-internet.herokuapp.com/");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  /**
   * This function is quit the driver instance.
   */
  @AfterMethod(alwaysRun = true)
  public void teardown() {
    System.out.println("*** Teardown ***");
    if (driver != null)
      driver.quit();

  }

  public FirefoxProfile createFirefoxProfile() {

    FirefoxProfile firefoxProfile = new FirefoxProfile();

    firefoxProfile = new FirefoxProfile();
    firefoxProfile.setPreference("browser.download.folderList", 2);
    firefoxProfile.setPreference("browser.download.dir", "E:\\git_projects\\download");
    firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
        "text/csv,application/pdf,application/vnd.ms-excel,application/octet-stream");
    firefoxProfile.setPreference("pdfjs.disabled", true);

    return firefoxProfile;
  }

}
