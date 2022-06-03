package pages;

import base.TestCapabilities;
import base.TestDriver;
import pages.Transfer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Expenses  {

public Expenses() {
   PageFactory.initElements(new AppiumFieldDecorator(TestDriver.getDriver()), this);
}
    Transfer transfer = new Transfer();

@FindBy(id="com.monefy.app.lite:id/buttonContinue")
        public MobileElement continueButton;
  @FindBy(id="com.monefy.app.lite:id/buttonClose")
          public MobileElement closeButton;
  @FindBy(id="com.monefy.app.lite:id/expense_button_title")
          public MobileElement addExpense;
  @FindBy(id="com.monefy.app.lite:id/buttonKeyboard1")
          public MobileElement keyBoard1;
    @FindBy(id="com.monefy.app.lite:id/buttonKeyboard0")
    public MobileElement keyBoard0;
    @FindBy(id="com.monefy.app.lite:id/keyboard_action_button")
            public MobileElement chooseCategory;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ImageView"
    )
    public MobileElement category;
    @FindBy(id="com.monefy.app.lite:id/balance_amount")
            public MobileElement balance;
    @FindBy(id="com.monefy.app.lite:id/income_button")
            public MobileElement addIncome;

    @FindBy(id="com.monefy.app.lite:id/leftLinesImageView")
    public MobileElement transactionHamburger;

    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout")
    public MobileElement expense;
    @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout")
    public MobileElement expenseSelection;
public void skipSpashScreen() throws InterruptedException {

    continueButton.click();
    Thread.sleep(1000);
    continueButton.click();
    continueButton.click();
    Thread.sleep(1000);
    closeButton.click();
}
    public void clickToAddExpense(){
    addExpense.click();}
    public void enterAmount(){
    keyBoard1.click();
    keyBoard0.click();}
    public void selectCategory(){
    chooseCategory.click();
    category.click();}
    public String getBalance(){
    String accountBalance=balance.getText();
    return accountBalance;}
    public void clickToAddIncome(){
    addIncome.click();
    }
    public void openTransactionList ()
    {

        transactionHamburger.click();
    }
    public void clickOnExpense(){
    expense.click();
    expenseSelection.click();
    }
    public void editAmount(){
    transfer.transferAmount.clear();
    keyBoard1.click();
    keyBoard1.click();
    }



}