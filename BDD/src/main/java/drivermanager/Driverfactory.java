package drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driverfactory {
   static WebDriver driver;
    public WebDriver initBrowser(String browser){
        if(browser.equals("Chrome")){
            driver= new ChromeDriver();

            System.out.println("Browser started");
        }
        else{
            driver= new EdgeDriver();
        }
       return driver;
    }
    public static WebDriver getDriver(){return  driver;}
}
