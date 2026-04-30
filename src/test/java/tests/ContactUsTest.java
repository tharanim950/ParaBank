package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    ContactUsPage contact;

    @BeforeMethod
    public void initTest() {
        contact = new ContactUsPage(driver);
    }

//    @Test
//    public void verifyContactUsLinkOpensSupportForm() {
//
//        contact.clickContactUs();
//
//        Assert.assertTrue(contact.isSupportFormDisplayed(),
//                "Support form should be displayed after clicking Contact Us");
//        Assert.assertTrue(contact.isFullFormDisplayed(),
//                "All fields should be visible in Contact Us form");
//    }
    
//    @Test
//    public void verifyUserCanSubmitContactFormSuccessfully() {
//
//        contact.clickContactUs();
//
//        contact.submitContactForm(
//                "Test User",
//                "test@gmail.com",
//                "1234567890",
//                "Need help with my account"
//        );
//
//        Assert.assertTrue(contact.isSuccessMessageDisplayed(),
//                "Success message should be displayed");
//
//        // 🔥 Strong assertion
//        Assert.assertTrue(contact.getSuccessMessageText().contains("Thank you"),
//                "Message should confirm submission");
//    }
    
//    @Test
//    public void verifyContactFormWithEmptyFieldsShowsError() {
//
//        contact.clickContactUs();
//
//        // Do NOT enter any data
//        contact.clickSend();
//
//        Assert.assertTrue(contact.areAllErrorsDisplayed(),
//                "Error messages should be displayed for empty form submission");
//    }
    
//  @Test
//  public void verifyFormSubmissionSuccessMessage() {
//
//      contact.clickContactUs();
//
//      contact.submitContactForm(
//              "Test User",
//              "test@gmail.com",
//              "1234567890",
//              "Need help with my account"
//      );
//
//      Assert.assertTrue(contact.isSuccessMessageDisplayed(),
//              "Success message should be displayed");
//
//      // 🔥 Strong assertion
//      Assert.assertTrue(contact.getSuccessMessageText().contains("Thank you"),
//              "Message should confirm submission");
//      
//      Assert.assertTrue(contact.isConfirmationMessageDisplayed(),
//              "Success message should be displayed");
//
//      // 🔥 Strong assertion
//      Assert.assertTrue(contact.getConfirmationMessageText().contains("Customer"),
//              "Message should confirm submission");
//  }


}