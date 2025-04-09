package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BaseTest {

    Logger log = LogManager.getLogger(LoginTest.class);

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return ExcelUtils.getSheetData("PositiveLogin");
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return ExcelUtils.getSheetData("NegativeLogin");
    }

    @Test(dataProvider = "validLoginData", retryAnalyzer = utils.RetryAnalyzer.class)
    public void testValidLogin(String username, String password) {
        log.info("Starting testValidLogin with: " + username);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        String title = driver.getTitle();
        log.info("Page title: " + title);
        test.info("Page title: " + title);

        Assert.assertTrue(title.contains("ParaBank"), "❌ Login failed. Title was: " + title);
    }

    @Test(dataProvider = "invalidLoginData", retryAnalyzer = utils.RetryAnalyzer.class)
    public void testInvalidLogin(String username, String password) {
        log.info("Starting testInvalidLogin with: " + username);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        boolean errorVisible = login.isLoginErrorDisplayed();
        log.info("Error message visible? " + errorVisible);
        test.info("Error message visible? " + errorVisible);

        Assert.assertTrue(errorVisible, "❌ Expected login error message, but it wasn't displayed.");
    }
}
