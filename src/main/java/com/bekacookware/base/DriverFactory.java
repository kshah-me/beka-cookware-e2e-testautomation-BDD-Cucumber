package com.bekacookware.base;


import com.bekacookware.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;


public class DriverFactory {

    private static final DriverFactory INSTANCE = new DriverFactory();

    private DriverFactory() { }

    public static DriverFactory getInstance() {
        return INSTANCE;
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void initDriver() {

        if (driver.get() != null) {
            return; // prevents duplicate driver creation
        }

        String browser = ConfigReader
                .propValueFromConfigFile("browserName")
                .toLowerCase();

        switch (browser) {

            case "chrome":
                driver.set(new ChromeDriver(getChromeOptions()));
                break;

            case "edge":
                driver.set(new EdgeDriver(getEdgeOptions()));
                break;

            default:
                throw new RuntimeException(
                        "Invalid browser name provided: " + browser
                );
        }

        setupBrowser();
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--force-device-scale-factor=0.8");
        return options;
    }
    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--force-device-scale-factor=0.8");
        options.addArguments("-inprivate");
        return options;
    }

    private void setupBrowser() {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(60));
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}