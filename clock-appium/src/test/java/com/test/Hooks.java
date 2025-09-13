package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private static AndroidDriver driver;

    public static AndroidDriver validateDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:appPackage", "com.google.android.deskclock");
        cap.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");
        cap.setCapability("appium:deviceName", "UiAutomator2");
        cap.setCapability("appium:platformName", "Android");
        cap.setCapability("appium:unicodeKeyboard", "true");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), cap);

        return driver;
    }

    public static AndroidDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
    @Before
    public static void startProject() throws MalformedURLException{
        quitDriver();
        validateDriver();
    }
}
