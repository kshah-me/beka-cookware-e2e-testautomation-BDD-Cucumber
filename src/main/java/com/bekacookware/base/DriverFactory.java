package com.bekacookware.base;


import com.bekacookware.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class DriverFactory {

    private static DriverFactory INSTANCE;
    private DriverFactory(){
    }

    public static DriverFactory getINSTANCE(){
        if (INSTANCE==null){
            INSTANCE=new DriverFactory();
        }
        return INSTANCE;
    }

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--force-device-scale-factor=0.8");
        chromeOptions.addArguments("--incognito");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--force-device-scale-factor=0.8"); // 80% zoom

        if (ConfigReader.propValueFromConfigFile("browserName").equals("chrome")) {
            driver.set(new ChromeDriver(chromeOptions));
        } else if (ConfigReader.propValueFromConfigFile("browserName").equals("edge")) {
            driver.set(new EdgeDriver(edgeOptions));
        } else {
            System.out.println("Please provide the correct browser name" + ConfigReader.propValueFromConfigFile("browserName"));
        }
    }


    public  WebDriver getDriver() {
        return driver.get();
    }


    public  void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // VERY IMPORTANT
        }
    }
}

