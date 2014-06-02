/**
 * 
 */
package com.blizzardtec.ui;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * @author Barnaby Golden
 * 
 */
public final class LoginSteps {

    /**
     * Timeout.
     */
    private static final int TIMEOUT = 10;
    /**
     * Driver.
     */
    private WebDriver driver;

    /**
     * Setup.
     */
    @Before
    public void setUp() {

        final DesiredCapabilities capabilities = DesiredCapabilities
                .internetExplorer();
        capabilities
                .setCapability(
                        InternetExplorerDriver
                        .INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                        true);

        final File file = new File(
                "C:\\docs\\workspace\\spring-mvc-webapp"
                        + "\\src\\test\\resources\\IEDriverServer.exe");

        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

        driver = new InternetExplorerDriver(capabilities);

        driver.get("http://localhost:8080/login.go");
    }

    /**
     * Given.
     * @param arg1 param
     * @param arg2 param
     * @throws Throwable thrown
     */
    @Given("^the username is \"([^\"]*)\" and the password is \"([^\"]*)\"$")
    public void theUsernameIsAndThePasswordIs(
            final String arg1, final String arg2)
            throws Throwable {

        // Find the text input element by its name
        WebElement element = driver.findElement(By.id("username"));

        // Enter something to search for
        element.sendKeys(arg1);

        element = driver.findElement(By.id("pwd"));

        element.sendKeys(arg2);
    }

    /**
     * When.
     * @throws Throwable thrown
     */
    @When("^the login button is clicked$")
    public void theLoginButtonIsClicked() throws Throwable {

        final WebElement loginButton = driver.findElement(By.id("login"));

        loginButton.sendKeys(Keys.ENTER);

        (new WebDriverWait(driver, TIMEOUT)).until(
                ExpectedConditions.stalenessOf(loginButton));
    }

    /**
     * Welcome page.
     * @throws Throwable thrown
     */
    @Then("^the welcome page is shown$")
    public void theWelcomePageIsShown() throws Throwable {

        assertEquals(
           "Welcome page title invalid", "Welcome", driver.getTitle());
    }

    /**
     * Error shown.
     * @throws Throwable thrown
     */
    @Then("^an error should be shown$")
    public void anErrorShouldBeShown() throws Throwable {

        assertEquals(
           "Error page title invalid", "Error", driver.getTitle());
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
