package ru.yandex.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    public static final By PROFILE_LINK = By.xpath(".//a[text()='Профиль']");
    public static final By CONSTRUCTOR_LINK = By.xpath(".//p[text()='Конструктор']");
    public static final By LOGOUT_LINK = By.xpath(".//button[text()='Выход']");
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }
}
