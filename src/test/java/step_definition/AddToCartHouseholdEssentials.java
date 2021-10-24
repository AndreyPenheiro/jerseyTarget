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


public class AddToCartHouseholdEssentials {
    private static Logger LOGGER = LogManager.getLogger(AddToCartHouseholdEssentials.class);
    private static final By ClickHouseholdEssential = By.xpath("//*[@id='5xsz1']//*[text()='Household Essentials']");
    private static final By ClickOnExploreAll = By.linkText("Explore all");
    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    private static final By SearchItemCode = By.id("search");
    private static final By ClickOnSearchbutton = By.xpath("//*[@id='headerMain']/div[1]//button[2]");
    private static final By ClickOnPickItUP =By.xpath("//*[@id='viewport']/div[4]//div[2]/div[3]/div[1]/div/div[1]/div/div[1]/div[2]/button");
    private static final By ClickOnContinueShopping = By.xpath("/html/body/div[20]/div/div/div//div[3]/div[1]/button");
    private static final By ClickOnSearcedItem = By.xpath("//*[@id='mainContainer']/div[4]/div[2]//div[2]/div[3]/div[2]//div/div[2]/div/div/div/div[1]/div[1]");
    WebDriver driver = Hooks.driver;

    @Given("User is on the Household Essentials page")
    public void householdEssentialPageOpen() {
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);
        ActOn.element(driver,Categories).click();
        ActOn.element(driver,ClickHouseholdEssential).click();
        ActOn.element(driver,ClickOnExploreAll).click();
        LOGGER.info("User is on the Household Essentials page" + url);
    }
    @When("user search item by name or code")
    public void clickOnSearchToSearchByCode() {
        ActOn.element(driver,SearchItemCode).click();
        ActOn.element(driver,SearchItemCode).setValue("84780734");
        ActOn.element(driver,ClickOnSearchbutton).click();
        LOGGER.info("user search item by name or code");
    }
    @And("user click on Add For Pickup")
    public void clickOnAddForPickup() {
        ActOn.wait(driver,ClickOnSearcedItem).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnSearcedItem).click();
        ActOn.element(driver,ClickOnPickItUP).click();
        LOGGER.info("user click on Add For Pickup");
    }
    @Then("User click on continue shopping")
    public void selectOnViewCartAndCheckout() {
        ActOn.element(driver,ClickOnContinueShopping).click();
        LOGGER.info("User click on continue shopping");
    }
}
