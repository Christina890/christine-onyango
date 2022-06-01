package tests;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestCases {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait                wait;

    By continueButton = By.id("com.monefy.app.lite:id/buttonContinue");
    By closeButton = By.id("com.monefy.app.lite:id/buttonClose");
    By addExpense   = By.id("com.monefy.app.lite:id/expense_button_title");
    By keyboard1 =   By.id("com.monefy.app.lite:id/buttonKeyboard1");
    By keyboard0 =  By.id("com.monefy.app.lite:id/buttonKeyboard0");
    By chooseCategory = By.id("com.monefy.app.lite:id/keyboard_action_button");
    By category = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ImageView");
    By getBalance = By.id("com.monefy.app.lite:id/balance_amount");
    By addIncome = By.id("com.monefy.app.lite:id/income_button");
    By ellipsis = By.id("com.monefy.app.lite:id/overflow");
    By accountIcon = By.id("com.monefy.app.lite:id/accounts_panel");
    By addButton = By.id("com.monefy.app.lite:id/imageButtonAddCategory");
    By categoryName = By.id("com.monefy.app.lite:id/editTextCategoryName");
    By initialAmount = By.id("com.monefy.app.lite:id/initialAmount");
    By saveButton = By.id("com.monefy.app.lite:id/save");
    By accountCategory=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[12]/android.widget.FrameLayout/android.widget.ImageView");
    @BeforeMethod
    public void setup1() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "MyAndroid");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.monefy.app.lite");
        caps.setCapability("appActivity", "com.monefy.activities.main.MainActivity_");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
    @BeforeMethod
    public void setup2ApplicationLaunch(){

        //Click through the splash screens
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();

        //Close the promo
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).click();

    }
    @Test
    void addExpense(){
        //Click to add expense
        wait.until(ExpectedConditions.visibilityOfElementLocated(addExpense)).click();

        //Enter Amount
        wait.until(ExpectedConditions.visibilityOfElementLocated(keyboard1)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(keyboard0)).click();

        //Click to choose category
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseCategory)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(category)).click();
        String balance =wait.until(ExpectedConditions.visibilityOfElementLocated(getBalance)).getText();
        Assert.assertEquals(balance, "Balance -$10.00");
    }
    @Test
    void addIncome(){

        //Click to add expense
        wait.until(ExpectedConditions.visibilityOfElementLocated(addIncome)).click();

        //Enter Amount
        wait.until(ExpectedConditions.visibilityOfElementLocated(keyboard1)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(keyboard0)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(keyboard0)).click();

        //Click to choose category
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseCategory)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(category)).click();
        String balance =wait.until(ExpectedConditions.visibilityOfElementLocated(getBalance)).getText();
        Assert.assertEquals(balance, "Balance $100.00");
    }
    @Test
    void addAccount(){
        //Click on the Ellispis
        wait.until(ExpectedConditions.visibilityOfElementLocated(ellipsis)).click();

        //Click on the account icon
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountIcon)).click();

        //New Account button
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton)).click();

        //Type name of account
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryName)).sendKeys("Tina");

        //Type the initial Amount
        wait.until(ExpectedConditions.visibilityOfElementLocated(initialAmount)).sendKeys("1200");

        //Select Category
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCategory)).click();

        //Save New Account
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton)).click();

        String balance =wait.until(ExpectedConditions.visibilityOfElementLocated(getBalance)).getText();
        Assert.assertEquals(balance, "Balance $1,200.00");
    }
}

