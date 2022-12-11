import ru.yandex.pojo.LoginPage;
import ru.yandex.pojo.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.pojo.LoginPage.*;
import static ru.yandex.pojo.MainPage.*;
import static org.junit.Assert.assertTrue;

@DisplayName("Вход через кнопки на главной странице")
@RunWith(Parameterized.class)
public class LoginOnMainTest {
    private final String email;
    private final String password;
    private final By expectedResult;
    private final By loginButton;
    private WebDriver driver;

    public LoginOnMainTest(By loginButton, String email, String password, By expectedResult) {
        this.loginButton = loginButton;
        this.email = email;
        this.password = password;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getInputs() {
        return new Object[][]{
                //в случае успешного логина кнопка войти на главной меняется на кнопку оформить заказ
                {LOGIN_BUTTON_IN_BODY, "test123456@test.com", "123456", ORDER_BUTTON_IN_BODY},
                {LOGIN_BUTTON_IN_HEADER, "test123456@test.com", "123456", ORDER_BUTTON_IN_BODY},
        };
    }

    @Before
    public void startUp() {
        driver = BaseTest.getWebDriver("Yandex");
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка логина черз кнопки на главной странице")
    public void loginViaDifferentButtonsOnMain() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(loginButton);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(INPUT_EMAIL_LOG);
        loginPage.fillInputField(INPUT_EMAIL_LOG, email);

        loginPage.clickOnElement(INPUT_PASSWORD_LOG);
        loginPage.fillInputField(INPUT_PASSWORD_LOG, password);

        loginPage.clickOnElement(LOGIN_BUTTON);

        Thread.sleep(3000);

        assertTrue(driver.findElement(expectedResult).isDisplayed());
    }
}
