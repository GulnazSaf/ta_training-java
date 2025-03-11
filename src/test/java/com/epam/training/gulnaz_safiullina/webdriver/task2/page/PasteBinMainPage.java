package com.epam.training.gulnaz_safiullina.webdriver.task2.page;

import org.junit.jupiter.api.Assertions;
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
    private static final String MAIN_PAGE_TITLE = "Pastebin.com - #1 paste tool since 2002!";
    private static final String OPTION_XPATH = "//li[text() = '%s']";
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement pasteTextInput;

    @FindBy(id = "postform-name")
    private WebElement pasteTitleInput;

    @FindBy(xpath = "//button[text() = 'Create New Paste']")
    private WebElement createPasteButton;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expiraptionContainer;

    @FindBy(id = "select2-postform-expiration-results")
    private WebElement expirationOptions;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxContainer;

    @FindBy(id = "select2-postform-format-results")
    private WebElement syntaxOptions;


    public PasteBinMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinMainPage openPage() {
        driver.get(MAIN_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(driver -> ((JavascriptExecutor) driver).
                        executeScript("return document.readyState").equals("complete"));
        Assertions.assertEquals(MAIN_PAGE_TITLE, driver.getTitle(), "Pastebin main page is missing");
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
        chooseOption(expiraptionContainer, experationOption);
        return this;
    }

    public PasteBinMainPage chooseSyntax(String syntaxOption) {
        chooseOption(syntaxContainer, syntaxOption);
        return this;
    }

    public PasteBinPastePage createPaste () {
        createPasteButton.click();
        return new PasteBinPastePage(driver);
    }

    private void chooseOption(WebElement optionContainer, String option) {
        try {
            optionContainer.click();
            new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(optionContainer));
            String xpath = String.format(OPTION_XPATH, option);
            optionContainer.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to select option: "+ option, e);
        }
    }

}
