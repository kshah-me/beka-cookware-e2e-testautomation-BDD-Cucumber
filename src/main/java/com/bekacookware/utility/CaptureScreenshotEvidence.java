package com.bekacookware.utility;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class CaptureScreenshotEvidence{


    public static void takeScreenshotOnFailure(WebDriver driver, Scenario result) throws IOException {

        if (result.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File("./screenshots/" + result.getName() + ".png");
            FileUtils.copyFile(source, destination);
        }
    }
}
