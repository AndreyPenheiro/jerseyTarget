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

public class GroceryCategories {
    WebDriver driver = Hooks.driver;
    private static final By ClickOnProduce = By.linkText("Produce");
    private static final By ClickOnbanana = By.id("mainContainer");
    private static final By ClickOnexploreAll = By.linkText("Explore all");
    private static final By ClickOngrocery = By.linkText("Grocery");
    private static final By CateGories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    private static final By ClickOnFreshfruits = By.id("mainContainer");
    private static Logger LOGGER = LogManager.getLogger(GroceryCategories.class);

    @Given("user is on the Grocery Page")
    public void groceryPageOpen (){
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);
        ActOn.element(driver,CateGories).click();
        ActOn.element(driver,ClickOngrocery).click();
        ActOn.element(driver,ClickOnexploreAll).click();
        LOGGER.info("user is on the Grocery Page" + url);
    }

    @When("User click on Produce")
    public void clickOnGivenCategories() {
        ActOn.wait(driver,ClickOnProduce).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnProduce).click();
        LOGGER.info("User click on Produce");
    }
    @And("User Clicks on Fresh Fruits")
    public void clickOnFreshFood () throws InterruptedException {
        Thread.sleep(5);
       // ActOn.wait(driver,ClickOnFreshFruits).waitForElementToBeVisible();
        ActOn.wait(driver,ClickOnFreshfruits).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnFreshfruits).click();
        LOGGER.info("User Clicks on Fresh Fruits");
    }
    @Then("user clicks on banana")
    public void clicksOnBanana() throws InterruptedException {
        Thread.sleep(10);
        ActOn.wait(driver,ClickOnbanana).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnbanana).click();
        LOGGER.info("user clicks on banana");
    }
    /*@Then("user click on the Quantity to add Quantity")
    public void clicksOnQuantityOrPickItUp() {
        //ActOn.element(driver,CLickOnQty).click();
        //ActOn.element(driver,ClickOnQtyTwo).click();
        ActOn.wait(driver,ClickOnPickItUP).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnPickItUP).click();
        ActOn.wait(driver,ClickOnContinueShopping).waitForElementToBeVisible();
        ActOn.element(driver,ClickOnContinueShopping).click();
        LOGGER.info("user click on the Quantity to add Quantity");
    }*/
}
