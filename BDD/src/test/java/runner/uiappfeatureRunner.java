package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(

            features = { "src\\test\\resources\\uiappfeature" },

    glue = { "uiappfeaturesteps","Hooks" },

    plugin = { "pretty" },

    publish = true

            )

    public class uiappfeatureRunner extends AbstractTestNGCucumberTests {

    }
