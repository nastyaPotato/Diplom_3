import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver webDriver;

    public static WebDriver getWebDriver(String browserName) {
        if ("Chrome".equals(browserName)) {
            return new ChromeDriver();
        }
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver-22.11.0.2423-win\\yandexdriver.exe");
        options.setBinary("C:\\Users\\AOMikhaylova\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        return new ChromeDriver(options);
    }

    @Before
    public void before(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
