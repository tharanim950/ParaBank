package tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

import pages.HomePage;


public class HomeTest extends BaseTest {
	

    HomePage homePage;


    @BeforeMethod
    public void setupPage() {
    	driver.get("https://parabank.parasoft.com/parabank/index.htm");
    	
        homePage = new HomePage(driver);
       
    }

//    @Test
//    public void verifyHomePageLoadsSuccessfully() {
//
//        HomePage homePage = new HomePage(driver);
//
//        homePage.openHomePage();
//
//        homePage.enterUsername("heedo");
//        homePage.enterPassword("test@123");
//
//        homePage.clickLogin();
//
//        Assert.assertTrue(
//                homePage.isLogoutVisible(),
//                "Login failed - Logout button not visible"
//        );
//    }
	
//    @Test
//    public void verifyLoginFailsWithIncorrectPassword() {
//
//        HomePage homePage = new HomePage(driver);
//
//        homePage.enterUsername("heedo");
//        homePage.enterPassword("wrongpass");
//
//        homePage.clickLogin();
//
//        String error = homePage.getErrorMessage();
//        System.out.println("Actual error message: " + error);
//
//        Assert.assertTrue(
//                error.contains("could not be verified") ||
//                error.contains("error"),
//                "Expected login error message not displayed"
//        );
//    }
	
//	@Test
//	public void verifyLoginWithUnregisteredUsername() {
//
//	    HomePage homePage = new HomePage(driver);
//
//	    homePage.enterUsername("randomuser12345");   // username not registered
//	    homePage.enterPassword("test@123");
//
//	    homePage.clickLogin();
//
//	    String error = homePage.getErrorMessage();
//
//	    System.out.println("Actual error message: " + error);
//
//	    Assert.assertTrue(
//	            error.contains("could not be verified"),
//	            "Error message not displayed for unregistered username"
//	    );
//	}
	
//	@Test
//	public void verifyLoginWithEmptyFields() {
//
//	    HomePage homePage = new HomePage(driver);
//
//	    // Do not enter username or password
//	    homePage.clickLogin();
//
//	    String error = homePage.getErrorMessage();
//
//	    System.out.println("Actual error message: " + error);
//
//	    Assert.assertTrue(
//	            error.toLowerCase().contains("username") ||
//	            error.toLowerCase().contains("password"),
//	            "Error message not displayed for empty login fields"
//	    );
//	}
	
//	@Test
//	public void verifyLoginWithInvalidEmailFormat() {
//
//	    throw new SkipException("Skipping test: Scenario not applicable for this application");
//
//	}
	
//	@Test
//	public void verifyPasswordFieldMasksInput() {
//
//	    HomePage homePage = new HomePage(driver);
//
//	    String fieldType = homePage.getPasswordFieldType();
//
//	    Assert.assertEquals(
//	            fieldType,
//	            "password",
//	            "Password field is not masked"
//	    );
//	}
	
//	@Test
//	public void verifySessionTimeoutAfterIdle() {
//
//	    throw new SkipException("Session timeout not implemented in ParaBank");
//   
//
//	}
    
//    @Test
//    public void verifyRememberMeFunctionality() {
//        throw new SkipException("Remember Me feature not available in ParaBank");
//    }
    
//    @Test
//    public void verifyAccountDetailsDisplay() {
//
//        HomePage homePage = new HomePage(driver);
//
//        // Login
//        homePage.enterUsername("nom1");
//        homePage.enterPassword("123");
//        homePage.clickLogin();
//
//        // Navigate to account overview
//        homePage.clickAccountsOverview();
//
//        // Click account number
//        homePage.clickFirstAccountNumber();
//
//        // Verify balance displayed
//        Assert.assertTrue(
//                homePage.isAvailableBalanceDisplayed(),
//                "Available balance not displayed"
//        );
//
//        // Verify transactions displayed
//        Assert.assertTrue(
//                homePage.isTransactionTableDisplayed(),
//                "Recent transactions not displayed"
//        );
//    }
    
    @Test
    public void verifyAccountOverviewAndAccountDetails() {

        HomePage homePage = new HomePage(driver);

        // Login
        homePage.enterUsername("nom3");
        homePage.enterPassword("123");
        homePage.clickLogin();

        // Click Accounts Overview
        homePage.clickAccountsOverview();

        // Click account number
        homePage.clickAccountLink();

        // Verify account details page
        Assert.assertTrue(
                homePage.isAccountDetailsDisplayed(),
                "Account details page not displayed"
        );

        // Verify available balance
        Assert.assertTrue(
                homePage.isAvailableBalanceDisplayed(),
                "Available balance not visible"
        );

        // Verify recent transactions
        Assert.assertTrue(
                homePage.isTransactionTableDisplayed(),
                "Recent activity table not displayed"
        );
    }
}