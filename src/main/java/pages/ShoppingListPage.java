package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static core.BaseTest.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.CommonScenarios.*;


public class ShoppingListPage extends MainPage {

    @FindBy(css = "button[class='ui-k6'] > div[class='ui-k8']")
    private WebElement basketButton;

    @FindBy(css = "div[data-widget='searchResultsV2'] a[href='/context/detail/id/139605374/']")
    private List<WebElement> contextDetails;

    @FindBy(css = "div[data-widget='searchResultsV2'] a[href='/context/detail/id/139605374/']")
    private List<WebElement> productDetails;

    public ShoppingListPage checkProductName(String resultName) {
        try {
            assertTrue(productDetails.get(2).getText().contains(resultName));
        } catch (IndexOutOfBoundsException error) {
            // sometimes content isn't rendered. It's a bug of Ozone market.
            driver.navigate().refresh();
            assertTrue(productDetails.get(2).getText().contains(resultName));
        }
        return this;
    }

    public ShoppingListPage addProductToBasket() {
        basketButton.click();
        waitUntil(textToBePresentInElement(productQuantity, "1"));
        return  this;
    }

    public ShoppingListPage checkProductPrice() {
        String notFormatPrice = contextDetails.get(1).findElement(By.cssSelector("span")).getText();
        assertEquals(notFormatPrice.replace(" ₽", ""), "528");
        return this;
    }
}
