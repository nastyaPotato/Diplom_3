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
        String driverName = System.getProperty("driverName");
        System.setProperty("webdriver.chrome.driver", driverName);
        String yandexName = System.getProperty("yandexName");
        options.setBinary(yandexName);
        return new ChromeDriver(options);
    }

    @Before
    public void before(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
