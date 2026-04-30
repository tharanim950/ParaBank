package tests;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import pages.TransferFundPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import models.Transaction;
import utils.DateUtils;
import tests.RegisterTest;


public class AccountsOverviewTest extends BaseTest{
	
	HomePage home;
	TransferFundPage transferPage;
	String username;
    String password = "pass123";
	
//    @BeforeMethod
//    public void setupPage() {
//    	
//    	username = "user" + System.currentTimeMillis();
//    	
//		driver.get("https://parabank.parasoft.com/parabank/register.htm");
//    	
//    	System.out.println("Driver instance: " + driver);
//    	
//        home = new HomePage(driver);
//        transferPage = new TransferFundPage(driver);
//        RegisterPage register = new RegisterPage(driver);
//        
//        home.enterUsername("f12");
//        home.enterPassword("123");
//        home.clickLogin();
//    }
    
//  @Test
//  public void verifySuccessfulTransactionUpdatesAccountBalance() {
//
//      // Step 2: Go to Accounts Overview
//      home.clickAccountsOverview();
//
//      // Step 3: Click first account
//     // home.clickAccountLink();
//      transferPage.clickSecondAccount();
//      
//     
//
//      // Step 4: Capture initial balance
//      double initialBalance = transferPage.getAccountBalance();
//      
//
//      // Step 5: Perform transfer
//      transferPage.clickTransferFunds();
//      transferPage.selectDifferentAccounts();
//      transferPage.enterAmount("100");
//     // transferPage.selectToAccountByText("19560");
//      transferPage.clickTransfer();
//
//      // Step 6: Verify transfer success
//      Assert.assertTrue(
//              transferPage.isTransferSuccessful(),
//              "Transfer was not successful"
//      );
//
//      // Step 7: Navigate back to account
//      home.clickAccountsOverview();
//      //home.clickAccountLink();
//      transferPage.clickFirstAccount();
//      System.out.println("Current URL: " + driver.getCurrentUrl());
//
//      // Step 8: Capture updated balance
//      double updatedBalance = home.getAccountBalance();
//
//      // Step 9: Validate balance update
//      Assert.assertEquals(
//              updatedBalance,
//              initialBalance + 100,
//              "Balance not updated correctly after transfer"
//      );
//  }
    
//  @Test
//  public void verifyTransactionHistoryContainsValidData() {
//  	HomePage home = new HomePage(driver);
//
//  	home.clickAccountsOverview();
//  	home.clickFirstAccount();
//
//      
//
//      int count = home.getTransactionCount();
//      Assert.assertTrue(count > 0, "Transaction list is empty");
//
//      List<String> descriptions = home.getTransactionDescriptions();
//
//      Assert.assertFalse(descriptions.isEmpty(), "Transaction descriptions are empty");
//
//      System.out.println("Transactions: " + descriptions);
//  }
    
//  @Test
//  public void verifyEachTransactionHasValidDetails() {
//  	
//  	home.clickAccountsOverview();
//  	home.clickFirstAccount();
//
//      // Wait for transaction table to load
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
//
//      // Get all transaction links
//      List<WebElement> transactions = driver.findElements(
//          By.xpath("//table//tr[position()>1]/td[2]/a")
//      );
//
//      int count = transactions.size();
//
//      for (int i = 0; i < count; i++) {
//
//          // Re-locate to avoid stale element
//          transactions = driver.findElements(
//              By.xpath("//table//tr[position()>1]/td[2]/a")
//          );
//
//          // Click transaction
//          WebElement txn = transactions.get(i);
//          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", txn);
//          
//          System.out.println("Clicked transaction index: " + i);
//          System.out.println("Current URL: " + driver.getCurrentUrl());
//
//          // Wait for details page
//          wait.until(ExpectedConditions.visibilityOfElementLocated(
//          	    By.xpath("//td[b[text()='Amount:']]")
//          	));
//
//          // Extract values
//          String date = driver.findElement(
//          	    By.xpath("//td[b[text()='Date:']]/following-sibling::td")
//          	).getText().trim();
//
//          String amount = driver.findElement(
//          	    By.xpath("//td[b[text()='Amount:']]/following-sibling::td")
//          	).getText().trim();
//
//          String type = driver.findElement(
//          	    By.xpath("//td[b[text()='Type:']]/following-sibling::td")
//          	).getText().trim();
//
//          // Debug (optional but useful)
//          System.out.println("Transaction " + i + " -> " +
//                  "Date: " + date + ", Amount: " + amount + ", Type: " + type);
//
//          // Assertions
//          Assert.assertFalse(date.isEmpty(), "Date is missing");
//          Assert.assertFalse(amount.isEmpty(), "Amount is missing");
//
//          Assert.assertTrue(
//              type.equalsIgnoreCase("Debit") || type.equalsIgnoreCase("Credit"),
//              "Invalid transaction type"
//          );
//
//          // Go back
//          driver.navigate().back();
//
//          // Wait for table again
//          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
//      }
//  }
//  


}
