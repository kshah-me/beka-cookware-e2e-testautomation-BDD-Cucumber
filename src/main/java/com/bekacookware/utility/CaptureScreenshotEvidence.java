package com.bekacookware.utility;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import java.io.File;



public class CaptureScreenshotEvidence{

        public static void takeScreenshotOnFailure(WebDriver driver, Scenario result) {
            if (driver == null) {
                System.out.println("Driver is NULL. Cannot capture screenshot.");
                return;
            }
            if (!result.isFailed()) {
                return;
            }
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                String fileName = result.getName().replaceAll(" ", "_");
                File destination = new File("./screenshots/" + fileName + ".png");
                FileUtils.copyFile(source, destination);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
