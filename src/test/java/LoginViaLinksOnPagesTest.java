import com.yandex.pojo.ForgotPasswordPage;
import com.yandex.pojo.LoginPage;
import com.yandex.pojo.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.yandex.pojo.ForgotPasswordPage.LOGIN_LINK_ON_FORGOT_PAGE;
import static com.yandex.pojo.LoginPage.*;
import static com.yandex.pojo.MainPage.ORDER_BUTTON_IN_BODY;
import static com.yandex.pojo.RegistrationPage.LOGIN_LINK;
import static org.junit.Assert.assertTrue;

@DisplayName("Вход через линки на других страницах")
public class LoginViaLinksOnPagesTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        driver = BaseTest.getWebDriver("Chrome");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @DisplayName("Вход через линку в форме регистрации")
    @Test
    public void loginViaLinkOnRegistrationPage() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnElement(LOGIN_LINK);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(INPUT_EMAIL_LOG);
        loginPage.fillInputField(INPUT_EMAIL_LOG, "test123456@test.com");

        loginPage.clickOnElement(INPUT_PASSWORD_LOG);
        loginPage.fillInputField(INPUT_PASSWORD_LOG, "123456");

        loginPage.clickOnElement(LOGIN_BUTTON);

        Thread.sleep(3000);

        assertTrue(driver.findElement(ORDER_BUTTON_IN_BODY).isDisplayed());
    }

    @DisplayName("Вход через линку в форме восстановления пароля")
    @Test
    public void loginViaLinkOnForgotPasswordPage() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickOnElement(LOGIN_LINK_ON_FORGOT_PAGE);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(INPUT_EMAIL_LOG);
        loginPage.fillInputField(INPUT_EMAIL_LOG, "test123456@test.com");

        loginPage.clickOnElement(INPUT_PASSWORD_LOG);
        loginPage.fillInputField(INPUT_PASSWORD_LOG, "123456");

        loginPage.clickOnElement(LOGIN_BUTTON);

        Thread.sleep(3000);

        assertTrue(driver.findElement(ORDER_BUTTON_IN_BODY).isDisplayed());
    }
}
