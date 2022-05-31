package tests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;



public class TestCases {
    AndroidDriver driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appPackage", "com.monefy.app.lite");
        capabilities.setCapability("appActivity", "com.monefy.activities.main.MainActivity_");
        capabilities.setCapability("udid", "emulator-5554");
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,capabilities);
        driver = new AndroidDriver(url,capabilities);
    }
    @Test
    void dummy(){
        System.out.println("sampletest");
    }

}

