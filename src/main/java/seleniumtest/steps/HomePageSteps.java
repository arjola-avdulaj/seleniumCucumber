package seleniumtest.steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.page.HomePage;
import seleniumtest.page.ShoppingCartPage;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps(){
        homePage = new HomePage();
    }

    @Given("^the page '(.+?)' is opened$")
    public void the_page_https_demo_nopcommerce_com_is_opened(String url) {
        DriverUtils.getDriver().get(url);
    }

    @Then("^click '(.+?)' menu from home page$")
    public void click_Log_in_menu_from_home_page(String buttonName) {
        homePage.clickMenu(buttonName);
    }

    @Then("^click '(.+?)' button$")
    public void click_Register_button(String buttonName) {
        homePage.clickLogInPageButtons(buttonName);
    }

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    @Then("^check the text '(.+?)' is shown in login page$")
    public void checkLoginCompleted(String expected) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='topic-block-title']/h2")));
        String actual = HomePage.loginCompletedText.getText();
        Assert.assertEquals(actual,expected);
    }

    @Then("^check '(.+?)' is displayed$")
    public void checkElementIsDisplayed(String label) {
        if(label.equals("Log out")){
            Assert.assertTrue(HomePage.logoutButton.isDisplayed());
        }
        else if(label.equals("Go to cart")){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button-1 cart-button']")));
            Assert.assertTrue(ShoppingCartPage.goToCart.isDisplayed());
        }
    }
}
