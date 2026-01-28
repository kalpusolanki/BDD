package com.utils;


import com.tests.BaseSteps;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Listners --on Test Failure");
        try {
            ScreenshotUtils.caputreScreen(BaseSteps.gerDriver(), result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        caputreScreenshot();
    }

    @Attachment (value ="Failure Screenshot", type="image/png")
    public static byte[] caputreScreenshot(){
        return ((TakesScreenshot)BaseSteps.gerDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
