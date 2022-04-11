package seleniumtest.steps;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import seleniumtest.page.MyAccountPage;
import seleniumtest.page.RegisterPage;

public class MyAccountSteps {

    MyAccountPage myAccountPage;

    public MyAccountSteps(){
        myAccountPage = new MyAccountPage();
    }

    @Then("^click '(.+?)' button in my account$")
    public void click_My_account_button_in_my_account(String buttonName){
        myAccountPage.clickMyAccountButtons(buttonName);
    }

    @Then("^check '(.+?)' is typed in '(.+?)' input field$")
    public void check_is_typed_in_input_field(String text, String label) {
        myAccountPage.checkCustomerData(text,label);
    }
}
