package com.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
   private WebDriverWait wait;
    public WaitUtils(AppiumDriver driver, int timeouts){
        wait=new WebDriverWait(driver, Duration.ofSeconds(timeouts));
    }

    public void waitForElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
