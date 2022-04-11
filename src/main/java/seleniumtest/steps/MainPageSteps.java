package seleniumtest.steps;

import cucumber.api.java.en.*;
import org.testng.Assert;
import seleniumtest.page.MainPage;

public class MainPageSteps {

    MainPage mainPage;

    public MainPageSteps(){
        mainPage = new MainPage();
    }

    @Then("^hover over '(.+?)' menu$")
    public void hover_over_Computers_menu(String label) {
        mainPage.hoverOver(label);
    }

    @Then("click '(.+?)' in main page$")
    public void clickMainPageButton(String label) {
        mainPage.clickMainPageButtons(label);
    }

    @Then("^choose '(.+?)' on display dropdown$")
    public void choose_nine_on_display_dropdown(String number){
        mainPage.chooseNumberOfElementsDropdown(number);
    }

    @Then("^check '(\\d+)' items are displayed$")
    public void check_items_are_displayed(int arg1) {
        mainPage.checkNumberOfElementsDisplayed(arg1);
    }

    @Then("^select '(\\d+)' on filter attributes$")
    public void select_on_filter_attributes(int arg1) throws InterruptedException {
        mainPage.filter_attributes(arg1);
    }

    @Then("^add item '(\\d+)' to '(.+?)' list$")
    public void add_item_to_wish_list(int arg1, String listType)  {
        mainPage.addItemToList(arg1,listType);
    }

    @Then("^check the '(.+?)' notification '(.+?)' is displayed$")
    public void isNotificationDisplayed(String type,String text) throws InterruptedException {
        if(type.equals("wishlist"))
            mainPage.checkWishNotificationDisplayed(text);
        else if(type.equals("cartlist"))
            mainPage.checkCartNotificationDisplayed(text);
    }

    @Then("^check that '(.+?)' on menu bar displays '(.+?)'$")
    public void checkNumOnMenuBar(String type,String text){
        String actual;
        if(type.equals("wishlist")){
            actual = MainPage.wishlistLabel.getText();
            Assert.assertEquals(actual,text);
        }
        else if(type.equals("cartlist")){
            actual = MainPage.cartLabel.getText();
            Assert.assertEquals(actual,text);

        }
    }

}
