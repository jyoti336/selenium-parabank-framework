package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DriverFactory {

    static Logger log = LogManager.getLogger(DriverFactory.class);

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "D://Jyotsna Documents//Study//ChromeDrivers//chromedriver-win64//chromedriver-win64//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (isHeadless) {
            options.addArguments("--headless=new");
            log.info("✅ Headless mode enabled");
        } else {
            log.info("✅ Running in Chrome UI mode");
        }

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
