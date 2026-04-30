package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");

    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirmPassword = By.id("repeatedPassword");

    By registerButton = By.xpath("//input[@value='Register']");
    By registerLink = By.xpath("//a[contains(text(),'Register')]");
    
    

    // Actions
    
    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }
    
    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void enterCity(String value) {
        driver.findElement(city).sendKeys(value);
    }

    public void enterState(String value) {
        driver.findElement(state).sendKeys(value);
    }

    public void enterZip(String value) {
        driver.findElement(zipCode).sendKeys(value);
    }

    public void enterPhone(String value) {
        driver.findElement(phone).sendKeys(value);
    }

    public void enterSSN(String value) {
        driver.findElement(ssn).sendKeys(value);
    }

    public void enterUsername(String value) {
        driver.findElement(username).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void enterConfirmPassword(String value) {
        driver.findElement(confirmPassword).sendKeys(value);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    // 🔥 Best practice method (single call)
    public void registerUser(
            String fname, String lname, String addr,
            String cityVal, String stateVal, String zip,
            String phoneVal, String ssnVal,
            String user, String pass) {

        enterFirstName(fname);
        enterLastName(lname);
        enterAddress(addr);
        enterCity(cityVal);
        enterState(stateVal);
        enterZip(zip);
        enterPhone(phoneVal);
        enterSSN(ssnVal);
        enterUsername(user);
        enterPassword(pass);
        enterConfirmPassword(pass);
        clickRegister();
    }
}