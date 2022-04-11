package seleniumtest.steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.page.MainPage;
import seleniumtest.page.RegisterPage;
import seleniumtest.page.ShoppingCartPage;
import seleniumtest.utils.WebDriverFactory;

public class RegisterPageSteps {

    RegisterPage registerPage;

    public RegisterPageSteps(){
        registerPage = new RegisterPage();
    }

    @Then("^select '(.+?)' in '(.+?)' input field$")
    public void select_Gender_input_field(String text,String label) {
        registerPage.selectGender(text);
    }

    @Then("^type '(.+?)' in the '(.+?)' input field$")
    public void type_the_First_Name_input_field(String text, String label) {
        registerPage.enterText(text,label);
    }
    @Then("^select \"([^\"]*)\" from '(.+?)' dropdown$")
    public void select_from_Day_dropdown(String arg1,String label) {
        registerPage.insertDate(arg1,label);
    }


    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    @Then("^check the text '(.+?)' is shown$")
    public void registrationCompletedText(String expected) {
        String actual;
        switch (expected){
            case "Your registration completed":
                actual = RegisterPage.registrationCompleteText.getText();
                Assert.assertEquals(actual,expected);
                break;
            case "Notebooks":
                wait.until(ExpectedConditions.visibilityOf(MainPage.notebooksTitle));
                actual = MainPage.notebooksTitle.getText();
                Assert.assertEquals(actual,expected);
                break;
            case "Shopping cart":
                wait.until(ExpectedConditions.visibilityOf(ShoppingCartPage.shoppingCartTitle));
                actual = ShoppingCartPage.shoppingCartTitle.getText();
                Assert.assertEquals(actual,expected);
                break;

        }

    }


}
