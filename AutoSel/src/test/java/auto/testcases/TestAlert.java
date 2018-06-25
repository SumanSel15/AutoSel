package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import auto.pages.AlertPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestAlert extends Init {

  @DataProvider(name = "test1")
  public Object[][] createData1() {

    return new Object[][] {{"admin", "pass"}, {"sam", "sam"}, {"alan", "pass1"}};
  }

  @Test(groups = {"smoke", "regression"})
  public void testClickForJSAlert() {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");

    AlertPage alertPage = new AlertPage(driver);
    alertPage.verifyAlertPageHeader();
    alertPage.clickOnButton("Click for JS Alert");
    alertPage.accept();

  }

  //@Test(groups = {"reg"}, retryAnalyzer = auto.utility.RetryAnalyser.class)
  @Test(groups = {"reg"})
  public void testClickForJSConfirm() throws InterruptedException {


    WelcomePage welcomePage = new WelcomePage(driver);
    Thread.sleep(5000);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");
    
    //assertTrue(false, "lol");

    AlertPage alertPage = new AlertPage(driver);
    alertPage.verifyAlertPageHeader();
    alertPage.clickOnButton("Click for JS Confirm");
    alertPage.cancel();


  }

  @Test(groups = {"sanity"}, dataProvider = "test1")
  public void testClickForJSPrompt(String uname, String paswd) {
    System.out.println(uname + ": " + paswd);

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");

    AlertPage alertPage = new AlertPage(driver);
    alertPage.verifyAlertPageHeader();
    alertPage.clickOnButton("Click for JS Prompt");
    alertPage.typeAndAccept();


  }


}
