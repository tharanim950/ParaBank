package tests;

import base.BaseTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import models.Transaction;
import utils.DateUtils;
import tests.RegisterTest;


import pages.HomePage;
import pages.RegisterPage;
import pages.TransferFundPage;

public class TransferFundTest extends BaseTest {
	
	HomePage home;
	TransferFundPage transferPage;
	String username;
    String password = "pass123";
	
    @BeforeMethod
    public void setupPage() {
    	
    	username = "user" + System.currentTimeMillis();
    	driver.get("https://parabank.parasoft.com/parabank/register.htm");
    	
    	System.out.println("Driver instance: " + driver);
    	
        home = new HomePage(driver);
        transferPage = new TransferFundPage(driver);
        RegisterPage register = new RegisterPage(driver);
        
//        register.registerUser(
//                "John",
//                "Doe",
//                "123 Street",
//                "Chennai",
//                "TN",
//                "600001",
//                "9876543210",
//                "1234",
//                username,
//                password
//        );
//
//        // 🔹 Wait for success
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//p[contains(text(),'Your account was created successfully')]")
//        ));
        
        home.enterUsername("f1");
        home.enterPassword("123");
        home.clickLogin();
       
    }
    
//    @Test
//    public void verifyOpenNewAccount() {
//
//    	driver.findElement(By.linkText("Open New Account")).click();
//
//        // Step 1: Open new account
//        String newAccountId = accountPage.openNewAccount();
//
//        // Step 2: Validate account ID is not empty
//        Assert.assertNotNull(newAccountId, "Account ID is null");
//        Assert.assertFalse(newAccountId.isEmpty(), "Account ID is empty");
//
//        // Step 3: Navigate to Accounts Overview
//        driver.findElement(By.linkText("Accounts Overview")).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
//
//        // Step 4: Verify new account exists in list
//        boolean isAccountPresent = driver.findElements(
//                By.xpath("//a[text()='" + newAccountId + "']")
//        ).size() > 0;
//
//        Assert.assertTrue(isAccountPresent, "New account not found in Accounts Overview");
//
//        System.out.println("New account verified: " + newAccountId);
//    }

//    @Test
//    public void verifyFundTransferUpdatesBalances() {
//
//        TransferFundPage transferPage = new TransferFundPage(driver);
//        
//        home.clickAccountsOverview();
//        
//        transferPage.clickFirstAccount();
//        double initialBalance1 = transferPage.getAccountBalance();
//        
//        home.clickAccountsOverview();
//        
//        transferPage.clickSecondAccount();
//        double initialBalance2 = transferPage.getAccountBalance();
//        
//        // ✅ STEP 1: Navigate FIRST
//        transferPage.clickTransferFunds();
//        transferPage.enterAmount("100");
//
//        By fromDropdown = By.id("fromAccountId");
//        By toDropdown = By.id("toAccountId");
//
//        String fromAcc = transferPage.selectAccount(fromDropdown, 0);
//        String toAcc = transferPage.selectAccount(toDropdown, 1);
//
//        Assert.assertNotEquals(fromAcc, toAcc);
//        transferPage.clickTransfer();
//        
//
//        transferPage.verifyTransferSuccess();
//        
//        home.clickAccountsOverview();
//        
//        transferPage.clickFirstAccount();
//        double updatedBalance1 = transferPage.getAccountBalance();
//        
//        home.clickAccountsOverview();
//        
//        transferPage.clickSecondAccount();
//        double updatedBalance2 = transferPage.getAccountBalance();
//
//
//    }

//    @Test(description = "Verify transfer fails when amount exceeds available balance")
//    public void verifyTransferFailsForInsufficientBalance() {
//
//    	 home.clickAccountsOverview();
//         
//         transferPage.clickFirstAccount();
//         double initialBalance1 = transferPage.getAccountBalance();
//         
//         home.clickAccountsOverview();
//         
//         transferPage.clickSecondAccount();
//         double initialBalance2 = transferPage.getAccountBalance();
//         
//         // ✅ STEP 1: Navigate FIRST
//         transferPage.clickTransferFunds();
//         transferPage.enterAmount("500");
//
//         By fromDropdown = By.id("fromAccountId");
//         By toDropdown = By.id("toAccountId");
//
//         String fromAcc = transferPage.selectAccount(fromDropdown, 0);
//         String toAcc = transferPage.selectAccount(toDropdown, 1);
//
//         Assert.assertNotEquals(fromAcc, toAcc);
//         transferPage.clickTransfer();
//         
//         transferPage.verifyTransferSuccess();
//
//        // Step 4: Verify error message (EXPECTED behavior)
//        boolean isErrorDisplayed = transferPage.isInsufficientBalanceErrorDisplayed();
//
//        Assert.assertTrue(isErrorDisplayed,
//                "Expected 'Insufficient Balance' error, but it was NOT displayed");
//
//        // Step 5: Verify balance remains unchanged (EXPECTED behavior)
//       
//        home.clickAccountsOverview();
//        
//        transferPage.clickFirstAccount();
//        double updatedBalance1 = transferPage.getAccountBalance();
//        
//        home.clickAccountsOverview();
//        
//        transferPage.clickSecondAccount();
//        double updatedBalance2 = transferPage.getAccountBalance();
//
//        Assert.assertEquals(initialBalance1, updatedBalance1,
//                "Balance changed even though transfer should have failed");
//    }
    
//    @Test
//    public void verifyTransferWithEmptyFieldsShowsError() {
//
//        // Click Transfer Funds
//    	transferPage.clickTransferFunds();
//
//        // Click Transfer button without entering anything
//    	transferPage.clickTransfer();
//
//        // Assertions
//    	String actualMessage = transferPage.getErrorMessageText();
//    	Assert.assertEquals(actualMessage, "Error!");
//
//        // You can also validate multiple errors if present
//    }
    
//    @Test
//    public void verifyTransferToSameAccountShowsError() {
//
//        // Navigate to Transfer Funds
//    	transferPage.clickTransferFunds();
//
//        // Select same account in both dropdowns
//        Select fromAcc = new Select(driver.findElement(By.id("fromAccountId")));
//        Select toAcc = new Select(driver.findElement(By.id("toAccountId")));
//
//        fromAcc.selectByIndex(0);
//        toAcc.selectByIndex(0); // Same account
//
//        // Enter amount
//        transferPage.enterAmount("100");
//
//        // Click transfer
//        transferPage.clickTransfer();
//
//        // Expected: Error message (but will FAIL → defect)
//        String actualMessage = transferPage.getErrorMessageText();
//
//        Assert.assertEquals(actualMessage, "Error!");
//        
//        By successMsg = By.xpath("//h1[text()='Transfer Complete!']");
//
//        Assert.assertFalse(driver.findElements(successMsg).size() > 0,
//                "Transfer should not be successful for same account");
//    }
    
//    @Test
//    public void verifyTransferWithValidDecimalAmount() {
//
//    	transferPage.clickTransferFunds();
//
//        // Select same account in both dropdowns
//        Select fromAcc = new Select(driver.findElement(By.id("fromAccountId")));
//        Select toAcc = new Select(driver.findElement(By.id("toAccountId")));
//
//        fromAcc.selectByIndex(0);
//        toAcc.selectByIndex(0); // Same account
//
//        // Enter amount
//        transferPage.enterAmount("999999.99");
//
//        // Click transfer
//        transferPage.clickTransfer();
//
//        By successMsg = By.xpath("//h1[text()='Transfer Complete!']");
//
//        String actualMessage = driver.findElement(successMsg).getText();
//        Assert.assertEquals(actualMessage, "Transfer Complete!");
//    }
    
//  @Test
//  public void verifyFundTransferUpdatesBalances() {
//
//      TransferFundPage transferPage = new TransferFundPage(driver);
//      
//      home.clickAccountsOverview();
//      
//      transferPage.clickFirstAccount();
//      double initialBalance1 = transferPage.getAccountBalance();
//      
//      home.clickAccountsOverview();
//      
//      transferPage.clickSecondAccount();
//      double initialBalance2 = transferPage.getAccountBalance();
//      
//      // ✅ STEP 1: Navigate FIRST
//      transferPage.clickTransferFunds();
//      transferPage.enterAmount("100");
//
//      By fromDropdown = By.id("fromAccountId");
//      By toDropdown = By.id("toAccountId");
//
//      String fromAcc = transferPage.selectAccount(fromDropdown, 0);
//      String toAcc = transferPage.selectAccount(toDropdown, 1);
//
//      Assert.assertNotEquals(fromAcc, toAcc);
//      transferPage.clickTransfer();
//      
//
//      WebElement msg = wait.until(
//    		    ExpectedConditions.visibilityOfElementLocated(
//    		        By.xpath("//h1[text()='Transfer Complete!']")
//    		    )
//    		);
//
//    		String actualMessage = msg.getText();
//    		Assert.assertEquals(actualMessage, "Transfer Complete!");
//      Assert.assertEquals(actualMessage, "Transfer Complete!");
//      
//      home.clickAccountsOverview();
//      
//      transferPage.clickFirstAccount();
//      double updatedBalance1 = transferPage.getAccountBalance();
//      
//      home.clickAccountsOverview();
//      
//      transferPage.clickSecondAccount();
//      double updatedBalance2 = transferPage.getAccountBalance();
//      
//      Assert.assertEquals(
//            updatedBalance2,
//            initialBalance2 + 100,
//            "Balance not updated correctly after transfer"
//    );
//
//
//  }



    
}