package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static org.testng.Assert.*;

public class BasketPage extends MainPage {

    private static final String EMPTY_BASKET = "Корзина пуста";
    private static final String EMPTY_BASKET_TEXT = "Воспользуйтесь поиском, чтобы найти всё что нужно.\n" +
            "Если в корзине были товары –\nвойдите\n, чтобы посмотреть список.";

    @FindBy(css = "div[data-widget='emptyCart'] > h1")
    private WebElement emptyBasketLabel;

    @FindBy(css = "div[data-widget='emptyCart'] > div")
    private WebElement emptyBasketText;

    @FindBy(css = "div[data-widget ='split'] span")
    private List<WebElement> detailsName;

    @FindBy(css = "[data-widget ='total']  span")
    private List<WebElement> productAmountAndPrice;

    @FindBy(css = "section[data-widget='total'] button")
    private WebElement registrationButton;


    public BasketPage checkEmptyBasket() {
        assertEquals(emptyBasketLabel.getText(), EMPTY_BASKET);
        assertEquals(emptyBasketText.getText(), EMPTY_BASKET_TEXT);
        return this;
    }

    public BasketPage checkFullBasket(String productName, String price) {
        openBasketPage();
        assertTrue(detailsName.get(1).getText().contains(productName));
        assertTrue(productAmountAndPrice.get(2).getText().contains("1"));
        String nonFormatProductPrice = productAmountAndPrice.get(productAmountAndPrice.size() - 1).getText();
        assertEquals(nonFormatProductPrice.replace(" ₽", ""), price);
        return new BasketPage();
    }

    public AuthorizationPage goToRegistration() {
        registrationButton.click();
        AuthorizationPage authorizationPage = new AuthorizationPage();
        assertTrue(authorizationPage.iFrame.isDisplayed());
        return authorizationPage;
    }
}