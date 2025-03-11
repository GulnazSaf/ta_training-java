package com.epam.training.gulnaz_safiullina.webdriver.task2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class PasteBinPastePage {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'source')]")
    WebElement pasteText;

    public PasteBinPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageToLoad();
    }

    public String getPageTitle() {
        return driver.getTitle().replace(" - Pastebin.com", "");
    }

    public String getPasteText() {

        List<WebElement> listItems = pasteText.findElements(By.tagName("li"));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < listItems.size(); i++) {
            result.append(listItems.get(i).getText());
            if (i < listItems.size() - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }

    public String getPasteSyntax() {
        return Objects.requireNonNull(pasteText.getDomAttribute("class")).
                replace("source ", "");
    }

    private void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(pasteText)); // Wait for the paste title to be visible
    }

}

