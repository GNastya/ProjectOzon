package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import core.*;
import static core.BaseTest.driver;

public class MySteps {
    MainPage mainPage;
    BaseTest baseTest = new BaseTest();
    BasketPage basketPage;

    //Test 1
    @Given("open website {string}")
    public void openWebsiteHttpsWwwOzonRu(String url) {
        baseTest.openBrowser(url);
    }

    @When("press 'Корзина' button in the header")
    public void pressКорзинаButtonInTheHeader() {
        new MainPage().openBasketPage();
    }

    @Then("verify that basket is empty and close browser")
    public void verifyThatBasketIsEmpty() {
        new BasketPage().checkEmptyBasket();
        driver.close();
    }

    //Test 2
    @Given("open {string}")
    public void openOzonRu(String url) {
        baseTest.openBrowser(url);
    }

    @When("press 'Искать на Ozon' button and type information about product and press button with 'Magnifier' icon")
    public void pressИскатьНаOzonButtonAndTypeInformationAboutProductAndPressButtonWithMagnifierIcon() {
        mainPage = new MainPage();
        mainPage.searchProduct("139605374");
    }

    @And("check book details and press 'В корзину' button")
    public void checkBookDetailsAndPressВRорзинуButton() {
        new ShoppingListPage().checkProductName("(2020)Хроники Нарнии (ил. П. Бейнс) / The Magician's Nephew (для всех серий)")
                .addProductToBasket()
                .checkProductPrice();
    }

    @And("press 'Корзина' button in header" )
    public void pressКорзинаButton() {
        mainPage.openBasketPage();
    }

    @And("check full Basket with the {string} and {string}")
    public void checkFullBasketWithTheAnd(String productName, String price) {
        basketPage = new BasketPage();
        basketPage.checkFullBasket(productName, price);
    }

    @Then("the product will be in basket and you can go to registration and close browser")
    public void theProductWillBeInBasketAndYouCanGoToRegistration() {
        basketPage.goToRegistration();
        driver.close();
    }
}
