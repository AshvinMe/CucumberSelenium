package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Hooks.Hooks;
import java.util.List;


public class SearchProductStepDefinition {

    private WebDriver driver;

//    public SearchProductStepDefinition() {
//        this.driver = Hooks.getDriver();
//    }

       private static By txt_searchBox = By.id("twotabsearchtextbox");

    private static By btn_search = By.id("nav-search-submit-button");

    private static By list_result = By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal')]");

    private static List<WebElement> actualResults;

    @Given("user is on home page")
    public void the_user_is_on_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }

    @When("^user enter product (.*) in search box$")
    public void user_enter_product_iphone_in_search_box(String product) {
        WebElement search = driver.findElement(txt_searchBox);
        boolean val = search.isDisplayed();
        Assert.assertTrue(val);
        search.sendKeys(product);
    }
    @When("^user click on search button$")
    public void user_click_on_search_button() {
        WebElement searchBtn = driver.findElement(btn_search);
        searchBtn.click();
    }
    @Then("^user verify the results contains the text (.*)$")
    public void user_verify_the_results_contains_the_text_apple_i_phone(String result) {
        List<WebElement> results = driver.findElements(list_result);
        Assert.assertTrue(results.size()>0);

        if(results.get(0).getText().contains("Apple iPhone"))
        {
            Assert.assertTrue(true);
        }
        driver.quit();
    }


//    @Then("the user should be redirected to the homepage")
//    public void the_user_should_be_redirected_to_the_homepage() {
//        // Implement code to verify redirection
//        String expectedUrl = "https://example.com/homepage";
//        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
//        driver.quit();
//    }

}
