package pages;

import base.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class Account {
    public Account() {
        PageFactory.initElements(new AppiumFieldDecorator(TestDriver.getDriver()), this);
    }


    @FindBy(id="com.monefy.app.lite:id/overflow")
    public MobileElement ellipsis;
    @FindBy(id="com.monefy.app.lite:id/accounts_panel")
    public MobileElement accountIcon;
    @FindBy(id="com.monefy.app.lite:id/imageButtonAddCategory")
    public MobileElement addButton;
    @FindBy(id="com.monefy.app.lite:id/editTextCategoryName")
    public MobileElement categoryName;
    @FindBy(id="com.monefy.app.lite:id/initialAmount")
    public MobileElement initialAmount;
    @FindBy(id="com.monefy.app.lite:id/save")
    public MobileElement saveButton;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[12]/android.widget.FrameLayout/android.widget.ImageView")
    public MobileElement accountCategory;

    //By ellipsis = By.id("com.monefy.app.lite:id/overflow");
    //By accountIcon = By.id("com.monefy.app.lite:id/accounts_panel");
    //By addButton = By.id("com.monefy.app.lite:id/imageButtonAddCategory");
    //By categoryName = By.id("com.monefy.app.lite:id/editTextCategoryName");
    //By initialAmount = By.id("com.monefy.app.lite:id/initialAmount");
    //By saveButton = By.id("com.monefy.app.lite:id/save");
    //By accountCategory=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[12]/android.widget.FrameLayout/android.widget.ImageView");
public void clickOnEllipsis(){
    ellipsis.click();
}
    public void clickOnAccountIcon(){
    accountIcon.click();
    }
    public void clickOnAddButton(){
    addButton.click();
    }
public void enterAccountName(){
    categoryName.sendKeys("Tina");
}
public void enterInitialAmount(){
    initialAmount.sendKeys("1200");
}
public void selectCategory(){
    accountCategory.click();
}
public void saveAccount(){
    saveButton.click();
}

}
