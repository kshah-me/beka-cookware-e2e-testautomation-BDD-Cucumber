package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //plugin = { "pretty", "html:target/cucumber-reports", "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"},
        features="src/test/resources/features/NegativeCases.feature",
        //features="src/test/resources/features",
        glue={"stepdefinitions", "hooks"}
)

public class BekaCookwareRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios(){
        return super.scenarios();
    }
}

