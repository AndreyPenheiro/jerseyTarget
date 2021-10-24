package step_definition;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

public class GroceryFeature {
    private static Logger LOGGER = LogManager.getLogger(GroceryFeature.class);
    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    private static final By ClickOnExploreAll = By.linkText("Explore all");
    private static final By ClickOnGrocery = By.id("5xt1a");
    private static final By GroceryTextVisible = By.xpath("//*[@id='mainContainer']/div[1]/div/div[1]/h1");
    WebDriver driver = Hooks.driver;

    @Given("User is on the Categories drop down")
    public void categoriesDropDown() {
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);
            ActOn.element(driver,Categories).click();
        LOGGER.info("User is on the Categories drop down"+ url);
    }
    @When("User clicks on the Grocery")
    public void categoriesGrocery() {
        ActOn.element(driver,ClickOnGrocery).click();
        LOGGER.info("User clicks on the Grocery");
    }
    @And("User clicks on explore all")
    public void clicksOnExploreAll() {
        ActOn.element(driver,ClickOnExploreAll).click();
        LOGGER.info("User clicks on explore all");
    }
    @Then("User is navigated to Grocery page")
    public void navigatedToGroceryPage() {
        ActOn.wait(driver,GroceryTextVisible).waitForElementToBeVisible();
        boolean titleGroceryIsVisible = driver.findElement(GroceryTextVisible).isDisplayed();
        Assert.assertTrue("Title Grocery is not visible",titleGroceryIsVisible);
        LOGGER.info("User is navigated to Grocery page");
    }
}
