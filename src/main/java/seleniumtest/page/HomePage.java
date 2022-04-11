package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.utils.WebDriverFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(className = "ico-login")
    public static WebElement loginMenu;

    @FindBy(xpath = "//button[@class='button-1 register-button']")
    public static WebElement registerButton;

    @FindBy(id = "register-button")
    public static WebElement registerUserButton;

    @FindBy(className = "ico-logout")
    public static WebElement logoutButton;

    @FindBy(xpath = "//div[@class='topic-block-title']/h2")
    public static WebElement loginCompletedText;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public static WebElement loginButton;

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public void clickMenu(String buttonName) {
        switch (buttonName) {
            case "Log in":
                wait.until(ExpectedConditions.visibilityOf(loginMenu));
                loginMenu.click();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }
    }

    public void clickLogInPageButtons(String buttonName) {
        switch (buttonName) {
            case "Register":
                wait.until(ExpectedConditions.visibilityOf(registerButton));
                registerButton.click();
                break;
            case "Register User":
                wait.until(ExpectedConditions.visibilityOf(registerUserButton));
                registerUserButton.click();
                break;
            case "Log out":
                wait.until(ExpectedConditions.visibilityOf(logoutButton));
                logoutButton.click();
                break;
            case "Log in":
                wait.until(ExpectedConditions.visibilityOf(loginButton));
                loginButton.click();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }
    }

}
