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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import models.Transaction;
import utils.DateUtils;
import tests.RegisterTest;

public class FindTransactionsTest extends BaseTest{
	
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
        
        home.enterUsername("f12");
        home.enterPassword("123");
        home.clickLogin();
    }
	
	
//  @Test
//  public void verifyTransactionsWithinSelectedDateRange() {
//  	
//  	home.clickFindTransactions();
//
//      String fromDateStr = "03-01-2026";
//      String toDateStr = "03-20-2026";
//
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//
//      LocalDate fromDate = LocalDate.parse(fromDateStr, formatter);
//      LocalDate toDate = LocalDate.parse(toDateStr, formatter);
//
//      // Enter dates
//      WebElement fromDateInput = driver.findElement(By.id("fromDate"));
//      WebElement toDateInput = driver.findElement(By.id("toDate"));
//
//      fromDateInput.clear();
//      fromDateInput.sendKeys(fromDateStr);
//
//      toDateInput.clear();
//      toDateInput.sendKeys(toDateStr);
//
//      // Click search
//     driver.findElement(By.xpath("//button[@id='findByDateRange']")).click();
//
//      // Wait for results
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
//
//      // Get all transaction dates from table
//      List<WebElement> dateElements = driver.findElements(
//          By.xpath("//table//tr[position()>1]/td[1]")
//      );
//
//      for (WebElement el : dateElements) {
//
//          String dateText = el.getText().trim();
//
//          System.out.println("Transaction Date: " + dateText);
//
//          LocalDate transactionDate = LocalDate.parse(dateText, formatter);
//
//          // Core validation
//          Assert.assertTrue(
//              (transactionDate.isEqual(fromDate) || transactionDate.isAfter(fromDate)) &&
//              (transactionDate.isEqual(toDate) || transactionDate.isBefore(toDate)),
//              "Transaction date out of selected range: " + transactionDate
//          );
//      }
//  }
  
    
//    @Test
//    public void verifyTransactionsByDateAndAmountSorted() {
//
//        // Step 1: Navigate
//        home.clickFindTransactions();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
//
//        // Test data
//        String fromDateStr = "03-01-2026";
//        String toDateStr = "03-20-2026";
//        String expectedAmount = "100";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//
//        LocalDate fromDate = LocalDate.parse(fromDateStr, formatter);
//        LocalDate toDate = LocalDate.parse(toDateStr, formatter);
//
//        // Step 2: Enter filters
//        driver.findElement(By.id("fromDate")).sendKeys(fromDateStr);
//        driver.findElement(By.id("toDate")).sendKeys(toDateStr);
//        driver.findElement(By.id("amount")).sendKeys(expectedAmount);
//
//        driver.findElement(By.xpath("//button[@id='findByDateRange']")).click();
//
//        // Step 3: Wait for table
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
//
//        List<WebElement> rows = driver.findElements(
//            By.xpath("//table//tr[position()>1]")
//        );
//
//        Assert.assertTrue(rows.size() > 0, "No transactions found");
//
//        List<LocalDate> actualDates = new ArrayList<>();
//
//        for (WebElement row : rows) {
//
//            // ✅ Date
//            String dateText = row.findElement(By.xpath("td[1]")).getText().trim();
//            LocalDate txnDate = LocalDate.parse(dateText, formatter);
//
//            actualDates.add(txnDate);
//
//            // Validate date range
//            Assert.assertTrue(
//                    (txnDate.isEqual(fromDate) || txnDate.isAfter(fromDate)) &&
//                    (txnDate.isEqual(toDate) || txnDate.isBefore(toDate)),
//                    "Date out of range: " + txnDate
//            );
//
//            // ✅ Amount (Debit OR Credit)
//            String debit = row.findElement(By.xpath("td[3]")).getText().trim();
//            String credit = row.findElement(By.xpath("td[4]")).getText().trim();
//
//            String amount = !debit.isEmpty() ? debit : credit;
//
//            String cleanAmount = amount.replace("$", "").replace(".00", "").trim();
//
//            System.out.println("Date: " + dateText + " | Amount: " + cleanAmount);
//
//            Assert.assertEquals(cleanAmount, expectedAmount,
//                    "Amount mismatch");
//        }
//
//        // ✅ Validate sorting (ascending)
//        List<LocalDate> sortedDates = new ArrayList<>(actualDates);
//        Collections.sort(sortedDates);
//
//        Assert.assertEquals(actualDates, sortedDates,
//                "Transactions are not sorted by date");
//    }
}
