import com.yandex.pojo.LoginPage;
import com.yandex.pojo.MainPage;
import com.yandex.pojo.PersonalAccountPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.yandex.pojo.LoginPage.*;
import static com.yandex.pojo.MainPage.BURGER_HEADER;
import static com.yandex.pojo.MainPage.LOGIN_BUTTON_IN_HEADER;
import static com.yandex.pojo.PersonalAccountPage.*;
import static org.junit.Assert.assertTrue;

@DisplayName("Переход в личный кабинет и из личного кабинета")
public class PersonalAccountTest {

    private WebDriver driver;

    @Before
    public void startUp() {
        driver = BaseTest.getWebDriver("Chrome");
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @DisplayName("Переход в личный кабинет по кнопке личного кабинета")
    @Test
    public void transitionToPersonalAccount() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(LOGIN_BUTTON_IN_HEADER);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(INPUT_EMAIL_LOG);
        loginPage.fillInputField(INPUT_EMAIL_LOG, "test123456@test.com");

        loginPage.clickOnElement(INPUT_PASSWORD_LOG);
        loginPage.fillInputField(INPUT_PASSWORD_LOG, "123456");

        loginPage.clickOnElement(LOGIN_BUTTON);

        mainPage.clickOnElement(LOGIN_BUTTON_IN_HEADER);

        Thread.sleep(3000);

        assertTrue(driver.findElement(PROFILE_LINK).isDisplayed());

    }

    @DisplayName("Переход в конструктор из личного кабинета")
    @Test
    public void transitionFromPersonalAccountToConstructor() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(LOGIN_BUTTON_IN_HEADER);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(INPUT_EMAIL_LOG);
        loginPage.fillInputField(INPUT_EMAIL_LOG, "test123456@test.com");

        loginPage.clickOnElement(INPUT_PASSWORD_LOG);
        loginPage.fillInputField(INPUT_PASSWORD_LOG, "123456");

        loginPage.clickOnElement(LOGIN_BUTTON);

        mainPage.clickOnElement(LOGIN_BUTTON_IN_HEADER);

        Thread.sleep(3000);

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickOnElement(CONSTRUCTOR_LINK);

        assertTrue(driver.findElement(BURGER_HEADER).isDisplayed());

    }

    @DisplayName("Выход по кнопке в личном кабинете")
    @Test
    public void logoutOnPersonalAccountPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(LOGIN_BUTTON_IN_HEADER);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(INPUT_EMAIL_LOG);
        loginPage.fillInputField(INPUT_EMAIL_LOG, "test123456@test.com");

        loginPage.clickOnElement(INPUT_PASSWORD_LOG);
        loginPage.fillInputField(INPUT_PASSWORD_LOG, "123456");

        loginPage.clickOnElement(LOGIN_BUTTON);

        mainPage.clickOnElement(LOGIN_BUTTON_IN_HEADER);

        Thread.sleep(3000);

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickOnElement(LOGOUT_LINK);

        Thread.sleep(3000);

        assertTrue(driver.findElement(LOGIN_HEADER).isDisplayed());

    }
}
