package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class ContactUsPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 Locators
    private By contactUsLink = By.linkText("Contact Us");
    private By nameField = By.xpath("//input[@id='name' and @name='name']");
    private By emailField = By.xpath("//input[@id='email' and @name='email']");
    private By phoneField = By.xpath("//input[@id='phone' and @name='phone']");
    private By messageField = By.xpath("//textarea[@id='message' and @name='message']");
    private By sendButton = By.xpath("//input[@value='Send to Customer Care']");
    private By thankYouMsg = By.xpath("//p[contains(text(),'Thank you')]");
    private By nameError = By.xpath("//span[@id='name.errors' and contains(text(),'Name is required')]");
    private By emailError = By.xpath("//span[@id='email.errors' and contains(text(),'Email is required')]");
    private By phError =By.xpath("//span[@id='phone.errors' and text()='Phone is required.']");
    private By messageError = By.xpath("//span[@id='message.errors' and text()='Message is required.']");
    private By contactMsg = By.xpath("//p[contains(text(),'Customer Care Representative')]");

    // 🔹 Actions

    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }

    // 🔹 Validations

    public boolean isSupportFormDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
        ).isDisplayed();
    }

    public boolean isFullFormDisplayed() {
        return driver.findElement(nameField).isDisplayed()
                && driver.findElement(emailField).isDisplayed()
                && driver.findElement(messageField).isDisplayed()
                && driver.findElement(sendButton).isDisplayed();
    }
    
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSend() {
        driver.findElement(sendButton).click();
    }
    
    public void submitContactForm(String name, String email, String phone, String message) {
        enterName(name);
        enterEmail(email);
        enterPhone(phone);
        enterMessage(message);
        clickSend();
    }
    
    public boolean isSuccessMessageDisplayed() {
        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(thankYouMsg)
        );
        return msg.isDisplayed();
    }

    public String getSuccessMessageText() {
        return driver.findElement(thankYouMsg).getText();
    }
    
    public boolean isConfirmationMessageDisplayed() {
        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(contactMsg)
        );
        return msg.isDisplayed();
    }

    public String getConfirmationMessageText() {
        return driver.findElement(contactMsg).getText();
    }
    
    public boolean isNameErrorDisplayed() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(nameError)
        ).isDisplayed();
    }

    public boolean isEmailErrorDisplayed() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(emailError)
        ).isDisplayed();
    }
    
    public boolean isPhoneErrorDisplayed() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(phError)
        ).isDisplayed();
    }

    public boolean isMessageErrorDisplayed() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(messageError)
        ).isDisplayed();
    }
    
    public boolean areAllErrorsDisplayed() {
        return isNameErrorDisplayed()
            && isEmailErrorDisplayed()
            && isPhoneErrorDisplayed()
            && isMessageErrorDisplayed();
    }
    
    
}
