package com.epam.training.gulnaz_safiullina.finaltask.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object representing the login page of the Sauce Demo application.
 */
public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@data-test = 'username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@data-test = 'password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@data-test = 'login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test = 'error']")
    private WebElement errorMessage;

    public LoginPage() {
        super();
    }

    /**
     * Opens the login page.
     */
    public void open() {
        String baseUrl = config.baseUrl();
        logger.info("Opening login page at: {}", baseUrl);
        driver.get(baseUrl);
    }

    /**
     * Enters the username into the username field.
     *
     * @param username the username to enter
     */
    private void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    /**
     * Enters the password into the password field.
     *
     * @param password the password to enter
     */
    private void enterPassword(String password) {
        logger.info("Entering password: {}", password);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    private void clickLoginButton() {
        logger.info("Clicking login button");
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    /**
     * Gets the error message text when login fails.
     *
     * @return the error message text
     * @throws TimeoutException if the error message doesn't appear within the timeout period
     */
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    // /**
    //  * Checks if the error message is displayed.
    //  *
    //  * @return true if error message is displayed, false otherwise
    //  */
    // private boolean isErrorMessageDisplayed() {
    //     try {
    //         wait.until(ExpectedConditions.visibilityOf(errorMessage));
    //         return errorMessage.isDisplayed();
    //     } catch (TimeoutException e) {
    //         logger.info("Error message not displayed within timeout period");
    //         return false;
    //     }
    // }

    /**
     * Attempts to login with the provided credentials.
     *
     * @param username the username to use
     * @param password the password to use
     */
    public void login(String username, String password) {
        logger.info("Attempting login with username: '{}' and password: '{}'", username, password.isEmpty() ? "[EMPTY]" : "[MASKED]");
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();

        // if (isErrorMessageDisplayed()) {
        //     String error = getErrorMessage();
        //     logger.info("Login failed with error: {}", error);
        //     return this;
        // } else {
        //     logger.info("Login successful, redirecting to ProductPage");
        //     ProductPage productPage = new ProductPage();
        //     wait.until(ExpectedConditions.urlContains("/inventory.html"));
        //     return productPage;
        // }
    }

}
