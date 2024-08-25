package e2e.tests;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private final Config config = new Config();
    public WebDriver driver;


    protected void init() {
        if (config.getSelenoidState()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("120.0");
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", false);

            capabilities.setCapability("selenoid:options", selenoidOptions);
            try {
                driver = new RemoteWebDriver(
                        URI.create(config.getSelenoidUrl()).toURL(),
                        capabilities
                );
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            if (config.getUseFirefox()) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                if (config.getHeadless()) {
                    options.addArguments("--headless");
                }
                driver = new FirefoxDriver(options);
            } else if (config.getUseEdge()) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                if (config.getHeadless()) {
                    options.addArguments("--headless");
                }

                driver = new EdgeDriver(options);
            } else {
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                ChromeOptions options = new ChromeOptions();
                if (config.getHeadless()) {
                    options.addArguments("--headless");
                }

                options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

                driver = new ChromeDriver(options);
            }
        }
        driver.get(config.getProjectUrl());
        driver.manage().window().setSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
    }

    protected void stop(boolean testPassed) {
        if (!testPassed) {
            byte[] screenshotData = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on failure", new ByteArrayInputStream(screenshotData));
        }
        driver.quit();
    }
}