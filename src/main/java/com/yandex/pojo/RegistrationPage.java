package com.yandex.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    public static final By INPUT_NAME = By.xpath(".//fieldset[1]/div/div/input");
    public static final By INPUT_EMAIL = By.xpath(".//fieldset[2]/div/div/input");
    public static final By INPUT_PASSWORD = By.xpath(".//fieldset[3]/div/div/input");
    public static final By REGISTRATION_BUTTON1 = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By PASSWORD_ERROR = By.xpath(".//p[contains(@class,'input__error') and text()='Некорректный пароль']");
    public static final By LOGIN_LINK = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public void fillInputField(By inputField, String input) {
        driver.findElement(inputField).sendKeys(input);
    }
}
