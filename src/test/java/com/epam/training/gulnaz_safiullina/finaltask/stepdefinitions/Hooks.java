package com.epam.training.gulnaz_safiullina.finaltask.stepdefinitions;

import com.epam.training.gulnaz_safiullina.finaltask.config.AppConfig;
import com.epam.training.gulnaz_safiullina.finaltask.config.ConfigManager;
import com.epam.training.gulnaz_safiullina.finaltask.driver.DriverManager;
import com.epam.training.gulnaz_safiullina.finaltask.utils.LogUtil;
import com.epam.training.gulnaz_safiullina.finaltask.utils.ScrenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class Hooks {

    private static AppConfig config;
    private static final Logger logger = LogUtil.getLogger(Hooks.class);
    private WebDriver driver;

    @BeforeAll
    public static void setupConfig() {
        config = ConfigManager.getInstance();
    }

    @Before(order=0)
    public void setUp(Scenario scenario) {
        logger.info("Starting scenario: {}", scenario.getName());
        driver = DriverManager.getInstance().getDriver(config.browser());
        
    }

    @After(order=0)
    public void tearDown(Scenario scenario) {
        logger.info("Tearing down scenario: {}", scenario.getName());
        if (driver != null) {
            DriverManager.getInstance().quitDriver();
        }
    }

    @After(order=1)
    public void screenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            ScrenshotUtil.captureScreenshot(driver, scenario.getName());
        }
    }


}
