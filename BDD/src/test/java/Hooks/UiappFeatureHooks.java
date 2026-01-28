package Hooks;

import drivermanager.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class UiappFeatureHooks {
    Driverfactory df;
    @Before
    public void launchBrowser(){
     df = new Driverfactory();
        WebDriver driver = df.initBrowser("Chrome");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        Driverfactory.getDriver().quit();
    }
}
