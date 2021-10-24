package step_definition;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.experimental.max.MaxCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

public class AddToCartGrocery {
    private static Logger LOGGER = LogManager.getLogger(AddToCartGrocery.class);
    private static final By ClickOnExploreAll = By.linkText("Explore all");
    private static final By ClickOnGrocery = By.linkText("Grocery");
    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    private static final By ClickOnCandy = By.linkText("Candy");
    private static final By ClickOnContinueShopping = By.xpath("/html/body/div[15]//div[3]/div[1]/button");
    private static final By SearchByCandyCode = By.id("search");
    private static final By CLickOnAddToCartCandy = By.xpath("//*[@id='mainContainer']/div[4]/div[2]//div[2]/div[3]/div[2]//div[2]//div[5]/div[1]//button");
    private static final By ClickOnSearchButton = By.xpath("//*[@id='headerMain']/div[1]//button[2]");
    WebDriver driver = Hooks.driver;

    @Given("User is on the Grocery page")
    public void isOnGroceryPage() {
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);
        ActOn.element(driver,Categories).click();
        ActOn.element(driver,ClickOnGrocery).click();
        ActOn.element(driver,ClickOnExploreAll).click();
        LOGGER.info("User is on the Grocery page"+url);
    }
    @When("User click on Candy")
    public void clicksOnAddToCandy() {
       ActOn.wait(driver,ClickOnCandy).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnCandy).click();
        ActOn.wait(driver,SearchByCandyCode).waitForElementToBeVisible();
        ActOn.element(driver,SearchByCandyCode).setValue("82557906");
        ActOn.element(driver,ClickOnSearchButton).click();
        LOGGER.info("User click on Candy");
    }
    @And("User click on Add to Cart")
    public void clicksOnAddToCartCandy() {
        ActOn.element(driver,CLickOnAddToCartCandy).click();
        LOGGER.info("User click on Add to Cart");
    }
    @Then("User click on Continue Shopping")
    public void selectContinueShopping() {
        ActOn.element(driver,ClickOnContinueShopping).click();
        LOGGER.info("User click on Continue Shopping");
    }
}
