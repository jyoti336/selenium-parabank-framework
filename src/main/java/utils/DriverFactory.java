package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    public static WebDriver getDriver() {
      //  WebDriverManager.chromedriver().setup();
    	
    	//WebDriverManager.chromedriver().browserVersion("135").setup();
    	
    	System.setProperty("webdriver.chrome.driver", "D://Jyotsna Documents//Study//ChromeDrivers//chromedriver-win64//chromedriver-win64//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
		return driver;

       // return new ChromeDriver();
    }
}


/**
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}**/
