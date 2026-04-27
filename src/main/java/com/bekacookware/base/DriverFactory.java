package com.bekacookware.base;


import com.bekacookware.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.time.Duration;


public class DriverFactory {


    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
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

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        DriverFactory.getDriver().manage().deleteAllCookies();
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get(ConfigReader.propValueFromConfigFile("url"));
    }


    public static WebDriver getDriver() {
        return driver.get();
    }


    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // VERY IMPORTANT
        }
    }
}

//
//    @BeforeMethod(dependsOnMethods = "setUpBrowser")
//    public void  closeCookiesAndAddPopUp(){
//        homepage = new HomePage(DriverFactory.getDriver());
//        homepage.clickCookiesPopupAcceptance();
//        homepage.clickCrossButtonOnGermanyCountrySelectionPopup();
//        homepage.clickCloseButtonOnAddPopUp();
//    }
//
//    @BeforeMethod(dependsOnMethods = "closeCookiesAndAddPopUp")
//    public void  changeTheLanguageOfApplication(){
//        homepage = new HomePage(DriverFactory.getDriver());
//        String lang =ConfigReader.propValueFromConfigFile("Language");
//        homepage.clickOnLanguageDropDown();
//        switch (lang) {
//            case "EN" -> homepage.selectEnglishLanguage();
//            case "DE" -> homepage.selectDeutschLanguage();
//            case "NL" -> homepage.selectDutchLanguage();
//            case "FR" -> homepage.selectFrenchLanguage();
//        }
//        WaitUtils.waitUntillPageLoaded(DriverFactory.getDriver());
//        homepage.clickCloseButtonOnAddPopUp();
//    }

