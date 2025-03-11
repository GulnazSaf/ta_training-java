package com.epam.training.gulnaz_safiullina.webdriver.task2.test;

import com.epam.training.gulnaz_safiullina.webdriver.task2.page.PasteBinMainPage;
import com.epam.training.gulnaz_safiullina.webdriver.task2.page.PasteBinPastePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
        void createPaste() throws InterruptedException {
            String pasteText =  "git config --global user.name  \"New Sheriff in Town\"\n" +
                                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                "git push origin master --force";
            String pasteTitle = "how to gain dominance among developers";
            String pasteSyntax = "Bash";
            String experationOption = "10 Minutes";

            PasteBinPastePage page = new PasteBinMainPage(driver).
                    openPage().
                    insertPasteText(pasteText).
                    chooseSyntax(pasteSyntax).
                    choosePasteExperationOption(experationOption).
                    insertPasteTitle(pasteTitle).
                    createPaste();

            Assertions.assertEquals(pasteTitle, page.getPageTitle());
            Assertions.assertEquals(pasteText, page.getPasteText());
            Assertions.assertEquals(pasteSyntax.toLowerCase(), page.getPasteSyntax().toLowerCase());

        }

        @AfterAll
        public static void browserTearDown() {
            driver.quit();
            driver = null;
        }
}
