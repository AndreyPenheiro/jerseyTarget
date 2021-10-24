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

public class SameDayDelivery {
    private static Logger LOGGER = LogManager.getLogger(SameDayDelivery.class);
    private static final By ClickOnSameDayDelivery = By.xpath("//*[@id='mainContainer']/div[8]//div//div[2]/a/div[1]//div[2]");
    private static final By SearchByName = By.xpath("//*[@id='mainContainer']/div[2]//div[3]//input");
    private static final By ClickOnSearch = By.xpath("//*[@id='mainContainer']/div[2]/div/div[3]/div/button");
    private static final By ClickOnExploreAll = By.linkText("Explore all");
    private static final By ClickOnGrocery = By.linkText("Grocery");
    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    WebDriver driver = Hooks.driver;

    @Given("a user is on the Grocery Page")
    public void groceryPage(){
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);;
        ActOn.element(driver,Categories).click();
        ActOn.element(driver,ClickOnGrocery).click();
        ActOn.element(driver,ClickOnExploreAll).click();
        LOGGER.info("a user is on the Grocery Page" + url);
    }
    @When("user clicks on the same day delivery feature")
    public void clickOnSameDaYDelivery() {
        ActOn.element(driver, ClickOnSameDayDelivery).click();
        LOGGER.info("user clicks on the same day delivery feature");
    }
    @And("User enters items name to search")
    public void searchItemName() {
        ActOn.element(driver,SearchByName).setValue("water");
        LOGGER.info("User enter items name to search");
    }
    @Then("User click on the search button")
    public void clicksSearchButton() {
        ActOn.element(driver,ClickOnSearch).click();
        LOGGER.info("User click on the search button");
    }
    /*("user clicks on the searched items")
    public void clickOnTheSearchedItem() {
        ActOn.element(driver,ClickOnSearchedItem).click();
        LOGGER.info("user clicks on the searched items");
    }*/
}
