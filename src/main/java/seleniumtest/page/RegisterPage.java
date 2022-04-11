package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

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
    @FindBy(id = "Password")
    public static WebElement password;
    @FindBy(id = "ConfirmPassword")
    public static WebElement confirmPassword;
    @FindBy(xpath = "//div[@class='result']")
    public static WebElement registrationCompleteText;


    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public void selectGender(String gender){
        if(gender.equals("Female")){
            radioF.click();
            wait.until(ExpectedConditions.elementToBeSelected(radioF));
        }
        else
            radioM.click();
    }

    public void insertDate(String str,String label){
        Select date;
        switch (label) {
            case "Day":
                date = new Select(day);
                date.selectByVisibleText(str);
                break;
            case "Month":
                date = new Select(month);
                date.selectByVisibleText(str);
                break;
            case "Year":
                date = new Select(year);
                date.selectByVisibleText(str);
                break;

        }


    }

    public void enterText(String text, String label){
        switch (label) {
            case "First name:":
                firstname.sendKeys(text);
                break;
            case "Last name:":
                lastName.sendKeys(text);
                break;
            case "Email:":
                email.sendKeys(text);
                break;
            case "Company name:":
                company.sendKeys(text);
                break;
            case "Password:":
                password.sendKeys(text);
                break;
            case "Confirm password:":
                confirmPassword.sendKeys(text);
                break;
            default:
                throw new NotFoundException("Button not found!");

        }

        }
}
