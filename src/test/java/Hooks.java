import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.StartingPage;


import static org.testng.Assert.assertTrue;

public class Hooks {
    static public WebDriver driver;

    @BeforeSuite
    public void initBefore() {
        setDriverProperty();
    }

    @BeforeMethod
    public void runBefore(){
       new BaseTest().openBrowser("https://www.ozon.ru/");
       System.out.println("Waiting for main page is loaded...");
       assertTrue(new StartingPage().entryOrRegister.isDisplayed());
    }

    private void setDriverProperty() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    }

}
