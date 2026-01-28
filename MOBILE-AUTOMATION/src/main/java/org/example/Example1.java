package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Example1 {

    public void appiumsession() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("automationName","UiAutomator2");
        options.setPlatformName("Android");
        options.setCapability("deviceName","medium_phone");
        options.setCapability("udid","emulator-5554");
        options.setCapability("appPackage","com.google.android.deskclock");
        options.setCapability("appActivity","com.android.deskclock.DeskClock");
        URL url = new URL("http://127.0.0.1:4723/");
//        AppiumDriver driver = new AppiumDriver();
        AndroidDriver driver = new AndroidDriver(url,options);
        String SessionId=driver.getSessionId().toString();
        System.out.println("SessionId of AndroidDriver  ======+" +SessionId);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement alarmelement= driver.findElement(AppiumBy.id("com.google.android.deskclock:id/tab_menu_alarm"));
        alarmelement.click();
    }

    public static void main(String[] args) throws MalformedURLException {
        Example1 ex = new Example1();
        ex.appiumsession();

    }
}
