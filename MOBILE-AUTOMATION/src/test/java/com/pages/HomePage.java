package com.pages;

import com.utils.MobileInteraction;
import com.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
   static AndroidDriver driver;
    WaitUtils wait;


    @AndroidFindBy(id = "com.google.android.deskclock:id/tab_menu_alarm")
    private WebElement alarmelement;

    @AndroidFindBy(id = "com.google.android.deskclock:id/fab")
    private WebElement newButton;

    @AndroidFindBy(accessibility= "12 o'clock")
    private WebElement _12Oclock;

    @AndroidFindBy(id = "com.google.android.deskclock:id/material_timepicker_ok_button")
    private WebElement okButton;


    @AndroidFindBy(id = "com.android.chrome:id/signin_fre_dismiss_button")
    private WebElement dissmissButtonChrome;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Wikipedia\")")
    private WebElement chromeWikitag;


    @AndroidFindBy(id = "com.android.chrome:id/negative_button")
    private WebElement NoThanksPopUP;

    @AndroidFindBy(uiAutomator ="new UiSelector().resourceId(\"details-button\")")
    private WebElement AdvancedOption;


    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Proceed to en.m.wikipedia.org (unsafe)\"]")
    private WebElement AdvancedOptionunsafe;
    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Proceed to en.m.wikipedia.org (unsafe)\"]")
    private WebElement AdvancedOptionunsafe1;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Explore Menu\"]/android.widget.ImageView")
    private WebElement youtubeHome;


    @AndroidFindBy(accessibility= "Shopping")
    private WebElement youTybeShopping;
    MobileInteraction mb = new MobileInteraction();
    public HomePage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
        wait= new WaitUtils(driver,10);
    }

    public void navigateToAlarm(){
        alarmelement.click();
    }
    public void createNewAlarm(){
        newButton.click();
    }
    public void setAlarm(){
        _12Oclock.click();
        okButton.click();
    }
// to add in allure replort need to add proper plugin and properties so screen shot attached properly and add steps description as well
    @Step ("Scroll Element Method For allure Report")
    public void scrollElement(){

        MobileInteraction.gestures_scoll(driver);
    }

    public void scrollWithText(){
        MobileInteraction.Scroll(driver,"In the news");
    }

    public void DismissButtonChromeCick()
    {
        wait.waitForElementClickable(dissmissButtonChrome);
        dissmissButtonChrome.click();
        try {
//            wait.waitForElementVisibility(NoThanksPopUP);
//            NoThanksPopUP.click();
            wait.waitForElementVisibility(chromeWikitag);
            chromeWikitag.click();
            wait.waitForElementVisibility(AdvancedOption);
            AdvancedOption.click();
            wait.waitForElementVisibility(AdvancedOptionunsafe);
            AdvancedOptionunsafe.click();
            Thread.sleep(4000);
            wait.waitForElementVisibility(AdvancedOption);
            AdvancedOption.click();
            Thread.sleep(5000);

            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Proceed to en.wikipedia.org (unsafe)\")")).click();

        }
        catch(Exception e){


        }
    }
    @Step ("YouTube Scroll Method For allure Report")
    public void YoutubeScroll(){
        wait.waitForElementClickable(youtubeHome);
        youtubeHome.click();
        wait.waitForElementClickable(youTybeShopping);
        youTybeShopping.click();

    }
    @Step ("Tab On Screen Method For allure Report")
    public void tabOnScreen()
    {
        MobileInteraction.gesture_tab(driver);
    }
}
