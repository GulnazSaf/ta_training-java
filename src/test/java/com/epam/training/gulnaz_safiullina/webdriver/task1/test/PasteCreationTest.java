package com.epam.training.gulnaz_safiullina.webdriver.task1.test;

import com.epam.training.gulnaz_safiullina.webdriver.task1.page.PasteBinMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasteCreationTest {

    static WebDriver driver;

    @BeforeAll
    public static void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("PasteBin can be created")
    void createPaste() throws InterruptedException {
        new PasteBinMainPage(driver).
                openPage().
                insertPasteText("Hello from WebDrive").
                insertPasteTitle("helloweb").
                choosePasteExperationOption("10 Minutes").
                createPaste();
    }

    @AfterAll
    public static void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
