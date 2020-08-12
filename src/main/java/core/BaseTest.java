package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    static public WebDriver driver;

    public void openBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
}
