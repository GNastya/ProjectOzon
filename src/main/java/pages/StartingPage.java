package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartingPage extends MainPage {
    @FindBy(css = "button[class='ui-k6 ui-n3']")
    public WebElement entryOrRegister;
}