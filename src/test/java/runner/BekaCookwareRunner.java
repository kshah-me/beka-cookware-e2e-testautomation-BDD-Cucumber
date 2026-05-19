package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(

        //plugin = { "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"},
        plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features="src/test/resources/features/HomePage.feature",
        glue={"stepdefinitions", "hooks"}
)
public class BekaCookwareRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios(){
        return super.scenarios();
    }

}