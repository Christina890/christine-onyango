package tests;

import base.TestCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Account;
import pages.Expenses;
import pages.Transfer;

public class TestCases {
    public WebDriverWait                wait;

    @BeforeMethod
    public void setup1() throws MalformedURLException {
        TestCapabilities testCapabilities=new TestCapabilities();
        testCapabilities.setupCapabilities();
        wait = new WebDriverWait(testCapabilities.driver, 10);
    }
    @BeforeMethod
    public void setup2ApplicationLaunch() throws InterruptedException {
        Expenses expenses=new Expenses();
        expenses.skipSpashScreen();
    }
    @Test
    void addExpense(){
        Expenses expenses=new Expenses();
        expenses.clickToAddExpense();
        expenses.enterAmount();
        expenses.selectCategory();
        Assert.assertEquals(expenses.getBalance(), "Balance -$10.00");
    }
    @Test
    void addIncome() throws InterruptedException{
        Expenses expenses=new Expenses();
        expenses.clickToAddIncome();
        Thread.sleep(500);
        expenses.enterAmount();
        expenses.selectCategory();
        Thread.sleep(500);
        Assert.assertEquals(expenses.getBalance(), "Balance $10.00");
    }
    @Test
    void addAccount()throws InterruptedException {
        Account account=new Account();
        Expenses expenses=new Expenses();
        account.clickOnEllipsis();
        account.clickOnAccountIcon();
        account.clickOnAddButton();
        account.enterAccountName();
        account.enterInitialAmount();
        account.selectCategory();
        account.saveAccount();
        Thread.sleep(500);
        Assert.assertEquals(expenses.getBalance(), "Balance $1,200.00");
    }
    @Test
    void transferWithZeroBalance() throws InterruptedException{
        Transfer transfer=new Transfer();
        transfer.clickOnTransferIcon();
        transfer.enterTransferNotes();
        Thread.sleep(500);
        transfer.enterTransferAmount();
        transfer.submitTransfer();
        Assert.assertNotEquals(transfer.confirmTransfer(),"Transfer was added" );
    }
    @Test
    void editExpense() throws InterruptedException {
        Transfer transfer=new Transfer();
        Expenses expenses=new Expenses();
        expenses.clickToAddExpense();
        expenses.enterAmount();
        expenses.selectCategory();
        Thread.sleep(1000);
        expenses.openTransactionList();
        expenses.clickOnExpense();
        expenses.editAmount();
        expenses.selectCategory();
        Assert.assertEquals(transfer.confirmTransfer(),"Record was updated");

    }
}

