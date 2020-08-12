package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;
import static core.BaseTest.driver;

public class CommonScenarios {
    public static final long timeOutInSeconds = 20;
    public static final long sleepInMillis = 100;

    public static void waitUntil(Function<? super WebDriver, Boolean> expectedCondition) {
        (new WebDriverWait(driver, timeOutInSeconds, sleepInMillis)).until(expectedCondition);
    }

}
