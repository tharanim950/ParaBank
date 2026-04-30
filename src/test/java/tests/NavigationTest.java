package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsPage;
import pages.HomePage;
import pages.NavigationPage;
import pages.RegisterPage;
import pages.RequestLoanPage;

public class NavigationTest extends BaseTest {
	NavigationPage nav;
	HomePage home;
	RegisterPage register;
	String username;
    String password = "pass123";
	
    @BeforeMethod
    public void initTest() {
        nav= new NavigationPage(driver);
        home = new HomePage(driver);
        register = new RegisterPage(driver);
        
       register.clickRegisterLink(); 
       String username = "user" + System.currentTimeMillis();
      register.registerUser(
      "John",
      "Doe",
      "123 Street",
      "Chennai",
      "TN",
      "600001",
      "9876543210",
      "1234",
      username,
      password
);

     //🔹 Wait for success
//wait.until(ExpectedConditions.visibilityOfElementLocated(
//      By.xpath("//p[contains(text(),'Your account was created successfully')]")
//));
        

       wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // Login (update with your credentials)
//       home.enterUsername("f1");
//       home.enterPassword("123");
//       home.clickLogin();
    }

//    @Test
//    public void validateNavigationAcrossPages() {
//
//
//        // 🔹 Home
//        nav.goToHome();
//        Assert.assertTrue(nav.isATMServicesTitleLoaded(), 
//        	    "ATM Services title is NOT displayed");
//
//        // 🔹 Accounts
//        nav.goToAccounts();
//        Assert.assertTrue(nav.isAccountsPageLoaded(), "Accounts page not loaded");
//
//        // 🔹 Transfer
//        nav.goToTransfer();
//        Assert.assertTrue(nav.isTransferPageLoaded(), "Transfer page not loaded");
//        Assert.assertTrue(nav.isAmountDisplayed(), "Transfer page not loaded");
//
//        // 🔹 Loan
//        nav.goToLoan();
//        Assert.assertTrue(nav.isLoanPageLoaded(), "Loan page not loaded");
//
//        // 🔹 Contact Us
//        nav.goToContact();
//        Assert.assertTrue(nav.isContactPageLoaded(), "Contact page not loaded");
//    }
    
//    @Test
//    public void validateLogoRedirectsToHomePage() {
//
// 
//
//        // Navigate somewhere else first
//    	nav.goToContact();
//    	Assert.assertTrue(nav.isContactPageLoaded(), "Contact page not loaded");
//
//        // Click logo
//        nav.clickLogo();
//
//        // Validate home page
//      
//        Assert.assertTrue(nav.isATMServicesTitleLoaded(), "Logo did not redirect to Home page");
//    }
    
//    @Test
//    public void validateMajorButtonsVisibilityAndClickability() {
//
//        // Apply Loan
//    	nav.goToLoan();
//    	Assert.assertTrue(nav.isApplyButtonVisible(), "Apply button not visible");
//        Assert.assertTrue(nav.isApplyButtonClickable(), "Apply button not clickable");
//
//        // Transfer
//        nav.goToTransfer();
//        Assert.assertTrue(nav.isTransferButtonVisible(), "Transfer button not visible");
//        Assert.assertTrue(nav.isTransferButtonClickable(), "Transfer button not clickable");
//
//        // Submit
//        nav.goToContact();
//        Assert.assertTrue(nav.isSubmitButtonVisible(), "Submit button not visible");
//        Assert.assertTrue(nav.isSubmitButtonClickable(), "Submit button not clickable");
//    }
    
    @Test
    public void validateUILayoutConsistency() {
    	
    	nav.goToAccounts();

        Assert.assertTrue(nav.isFontConsistent(nav.getHeading(), nav.getParagraph()),
                "Font mismatch");



        Assert.assertTrue(nav.isLeftAligned(nav.getHeadingAcc(), nav.getAcctable()),
                "Elements not aligned properly");
    	
    	Assert.assertTrue(nav.isTextAlignedLeft(nav.getHeadingAcc(), "left"),
    	        "Heading is not left aligned");
    	
    	Assert.assertTrue(nav.isAccountTableDisplayed(), "Account table not displayed");
    	
    	int spacing = nav.getVerticalSpacingBy(nav.getHeadingAcc(), nav.getAcctable());

    	Assert.assertTrue(spacing >= 10 && spacing <= 30,
    	        "Spacing between elements is inconsistent");
    	
    	Assert.assertTrue(nav.setScreenSizeAndCheck(1024, 768),
    	        "Screen size not set correctly");
    	
    	Assert.assertTrue(nav.isNotOverlapping(nav.getHeadingAcc(), nav.getAcctable()),
    	        "Elements are overlapping!");
    	
    	Assert.assertTrue(nav.isProperlyAligned(nav.getHeadingAcc(), nav.getAcctable()), "Elements are not properly aligned");
    	
    	Assert.assertTrue(nav.isWidthWithinScreen(nav.getHeadingAcc()),
                "Element is overflowing outside screen width");
    }
    
      
    
    
}