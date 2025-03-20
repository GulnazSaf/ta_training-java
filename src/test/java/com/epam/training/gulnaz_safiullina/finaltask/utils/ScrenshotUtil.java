package com.epam.training.gulnaz_safiullina.finaltask.utils;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class ScrenshotUtil {

    private static final Logger logger = LogUtil.getLogger(ScrenshotUtil.class);
    private static final String SCREENSHOT_DIR = "target/screenshots/";

    static {
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        } catch (IOException e) {
            logger.error("Failed to create screenshot directory: {}", SCREENSHOT_DIR, e);
        }
    }


    public static void captureScreenshot(WebDriver driver, String testName) {
        if (driver instanceof TakesScreenshot) {
            try {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
                String screenshotName = testName.replaceAll("[^a-zA-Z0-9.-]", "_") + "_" + timestamp + ".png";
                Path screenshotPath = Paths.get(SCREENSHOT_DIR, screenshotName);

                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(screenshotFile.toPath(), screenshotPath, StandardCopyOption.REPLACE_EXISTING);
                logger.info("Screenshot captured: {}", screenshotPath);
            } catch (IOException e) {
                logger.error("Failed to capture screenshot: {}", testName, e);
            }
        } else {
            logger.warn("WebDriver does not support taking screenshots: {}", driver.getClass().getSimpleName());
        }
    }
}
