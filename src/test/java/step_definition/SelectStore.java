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

public class SelectStore {
    WebDriver driver = Hooks.driver;
    private static final By ClickOnYoureShopping = By.id("storeId-utilityNavBtn");
    private static final By SelectZipCode = By.id("zipOrCityState");
    private static final By ClickOnLookUp = By.xpath("/html/body/div[9]/div/div/div/div/div[1]/div/div[3]/div[2]/button");

        private static Logger LOGGER = LogManager.getLogger(SelectStore.class);

        @Given("a user is on the home page")
        public void homePage() {
            String url = ReadConfigFiles.getPropertyValues("TargetUrl");
            ActOn.browser(driver).openBrowser(url);;
            LOGGER.info("User is on the Home page");
        }
    @When("user clicks on You're shopping")
    public void clickOnYouShopping() {
        ActOn.element(driver,ClickOnYoureShopping).click();
        LOGGER.info("user clicks on You're shopping");
    }

    @And("user enters the zip code or city,state")
    public void enterZipCode () {
        ActOn.element(driver,SelectZipCode).click();
            ActOn.element(driver,SelectZipCode).setValue("07305");
        LOGGER.info("user enters the zip code or city,state");
    }

    @Then("User clicks on look up")
    public void clickOnLookUp() {
            ActOn.element(driver,ClickOnLookUp).click();
        LOGGER.info("User clicks on look up");
    }
}
