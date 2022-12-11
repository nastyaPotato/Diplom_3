package com.yandex.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final By LOGIN_BUTTON_IN_BODY = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By ORDER_BUTTON_IN_BODY = By.xpath(".//button[text()='Оформить заказ']");
    public static final By LOGIN_BUTTON_IN_HEADER = By.xpath(".//header/nav/a");
    public static final By BURGER_HEADER = By.xpath(".//h1[text()='Соберите бургер']");
    public static final By BUN_LINK = By.xpath(".//main/section[1]/div[1]/div[1]");
    public static final By SOUSES_LINK = By.xpath(".//main/section[1]/div[1]/div[2]");
    public static final By FILLING_LINK = By.xpath(".//main/section[1]/div[1]/div[3]");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }
}
