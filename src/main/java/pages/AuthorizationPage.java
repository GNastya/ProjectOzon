package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {
    @FindBy(id = "authFrame")
    public WebElement iFrame;
}
