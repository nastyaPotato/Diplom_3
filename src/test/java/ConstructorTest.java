import ru.yandex.pojo.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.yandex.pojo.MainPage.*;
import static org.hamcrest.CoreMatchers.containsString;

@DisplayName("Раздел «Конструктор»")
public class ConstructorTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        driver = BaseTest.getWebDriver(System.getProperty("browserName"));
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход к разделу соусы от раздела булки в Конструкторе")
    public void transitionFromBunToSouses() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(SOUSES_LINK);

        WebElement elementSouses = driver.findElement(SOUSES_LINK);
        String classSouses = elementSouses.getAttribute("class");

        WebElement elementBun = driver.findElement(BUN_LINK);
        String classBun = elementBun.getAttribute("class");

        Assert.assertThat(classSouses, containsString("tab_tab_type_current__2BEPc"));
        Assert.assertThat(classBun, containsString("noselect"));
    }

    @Test
    @DisplayName("Переход к разделу начинки от раздела булки в Конструкторе")
    public void transitionFromBunToFilling() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(FILLING_LINK);

        WebElement elementFilling = driver.findElement(FILLING_LINK);
        String classFilling = elementFilling.getAttribute("class");

        WebElement elementBun = driver.findElement(BUN_LINK);
        String classBun = elementBun.getAttribute("class");

        Assert.assertThat(classFilling, containsString("tab_tab_type_current__2BEPc"));
        Assert.assertThat(classBun, containsString("noselect"));
    }

    @Test
    @DisplayName("Переход к разделу булки от раздела начинки в Конструкторе")
    public void transitionFromFillingToBun() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnElement(FILLING_LINK);
        mainPage.clickOnElement(BUN_LINK);

        WebElement elementFilling = driver.findElement(FILLING_LINK);
        String classFilling = elementFilling.getAttribute("class");

        WebElement elementBun = driver.findElement(BUN_LINK);
        String classBun = elementBun.getAttribute("class");

        Assert.assertThat(classBun, containsString("tab_tab_type_current__2BEPc"));
        Assert.assertThat(classFilling, containsString("noselect"));
    }
}
