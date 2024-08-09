package Hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
