package com.yandex.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    public static final By LOGIN_LINK_ON_FORGOT_PAGE = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }
}
