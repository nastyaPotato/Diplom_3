import com.yandex.pojo.LoginPage;
import com.yandex.pojo.MainPage;
import com.yandex.pojo.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.testdata.TestDataGenerator;

import static com.yandex.pojo.LoginPage.LOGIN_HEADER;
import static com.yandex.pojo.LoginPage.REGISTRATION_BUTTON;
import static com.yandex.pojo.MainPage.LOGIN_BUTTON_IN_BODY;
import static com.yandex.pojo.RegistrationPage.*;
import static org.junit.Assert.assertTrue;

@DisplayName("Проверка регистрации")
@RunWith(Parameterized.class)
public class RegistrationTest {

    private final String name;
    private final String email;
    private final String password;
    private final By expectedResult;
    private WebDriver driver;


    public RegistrationTest(String name, String email, String password, By expectedResult) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.expectedResult = expectedResult;
    }


    @Parameterized.Parameters
    public static Object[][] getInputs() {
        return new Object[][]{
                {"Анастасия Яковенко", TestDataGenerator.getRandomEmail(), "1234777", LOGIN_HEADER},
                {"Анастасия Яковенко", TestDataGenerator.getRandomEmail(), "567887778", LOGIN_HEADER},
                {"Анастасия Яковенко", TestDataGenerator.getRandomEmail(), "56", PASSWORD_ERROR},
        };
    }

    @Before
    public void startUp() {
        driver = BaseTest.getWebDriver("Chrome");
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @DisplayName("Проверка регистрации")
    @Test
    public void registration() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(LOGIN_BUTTON_IN_BODY);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnElement(REGISTRATION_BUTTON);

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickOnElement(INPUT_NAME);
        registrationPage.fillInputField(INPUT_NAME, name);

        registrationPage.clickOnElement(INPUT_EMAIL);
        registrationPage.fillInputField(INPUT_EMAIL, email);

        registrationPage.clickOnElement(INPUT_PASSWORD);
        registrationPage.fillInputField(INPUT_PASSWORD, password);

        registrationPage.clickOnElement(REGISTRATION_BUTTON1);

        Thread.sleep(3000);

        assertTrue(driver.findElement(expectedResult).isDisplayed());
    }
}
