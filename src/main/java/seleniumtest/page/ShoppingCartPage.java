package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage {

    public ShoppingCartPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(xpath = "//span[@class='cart-label']")
    public static WebElement shoppingCartMenu;

    @FindBy(xpath = "//button[@class='button-1 cart-button']")
    public static WebElement goToCart;

    @FindBy(xpath = "//h1[text()='Shopping cart']")
    public static WebElement shoppingCartTitle;

    @FindBy(id = "updatecart")
    public static WebElement updateCart;

    @FindBy(name = "continueshopping")
    public static WebElement continueShopping;

    @FindBy(id = "open-estimate-shipping-popup")
    public static WebElement estimateShipping;

    @FindBy(xpath = "//span//strong")
    public static WebElement totalAmount;

    public double getTextAndParseToDouble(WebElement element){
        String str= element.getText();
        String newStr = str.replaceAll("[$,]", "");
        return Double.parseDouble(newStr);
    }

    public double getPricesSum(){
        List<WebElement> elements = DriverUtils.getDriver().findElements(By.xpath("//td[@class='subtotal']//span"));
        List<Double> subtotals = new ArrayList<>();

        for(int i=0; i< elements.size(); i++){
            subtotals.add(getTextAndParseToDouble(elements.get(i)));
        }

        double sum=0;
        for(int i=0; i< subtotals.size(); i++){
            sum+=subtotals.get(i);
        }
        return sum;
    }

    public double getTotalAmount(){
        return getTextAndParseToDouble(totalAmount);
    }

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);


    public void removeElementFromCart(int position) throws InterruptedException {
        List<WebElement> elements = DriverUtils.getDriver().findElements(By.xpath("//td[@class='remove-from-cart']"));
        Thread.sleep(3000);
        if(elements.size() == 0)
            return;
        WebElement myElement = elements.get(position-1);
        wait.until(ExpectedConditions.elementToBeClickable(myElement));
        myElement.click();
        Thread.sleep(3000);
    }

    public int getNrItemsOnCart(){
        List<WebElement> removeButtonsList = DriverUtils.getDriver().findElements(By.xpath("//td[@class='remove-from-cart']"));
        if(removeButtonsList.size()<1)
            return 0;
        return removeButtonsList.size();
    }


}
