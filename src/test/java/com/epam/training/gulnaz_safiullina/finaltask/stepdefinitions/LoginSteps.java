package com.epam.training.gulnaz_safiullina.finaltask.stepdefinitions;

import com.epam.training.gulnaz_safiullina.finaltask.page.LoginPage;
import com.epam.training.gulnaz_safiullina.finaltask.page.ProductPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private LoginPage loginPage;
    private ProductPage productPage;

    @Given("User is on the login page")
    public void openLoginPage() {
        loginPage = new LoginPage();
        loginPage.open();
    }

    @When("User enter the username {string} and the password {string}")
    public void loginWithCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should be redirected to the Products page")
    public void shouldSeePage() {
        productPage = new ProductPage();
        String actualTitle = productPage.getTitle();
        assertThat("Product page title should be 'Products'",
                    actualTitle, is("Products"));
    }

    @Then("User should see the error message {string}")
    public void shouldSeeErrorMessage(String errorMessage) {
        String actualError = loginPage.getErrorMessage();
        assertThat(String.format("Expected error message '%s' but got '%s'", errorMessage, actualError),
                actualError, is(errorMessage));
    }

}
