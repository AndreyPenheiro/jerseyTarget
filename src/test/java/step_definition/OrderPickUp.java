package step_definition;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

public class OrderPickUp {
    private static final By ClickOnOrderPickup = By.xpath("//*[@id='mainContainer']/div[8]/div/div/div/div[3]/a/div[1]/div/div/div/div[2]");
    private static final By ClickOnSearchOrder = By.xpath("//*[@id='mainContainer']/div[2]/div/div[4]/div/input");
    private static final By ClickOnSearch = By.id("mainContainer");
    private static final By ClickOnExploreAll = By.linkText("Explore all");
    private static final By ClickOnGrocery = By.linkText("Grocery");
    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    WebDriver driver = Hooks.driver;
    private static Logger LOGGER = LogManager.getLogger(OrderPickUp.class);

    @Given("User is on the Grocery Page")
    public void onGroceryPageOpen(){
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);;
        ActOn.element(driver,Categories).click();
        ActOn.element(driver,ClickOnGrocery).click();
        ActOn.element(driver,ClickOnExploreAll).click();
        LOGGER.info("User is on the Grocery Page" + url);
    }
    @When("user clicks on the order pick up")
    public void clickOnOrderPickUp() {
        ActOn.element(driver,ClickOnOrderPickup).click();
        LOGGER.info("user clicks on the order pick up");
    }
    @And("user enters items name to search")
    public void searchItemByName() {
        ActOn.element(driver,ClickOnSearchOrder).setValue("water");
        LOGGER.info("user enter items name to search");
    }
    @Then("user click on the Search button")
    public void clicksOnSearchButton() {
        ActOn.element(driver,ClickOnSearch).click();
        LOGGER.info("user click on the Search button");
    }

    /*@Then("user clicks on the Searched items")
    public void clickOnWater() {
        ActOn.wait(driver,ClickOnTheWater).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnTheWater).click();
        LOGGER.info("user clicks on the Searched items");
    }*/
}
