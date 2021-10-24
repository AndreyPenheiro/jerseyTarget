package step_definition;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import static java.awt.SystemColor.window;

public class HouseholdEssentialsCategories {
    private static final By ClickOnLaundryCare = By.linkText("Laundry Care");
    private static final By ClickHouseholdEssential = By.xpath("//*[@id='5xsz1']//*[text()='Household Essentials']");
    private static final By ClickOnExploreAll = By.linkText("Explore all");
    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    private static final By ClickOnPickItUP =By.xpath("/html/body/div[16]/div/div/div/div/div/div/div[6]/div/div[1]/div/div[1]/div[2]/button");
    private static final By ClickOnContinueShopping = By.xpath("/html/body/div[20]/div/div/div//div[3]/div[1]/button");
    private static final By SearchItemCode = By.id("search");
    private static final By NewWindow = By.xpath("/html/body/div[16]/div/div/div/div/div/div");
    private static final By ClickOnSearchbutton = By.xpath("//*[@id='headerMain']/div[1]//button[2]");
    private static final By ClickOnChooseOption = By.xpath("//*[@id='mainContainer']/div[4]/div[2]/div/div[2]/div[3]/div[2]//div[5]/div[1]//button");
    WebDriver driver = Hooks.driver;
    private static Logger LOGGER = LogManager.getLogger(HouseholdEssentials.class);

    @Given("user is on the Household Essentials Page")
    public void householdEssentialPage () {
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);
        ActOn.element(driver,Categories).click();
        ActOn.element(driver,ClickHouseholdEssential).click();
        ActOn.element(driver,ClickOnExploreAll).click();
        LOGGER.info("user is on the Household Essentials Page" + url);
    }
    @When("user click on Laundry Care")
    public void clickOnLaundryCare() {
        ActOn.wait(driver,ClickOnLaundryCare).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnLaundryCare).click();
        LOGGER.info("user click on Laundry Care");
    }
    @Then ("user clicks on All Free")
    public void clicksOnAllFree() {
        ActOn.element(driver,SearchItemCode).click();
        ActOn.element(driver,SearchItemCode).setValue("84036660");
        ActOn.element(driver,ClickOnSearchbutton).click();
        LOGGER.info("user clicks on All Free");
    }
    /*@Then("user click on the pick it up and continue shopping")
    public void clicksOnQtyOne() {
        ActOn.element(driver,ClickOnChooseOption).click();
        //driver.switchTo().alert().accept();
        Alert alt = driver.switchTo().alert();
        alt.
        //ActOn.element(driver,alt).click();
        ActOn.element(driver,ClickOnPickItUP).click();
        ActOn.element(driver,ClickOnContinueShopping).click();
        LOGGER.info("user click on the pick it up and continue shopping");
    }*/
}
