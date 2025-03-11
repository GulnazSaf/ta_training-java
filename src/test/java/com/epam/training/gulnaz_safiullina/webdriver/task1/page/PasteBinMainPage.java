package com.epam.training.gulnaz_safiullina.webdriver.task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinMainPage {

    private static final String MAIN_PAGE_URL = "https://pastebin.com/";
    private static final String EXPIRATION_OPTION_XPATH = "//ul[@id='select2-postform-expiration-results']/li[text() = '%s']";
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private WebDriver driver;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expiraptionContainer;

    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']")
    private WebElement expirationOptions;

    @FindBy(id = "postform-text")
    private WebElement pasteTextInput;

    @FindBy(id = "postform-name")
    private WebElement pasteTitleInput;


    @FindBy(xpath = "//button[text() = 'Create New Paste']")
    private WebElement createPasteButton;

    public PasteBinMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinMainPage openPage() {
        driver.get(MAIN_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver -> ((JavascriptExecutor) driver).
                        executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public PasteBinMainPage insertPasteText(String text) {
        pasteTextInput.sendKeys(text);
        return this;
    }

    public PasteBinMainPage insertPasteTitle(String title) {
        pasteTitleInput.sendKeys(title);
        return this;
    }

    public PasteBinMainPage choosePasteExperationOption(String experationOption) {
        try {
            expiraptionContainer.click();
            new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(expirationOptions));
            String xpath = String.format(EXPIRATION_OPTION_XPATH, experationOption);
            expirationOptions.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to select expiration option: " + experationOption, e);
        }
        return this;
    }

    public void createPaste () {
        createPasteButton.click();
    }

}
