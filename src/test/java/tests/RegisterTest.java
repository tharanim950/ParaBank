package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

//    @Test
//    public void verifyUserCanRegisterSuccessfully() {
//
//        // 🔹 Navigate
//        driver.get("https://parabank.parasoft.com/parabank/register.htm");
//
//        RegisterPage register = new RegisterPage(driver);
//
//        // 🔹 Unique username
//        String username = "user" + System.currentTimeMillis();
//
//        // 🔹 Register
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
//                "pass123"
//        );
//
//        // 🔹 Wait for success message
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//p[contains(text(),'Your account was created successfully')]")
//        ));
//
//        // 🔹 Assertion
//        Assert.assertTrue(
//                driver.getPageSource().contains("Your account was created successfully"),
//                "Registration failed"
//        );
//    }
}