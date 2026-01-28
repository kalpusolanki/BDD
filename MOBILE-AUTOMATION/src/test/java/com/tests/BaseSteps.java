package com.tests;

import com.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BaseSteps {
public static AppiumDriverLocalService service;
 public  static AndroidDriver driver;

    @BeforeSuite
    public void startAppium()
    {
         service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .build();
         service.start();
        System.out.println("Service Start successfully");
    }
    @BeforeClass
    public void preContions() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("automationName", ConfigReader.getPropert("Automation"));
        options.setPlatformName(ConfigReader.getPropert("Platform"));
        options.setCapability("deviceName",ConfigReader.getPropert("Device_Name"));
        options.setCapability("udid",ConfigReader.getPropert("Udid"));
        options.setCapability("appPackage",ConfigReader.getPropert("App_Package"));
        options.setCapability("appActivity",ConfigReader.getPropert("App_Activity"));
        options.setCapability("autoGrantPermissions",true);
options.setCapability("acceptInsecureCerts",true);

options.setChromeOptions(Map.of("args", List.of("--ignore-certificate-errors","--ignore-ssl-errors=yes","--ignore-insecure-localhost")));

//        ChromiumOptions opt = new ChromiumOptions();
//        opt.addArguments("--ignore-certificate-errors");
//        opt.addArguments("--ignore-ssl-errors=yes");
//        opt.addArguments("--ignore-insecure-localhost");
//
//        options.setCapability(ChromiumOptions.CAPABILITY,opt);
        String BaseUrl="http://"+ConfigReader.getPropert("Ip_Address")+ConfigReader.getPropert("Port");

        URL url = new URL(BaseUrl);
        System.out.println(BaseUrl+"=========");
//        AppiumDriver driver = new AppiumDriver();
    driver = new AndroidDriver(url,options);
        String SessionId=driver.getSessionId().toString();
        System.out.println("SessionId of AndroidDriver  ======+" +SessionId);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Driver initialized successfully");
    }

    @AfterClass
    public void tearDown()
    {
        if(driver!=null)
//        driver.close();
        System.out.println("Driver closed successfully");
    }

    @AfterSuite
    public void stopAppium()
    {
        if(service!=null)
            service.close();
        System.out.println("Service closed successfully");
    }
    public static AndroidDriver gerDriver(){
        return driver;
    }


}
