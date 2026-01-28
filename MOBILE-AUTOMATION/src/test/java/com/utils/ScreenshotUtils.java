package com.utils;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ScreenshotUtils {

    private static String path= System.getProperty("user.dir")+"//screenshots//";
    public static void caputreScreen(AndroidDriver driver, String testname) throws IOException, InterruptedException {
        String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String localvar=path+"_"+testname+"_"+timeStamp+".png";
        String adbpath= System.getenv("ANDROID_HOME")+"//platform-tools//adb";

        //imp for screen shot capture its actullay capturing scrrenshot
        ProcessBuilder pb = new ProcessBuilder(adbpath,"exec-out","screencap","-p");  // imp
        pb.redirectOutput(new File(localvar));
        pb.start().waitFor(3, TimeUnit.SECONDS);

    }
}
