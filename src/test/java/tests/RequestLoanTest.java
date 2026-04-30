package tests;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import pages.TransferFundPage;
import pages.RequestLoanPage;

public class RequestLoanTest extends BaseTest {

    
    HomePage home;
    RequestLoanPage rl;
    

    @BeforeMethod
    public void setUpPage() {
    	
    	System.out.println("Driver in test: " + driver);
        
//        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        
        home = new HomePage(driver);
         rl = new RequestLoanPage(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login (update with your credentials)
        home.enterUsername("f1");
        home.enterPassword("123");
        home.clickLogin();
    }

//    @Test
//    public void verifyUserCanRequestLoanWithValidDetails() {
//
//        // Navigate to Request Loan
//        rl.navigateToRequestLoan();
//
//        // Enter loan details
//        rl.enterLoanAmount("1000");
//        rl.enterDownPayment("100");
//
//        rl.selectFromAccount(0);
//       
//
//        // Click Apply
//        rl.clickApplyNow();
//
//        // Wait for success message
//        Assert.assertTrue(rl.isLoanRequestSuccessful(),
//                "Loan request was not successful");
//    }
    
//    @Test
//    public void verifyLoanRequestWithEmptyFieldsShowsError() {
//
//        rl.navigateToRequestLoan();
//
//        // Do NOT enter anything
//
//        rl.clickApplyNow();
//
//        Assert.assertTrue(rl.isErrorDisplayed(),
//                "Error message should be displayed for empty loan request");
//    }
    
//    @Test
//    public void verifyLoanRequestBeyondEligibilityShowsError() {
//
//        rl.navigateToRequestLoan();
//
//        rl.enterLoanAmount("99999999");   // very high
//        rl.enterDownPayment("0");
//
//        rl.selectFromAccount(0);
//        rl.clickApplyNow();
//
//        String status = rl.getLoanStatus();
//
//        Assert.assertTrue(status.contains("Denied"),
//                "Loan should be denied for ineligible amount");
//    }
    
//    @Test
//    public void verifyLoanStatusIsDisplayedCorrectly() {
//    	
//    	   rl.navigateToRequestLoan();
//
//           rl.enterLoanAmount("99999999");   // very high
//           rl.enterDownPayment("0");
//
//           rl.selectFromAccount(0);
//           rl.clickApplyNow();
//
//           String status = rl.getLoanStatus();
//
//           Assert.assertTrue(status.contains("Denied"),
//                   "Loan should be denied for ineligible amount");
//           
//           rl.navigateToRequestLoan();
//
//           rl.enterLoanAmount("1000");   
//           rl.enterDownPayment("100");
//
//           rl.selectFromAccount(0);
//           rl.clickApplyNow();
//
//           String status1 = rl.getLoanStatusApproved();
//
//           Assert.assertTrue(status1.contains("Approved"),
//                   "Loan should be approved for eligible amount");
//    }



}
