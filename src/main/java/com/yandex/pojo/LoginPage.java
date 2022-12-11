package com.yandex.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static final By REGISTRATION_BUTTON = By.xpath(".//a[text()='Зарегистрироваться']");
    public static final By LOGIN_HEADER = By.xpath(".//h2[text()='Вход']");
    public static final By INPUT_EMAIL_LOG = By.xpath(".//fieldset[1]/div/div/input");
    public static final By INPUT_PASSWORD_LOG = By.xpath(".//fieldset[2]/div/div/input");

    public static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");


    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public void fillInputField(By inputField, String input) {
        driver.findElement(inputField).sendKeys(input);
    }
}
