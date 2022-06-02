package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class TestDriver {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();


    public static AppiumDriver getDriver(){
        return driver.get();
    }
       static void setDriver(AppiumDriver Driver){
        driver.set(Driver);
    }
}
