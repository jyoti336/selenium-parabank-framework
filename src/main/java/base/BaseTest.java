package base;

import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.DriverFactory;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

import java.io.File;
import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void reportSetup() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());

        try {
            switch (result.getStatus()) {
                case ITestResult.FAILURE:
                    test.fail(result.getThrowable());
                    test.addScreenCaptureFromPath(new File(screenshotPath).getAbsolutePath());
                    break;
                case ITestResult.SUCCESS:
                    test.pass("Test Passed");
                    test.addScreenCaptureFromPath(new File(screenshotPath).getAbsolutePath());
                    break;
                case ITestResult.SKIP:
                    test.skip("Test Skipped");
                    test.addScreenCaptureFromPath(new File(screenshotPath).getAbsolutePath());
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
