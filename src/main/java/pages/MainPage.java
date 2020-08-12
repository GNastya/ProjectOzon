package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = "a[href ='/cart']")
    protected WebElement basketButton;

    @FindBy(css = "a[href ='/cart'] > span")
    protected WebElement productQuantity;

    @FindBy(css = "div[data-widget='searchBarDesktop'] input")
    protected WebElement searchField;

    @FindBy(css = "div[data-widget='searchBarDesktop'] button")
    protected WebElement searchButton;

    public BasketPage openBasketPage() {
        try {
            basketButton.click();
        } catch (StaleElementReferenceException exception) {
            basketButton.click();
        }
        return new BasketPage();
    }

    public ShoppingListPage searchProduct(String productCode) {
        searchField.sendKeys(productCode);
        searchButton.click();
        return new ShoppingListPage();
    }

}
