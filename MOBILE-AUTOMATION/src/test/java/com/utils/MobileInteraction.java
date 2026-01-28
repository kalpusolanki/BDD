package com.utils;

import com.tests.BaseSteps;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;


import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;

import static com.tests.BaseSteps.driver;

public class MobileInteraction {


    public static void gestures_scoll(AndroidDriver driver) {
        // Step:1 Pointer input initialization
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        //Step 2 Sequence creation
        Sequence scroll = new Sequence(finger, 1);

        //Step 3 Pointer Movement and action
        int startx = driver.manage().window().getSize().getWidth();
        int starty = (int) (driver.manage().window().getSize().getHeight()*0.7);
        int stopy= (int) (starty*0.50);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx/2, starty));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startx, stopy));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        //step 4 perform the action
        driver.perform(Arrays.asList(scroll));

    }

    public static void Scroll(AndroidDriver driver, String inTheNews) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
        +".scrollIntoView(new UiSelector().textContains(\""+inTheNews+"\"))"));
    }

    public static void gesture_tab(AndroidDriver driver){
        // Step:1 Pointer input initialization
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        //Step 2 Sequence creation
        Sequence tab = new Sequence(finger, 1);

        int x= 300;
        int y= 300;
        //Step 3 Pointer Movement and action
        tab.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tab.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tab.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//        // required pause for double tab
//        tab.addAction(finger.p);
//        tab.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tab.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tab));
    }
}