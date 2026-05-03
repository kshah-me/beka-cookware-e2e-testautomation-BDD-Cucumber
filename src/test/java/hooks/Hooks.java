package hooks;


import com.bekacookware.base.DriverFactory;
import com.bekacookware.config.ConfigReader;
import com.bekacookware.utility.CaptureScreenshotEvidence;
import com.bekacookware.utility.ScreenRecorderUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks{


    @Before()
    public void launchBrowser(Scenario sc) throws Exception {
        if(ConfigReader.propValueFromConfigFile("RecordingExecution").equals("Yes")){
            ScreenRecorderUtil.startRecord(sc.getName());
        }
        DriverFactory.getInstance().initDriver();
    }


    @After()
    public void teardown(Scenario sc) throws Exception {
        CaptureScreenshotEvidence.takeScreenshotOnFailure(DriverFactory.getInstance().getDriver(), sc);
        DriverFactory.getInstance().quitDriver();
        if(ConfigReader.propValueFromConfigFile("RecordingExecution").equals("Yes")){
            ScreenRecorderUtil.stopRecord();
        }
    }
}
