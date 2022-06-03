package pages;

import base.TestCapabilities;
import base.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Transfer {

    public Transfer() {
        PageFactory.initElements(new AppiumFieldDecorator(TestDriver.getDriver()), this);
    }
    @FindBy(id="com.monefy.app.lite:id/transfer_menu_item")
    public MobileElement transferMenu;
    @FindBy(id="com.monefy.app.lite:id/amount_text")
    public MobileElement transferAmount;
    @FindBy(id="com.monefy.app.lite:id/textViewNote")
    public MobileElement transferNote;
    @FindBy(id="com.monefy.app.lite:id/show_keyboard_fab")
    public MobileElement keyboard;
    @FindBy(id="com.monefy.app.lite:id/keyboard_action_button")
    public MobileElement addTransferButton;
    @FindBy(id="com.monefy.app.lite:id/snackbar_text")
    public MobileElement transferConfirmation;

    public void clickOnTransferIcon(){
        transferMenu.click();
    }
    public void enterTransferAmount(){
        Expenses expenses=new Expenses();
        transferAmount.click();
        expenses.keyBoard1.click();
        expenses.keyBoard0.click();
        expenses.keyBoard0.click();
    }
    public void enterTransferNotes(){
        transferNote.sendKeys("own transfer");
    }
    public void openKeyboard(){
        keyboard.click();
    }
    public void submitTransfer(){
        addTransferButton.click();
    }
    public String confirmTransfer(){
        String transferMessage =transferConfirmation.getText();
        return transferMessage;}
}