package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginButton;

    @FindBy(css = "p.error")
    WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        username.clear();
        username.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
        loginButton.click();
    }

    public boolean isLoginErrorDisplayed() {
        try {
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
