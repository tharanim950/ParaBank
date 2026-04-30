package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class RequestLoanPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 Locators
    private By requestLoanLink = By.xpath("//a[@href='requestloan.htm' and text()='Request Loan']");
    private By loanAmount = By.xpath("//input[@id='amount' and @class='input']");
    private By downPayment = By.xpath("//input[@id='downPayment' and @class='input']");
    private By fromAccount = By.xpath("//select[@id='fromAccountId' and @class='input']");
    private By applyButton = By.xpath("//input[@value='Apply Now']");
    private By successMessage = By.xpath("//h1[@class='title' and contains(text(),'Loan Request')]");
    private By errorMessage = By.xpath("//h1[@class='title' and contains(text(),'Error')]");
    private By insufficientFundsError = By.xpath("//p[@class='error' and contains(text(),'sufficient funds')]");
    private By loanStatus = By.xpath("//td[@id='loanStatus' and contains(text(),'Denied')]");
    private By loanStatusApproved = By.xpath("//td[@id='loanStatus' and contains(text(),'Approved')]");

    // 🔹 Actions / Methods

    public void navigateToRequestLoan() {
        driver.findElement(requestLoanLink).click();
    }

    public void enterLoanAmount(String amount) {
        driver.findElement(loanAmount).clear();
        driver.findElement(loanAmount).sendKeys(amount);
    }

    public void enterDownPayment(String downPaymentValue) {
        driver.findElement(downPayment).clear();
        driver.findElement(downPayment).sendKeys(downPaymentValue);
    }

    public void selectFromAccount(int index) {
        Select account = new Select(driver.findElement(fromAccount));
        account.selectByIndex(index);
    }

    public void clickApplyNow() {
        driver.findElement(applyButton).click();
    }

    public boolean isLoanRequestSuccessful() {
        WebElement success = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        );
        return success.isDisplayed();
    }

    // 🔹 Combined Method (Optional but powerful)
    public void applyForLoan(String amount, String downPaymentValue, int accountIndex) {
        navigateToRequestLoan();
        enterLoanAmount(amount);
        enterDownPayment(downPaymentValue);
        selectFromAccount(accountIndex);
        clickApplyNow();
    }
    
    public boolean isErrorDisplayed() {
        WebElement error = wait.until(
            ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );
        return error.isDisplayed();
    }
    
    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
    
    public String getLoanStatus() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(loanStatus)
        ).getText();
    }
    
    public String getLoanStatusApproved() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(loanStatusApproved)
        ).getText();
    }
}