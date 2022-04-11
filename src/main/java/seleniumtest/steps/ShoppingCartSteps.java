package seleniumtest.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.page.ShoppingCartPage;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSteps {

    ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps(){
        shoppingCartPage = new ShoppingCartPage();
    }

    @Then("^check that the following links are shown$")
    public void checkThatTheFollowingLinksAreShown(DataTable dataTable) {
        List<String> expectedResults = dataTable.asList(String.class);
        List<String> actualResults = new ArrayList<>();

        actualResults.add(ShoppingCartPage.updateCart.getText());
        actualResults.add(ShoppingCartPage.continueShopping.getText());
        actualResults.add(ShoppingCartPage.estimateShipping.getText());

        for (int i = 0; i < expectedResults.size(); i++) {
            Assert.assertEquals(expectedResults.get(i), actualResults.get(i));
        }
        JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
        js.executeScript("window.scrollBy(0,250)", "");
    }

    @Then("^verify that the prices sum is equal to Total Price in the end of the page$")
    public void verifyPricesSumIsEqualToTotal() {
        double actualSum = shoppingCartPage.getPricesSum();
        double expectedSum = shoppingCartPage.getTotalAmount();
        Assert.assertEquals(actualSum,expectedSum);
    }
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    @Then("^empty shopping cart$")
    public void emptyShoppingCart() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> removeButtonsList = DriverUtils.getDriver().findElements(By.xpath("//td[@class='remove-from-cart']"));
        Thread.sleep(3000);

        for(int i=0; i<removeButtonsList.size(); i++){
            shoppingCartPage.removeElementFromCart(1);
            Thread.sleep(3000);
        }
    }

    @Then("^verify shopping cart is empty$")
    public void verifyShoppingCartIsEmpty() {
        int actual = shoppingCartPage.getNrItemsOnCart();
        Assert.assertEquals(actual, 0);

    }


}
