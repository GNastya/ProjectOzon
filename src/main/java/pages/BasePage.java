package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static core.BaseTest.driver;


public class BasePage {
    public BasePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
}
