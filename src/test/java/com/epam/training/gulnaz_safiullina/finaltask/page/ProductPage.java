package com.epam.training.gulnaz_safiullina.finaltask.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@data-test='inventory-list']")
    private WebElement inventoryList;

    public ProductPage() {
        super();
        wait.until(ExpectedConditions.visibilityOf(inventoryList));
    }

    public String getTitle() {
        return pageTitle.getText();
    }

}
