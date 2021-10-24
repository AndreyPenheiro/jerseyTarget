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

public class CategoriesDropdown {

    private static final By Categories = By.xpath("//*[@id='categories']//*[text()='Categories']");
    private static final By CategoriesVisible = By.linkText("Categories");
    private static final By MainMenuVisible = By.linkText("Main Menu");
    private static final By OnHomePage = By.xpath("//*[@id='header']/div[1]/div[2]//div[1]//li[1]");
    private static Logger LOGGER = LogManager.getLogger(CategoriesDropdown.class);
    WebDriver driver=Hooks.driver;

    @Given("A user is on the Home Page")
    public void homePageOpen() {
        String url = ReadConfigFiles.getPropertyValues("TargetUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("A user is on the Home Page" + url);
    }

    @When("User sees the Categories drop down")
    public void homeCategoriesClick() {
        boolean categoriesVisible = driver.findElement(CategoriesVisible).isDisplayed();
        Assert.assertTrue("Category is not visible",categoriesVisible);
        LOGGER.info("User sees the Categories drop down");
    }

    @And("User clicks on the Categories")
    public void clickOnCategoriesDD() {
        ActOn.element(driver,Categories).click();
        LOGGER.info("User clicks on the Categories");
    }

    @Then("Drop down opens")
    public void categoriesDropDownOpen() {
        boolean mainMenuDisplayed = driver.findElement(MainMenuVisible).isDisplayed();
        Assert.assertTrue("Main Menu is not displayed",mainMenuDisplayed);
        LOGGER.info("Drop down opens");
    }
}
