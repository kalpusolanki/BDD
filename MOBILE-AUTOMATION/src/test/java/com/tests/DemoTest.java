package com.tests;

import com.pages.HomePage;
import com.utils.TestListner;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListner.class)
public class DemoTest extends BaseSteps {

    @Test
    public void Test() throws InterruptedException {
//        //click on Alarm Button
//        WebElement alarmelement= driver.findElement(AppiumBy.id("com.google.android.deskclock:id/tab_menu_alarm"));
//        alarmelement.click();
//
//        //click on New Button
//        WebElement newButton=driver.findElement(AppiumBy.id("com.google.android.deskclock:id/fab"));
//        newButton.click();
//
//        //set alarm
//        WebElement _12Oclock=driver.findElement(AppiumBy.accessibilityId("12 o'clock"));
//        _12Oclock.click();
//
//        //click Okm Button
//        WebElement okButton=driver.findElement(AppiumBy.id("com.google.android.deskclock:id/material_timepicker_ok_button"));
//        okButton.click();

        HomePage page = new HomePage(driver);
//        page.navigateToAlarm();
//        page.createNewAlarm();
//        page.setAlarm();


//        page.DismissButtonChromeCick();

        page.YoutubeScroll();
//
        Thread.sleep(6000);
        page.scrollElement();
        page.tabOnScreen();
        //intentionally fail to capute screenshot andListner implementation check
        Assert.assertTrue(false);
//        page.scrollWithText();
    }
}
