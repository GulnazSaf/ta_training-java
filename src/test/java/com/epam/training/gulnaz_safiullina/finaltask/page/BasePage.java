package com.epam.training.gulnaz_safiullina.finaltask.page;

import com.epam.training.gulnaz_safiullina.finaltask.utils.LogUtil;
import com.epam.training.gulnaz_safiullina.finaltask.config.AppConfig;
import com.epam.training.gulnaz_safiullina.finaltask.config.ConfigManager;
import com.epam.training.gulnaz_safiullina.finaltask.driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.slf4j.Logger;
/**
 * Base class for all Page Objects
 */
public abstract class BasePage {

    protected final Logger logger = LogUtil.getLogger(getClass());
    protected static final AppConfig config = ConfigManager.getInstance();
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    protected BasePage() {
        this.driver = DriverManager.getInstance().getDriver(config.browser());
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(config.timeout()));
        PageFactory.initElements(driver, this);
    }
    
//     /**
//      * Converts the page object to LoginPage
//      * @return LoginPage instance
//      * @throws IllegalStateException if the current page is not a LoginPage
//      */
//     public LoginPage asLoginPage() {
//         if (this instanceof LoginPage) {
//             return (LoginPage) this;
//         }
//         throw new IllegalStateException("Current page is not a LoginPage");
//     }

//     /**
//      * Converts the page object to ProductPage
//      * @return ProductPage instance
//      * @throws IllegalStateException if the current page is not a ProductPage
//      */
//     public ProductPage asProductPage() {
//         if (this instanceof ProductPage) {
//             return (ProductPage) this;
//         }
//         throw new IllegalStateException("Current page is not a ProductPage");
//     }
}
