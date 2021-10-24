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

public class HouseholdEssentials {
    private static final By MainMenuVisible = By.xpath("//*[@id='overlay-2']//*[text()='Main Menu']");
    private static final By ClickHouseholdEssential = By.xpath("//*[@id='5xsz1']//*[text()='Household Essentials']");
    private static final By ClickOnExploreAll = By.linkText("Explore all");
    private static final By HouseholdEssentialVisible = By.xpath("//*[@id='mainContainer']/div[1]//div[1]/h1");
    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    WebDriver driver = Hooks.driver;
    private static Logger LOGGER = LogManager.getLogger(HouseholdEssentials.class);

    @Given("a user is on the Categories drop down")
    public void categoriesDropDownOpen() {
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);
        ActOn.element(driver,Categories).click();
        LOGGER.info("User is on categories drop down" + url);
    }

    @When("user clicks on the Household Essentials")
    public void clicksOnHouseholdEssential() {
        ActOn.element(driver,ClickHouseholdEssential).click();
        LOGGER.info("user clicks on the Household Essentials");
    }
    @And("user clicks on Explore all")
    public void clickExploreAll() {
        ActOn.element(driver,ClickOnExploreAll).click();
        LOGGER.info("user clicks on Explore all");
    }
    @Then("user is navigated to Household Essentials page")
    public void navigatedToHouseholdEssential() {
        ActOn.wait(driver,HouseholdEssentialVisible).waitForElementToBeVisible();
        boolean householdEssentialVisible =  driver.findElement(HouseholdEssentialVisible).isDisplayed();
        Assert.assertTrue("Household Essential is not displayed", householdEssentialVisible);
        LOGGER.info("user is navigated to Household Essentials page");
    }

}
