package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class DriverManager {
    private static WebDriver driver;
    private static Logger log = LogManager.getLogger();
    private static Constants constants;
    private static ChromeOptions chromeOptions;
    private static EdgeOptions edgeOptions;

    public DriverManager() {

    }

    public static void setUpDriver() throws IOException {
        constants = new Constants();
        if (constants.getBrowserName().equalsIgnoreCase("chrome")) {
            chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            log.info("-----------Chrome browser initiated-------------");
        } else if (constants.getBrowserName().equalsIgnoreCase("edge")) {
            edgeOptions = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
            log.info("-----------Edge browser initiated-------------");
        }
        BaseUtils.maximizeWindow(driver);
        driver.get(constants.getUrl());
        BaseUtils.implicitWait(driver);
        BaseUtils.pageLoadTimeOut(driver);
        BaseUtils.clearCookies(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
