package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.utils.WebDriverFactory;

public class MyAccountPage {

    public MyAccountPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(xpath = "//a[@class='ico-account']")
    public static WebElement myAccountMenu;
    @FindBy(id = "gender-male")
    public static WebElement radioM;
    @FindBy(id = "gender-female")
    public static WebElement radioF;
    @FindBy(id = "FirstName")
    public static WebElement firstname;
    @FindBy(id = "LastName")
    public static WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    public static WebElement day;
    @FindBy(name = "DateOfBirthMonth")
    public static WebElement month;
    @FindBy(name = "DateOfBirthYear")
    public static WebElement year;
    @FindBy(id = "Email")
    public static WebElement email;
    @FindBy(id = "Company")
    public static WebElement company;

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public void clickMyAccountButtons(String buttonName) {
        switch (buttonName) {
            case "My account":
                wait.until(ExpectedConditions.elementToBeClickable(myAccountMenu));
                myAccountMenu.click();
                break;
            default:
                throw new NotFoundException("Button not found!");
        }
    }
    public String getGender(){
        if(radioF.isSelected())
            return"Female";
        else return "Male";
    }

    public void checkCustomerData(String expectedText,String label) {
        String actual;
        switch (label) {
            case "Gender":
                actual = getGender();
                Assert.assertEquals(actual, expectedText);
                break;
            case "First name":
                actual = firstname.getAttribute("value");
                Assert.assertEquals(actual, expectedText);
                break;
            case "Last name":
                actual = lastName.getAttribute("value");
                Assert.assertEquals(actual, expectedText);
                break;
            case "Day":
                actual = day.getAttribute("value");
                Assert.assertEquals(actual, expectedText);
                break;
            case "Month":
                actual = month.getAttribute("value");
                Assert.assertEquals(actual, expectedText);
                break;
            case "Year":
                actual = year.getAttribute("value");
                Assert.assertEquals(actual, expectedText);
                break;
            case "Email":
                actual = email.getAttribute("value");
                Assert.assertEquals(actual, expectedText);
                break;
            case "Company":
                actual = company.getAttribute("value");
                Assert.assertEquals(actual, expectedText);
                break;
            default:
                throw new NotFoundException("verification of user data failed!");
        }
    }
}
