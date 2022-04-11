package seleniumtest.page;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import cucumber.api.java.cs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

import java.util.List;

public class MainPage {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public MainPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    @FindBy(xpath = "//a[@href='/computers']")
    public static WebElement computersMenu;

    @FindBy(xpath = "//a[@href='/notebooks']")
    public static WebElement notebooksMenu;

    @FindBy(xpath = "//h1[text()='Notebooks']")
    public static WebElement notebooksTitle;

    @FindBy(id = "products-pagesize")
    public static WebElement displayDropdownMenu;

    @FindBy(xpath="//select[@id='products-pagesize']/option[@value='9']")
    public static WebElement displayDropdownNine;

    @FindBy(xpath = "//input[@id='attribute-option-10']")
    public static WebElement filterCapacityTo16;

    @FindBy (xpath = "//p[@class]")
    public static WebElement notification;

    @FindBy(xpath = "//span[@class='wishlist-qty']")
    public static WebElement wishlistLabel;

    @FindBy (xpath = "//span[@class='cart-qty']")
    public static WebElement cartLabel;

    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public void hoverOver(String label){
        Actions action = new Actions(DriverUtils.getDriver());
        switch (label){
            case "Computers":
                wait.until(ExpectedConditions.visibilityOf(computersMenu));
                action.moveToElement(computersMenu).perform();
                break;
            case "Shopping cart":
                wait.until(ExpectedConditions.visibilityOf(ShoppingCartPage.shoppingCartMenu));
                action.moveToElement(ShoppingCartPage.shoppingCartMenu).perform();
                break;
            default:
                throw new NotFoundException("menu not found!");
        }
    }

    public void clickMainPageButtons(String buttonName) {
        switch (buttonName) {
            case "Notebooks":
                wait.until(ExpectedConditions.visibilityOf(notebooksMenu));
                wait.until(ExpectedConditions.elementToBeClickable(notebooksMenu));
                notebooksMenu.click();
                break;
            case "Go to cart":
                wait.until(ExpectedConditions.elementToBeClickable(ShoppingCartPage.goToCart));
                ShoppingCartPage.goToCart.click();
                break;

            default:
                throw new NotFoundException("Button not found!");
        }
    }

    public void chooseNumberOfElementsDropdown(String number) {
        wait.until(ExpectedConditions.elementToBeClickable(displayDropdownMenu));
        displayDropdownMenu.click();

        switch (number) {
           case "nine":
               wait.until(ExpectedConditions.elementToBeClickable(displayDropdownNine));
               displayDropdownNine.click();
               break;

               default:
                   throw new NotFoundException("Number in dropdown not found!");
        }
    }

    public int numberOfProductItems(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='product-item']")));
        List<WebElement> items = DriverUtils.getDriver().findElements(By.xpath("//div[@class='product-item']"));
        int actual = items.size();
        return actual;
    }

    public void checkNumberOfElementsDisplayed(int number) {
        int actual = numberOfProductItems();
        Assert.assertEquals(actual, number);
    }

    public void filter_attributes(int num) throws InterruptedException {
        switch(num){
            case 16 :
                wait.until(ExpectedConditions.elementToBeClickable(filterCapacityTo16));
                filterCapacityTo16.click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
                Thread.sleep(3000);
                break;
        }
    }
    public void addItemToList(int num,String listType){
        List<WebElement> items;
        WebElement element;
        switch(listType) {
            case "wish":
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@title='Add to wishlist']")));
                items = DriverUtils.getDriver().findElements(By.xpath("//button[@title='Add to wishlist']"));
                element = items.get(num - 1);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
                js.executeScript("window.scrollBy(0,250)", "");
                break;
            case "cart":
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[text()='Add to cart']")));
                items = DriverUtils.getDriver().findElements(By.xpath("//button[text()='Add to cart']"));
                element = items.get(num - 1);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;

        }
    }

    public void checkWishNotificationDisplayed(String expected) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(notification));
        Thread.sleep(3000);
        Assert.assertEquals(notification.getText(), expected);

        }

    public void checkCartNotificationDisplayed(String expected) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(notification));
        Thread.sleep(3000);
        Assert.assertEquals(notification.getText(), expected);
    }

    }



