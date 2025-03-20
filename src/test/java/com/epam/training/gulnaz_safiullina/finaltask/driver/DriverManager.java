package com.epam.training.gulnaz_safiullina.finaltask.driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
    private static DriverManager instance;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver(String browser) {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = createDriver(browser);
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }

    private WebDriver createDriver(String browser) {
        try {
            BrowserFactory browserFactory = BrowserFactory.valueOf(browser.toUpperCase());
            WebDriver driver = browserFactory.createDriver();
            driver.manage().deleteAllCookies();
            logger.info("Created new {} driver instance", browser);
            return driver;
        } catch (IllegalArgumentException e) {
            logger.error("Unsupported browser type: {}", browser);
            throw new IllegalArgumentException("Unsupported browser " + browser, e);
        }
    }

    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            try {
                driver.quit();
                logger.info("WebDriver instance successfully quit");
            } catch (Exception e) {
                logger.error("Error while quitting WebDriver", e);
            } finally {
                driverThreadLocal.remove();
            }
        }
    }
}