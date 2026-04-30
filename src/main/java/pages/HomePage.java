package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import models.Transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // URL
    public void openHomePage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    // Locators
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@value='Log In']");
    By registerLink = By.linkText("Register");
    private By logoutLink = By.linkText("Log Out");
    private By errorMessage = By.xpath("//p[@class='error']");
    
    private By accountsOverviewLink = By.linkText("Accounts Overview");
    private By accountNumberLink = By.xpath("//table[@id='accountTable']//a");
    private By availableBalance = By.id("availableBalance");
    private By transactionTable = By.id("transactionTable");
    private By accountNumber = By.xpath("//table[@id='accountTable']//a");
    private By accountDetailsTitle = By.xpath("//h1[contains(text(),'Account Details')]");
    
    private By transactionsTable = By.id("transactionTable");
    By accountLink = By.xpath("//a[text()='14343']");
    By findTransactionsLink = By.xpath("//a[text()='Find Transactions']");

    public void clickFindTransactions() {
        wait.until(ExpectedConditions.elementToBeClickable(findTransactionsLink));
        driver.findElement(findTransactionsLink).click();
    }
    

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    // Verifications
    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
    
    public boolean isLogoutVisible() {
        return driver.findElement(logoutLink).isDisplayed();
    }
    
    public String getErrorMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error"))
        );

        return error.getText();
    }
    
    public String getPasswordFieldType() {
        return driver.findElement(passwordField).getAttribute("type");
    }
    
    public boolean isLoginFormVisible() {
        return driver.findElement(By.name("username")).isDisplayed();
    }
    
   

    public void clickAccountsOverview() {
        driver.findElement(accountsOverviewLink).click();
    }

    public void clickFirstAccountNumber() {
        driver.findElement(accountNumberLink).click();
    }

    public boolean isAvailableBalanceDisplayed() {
        return driver.findElement(availableBalance).isDisplayed();
    }

    public boolean isTransactionTableDisplayed() {
        return driver.findElement(transactionTable).isDisplayed();
    }
    
 
    public boolean isAccountDetailsDisplayed() {
        return driver.findElement(accountDetailsTitle).isDisplayed();
    }
    
    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }
    
	public double getAccountBalance() {

	    WebElement balanceElement = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id("availableBalance"))
	    );
	    wait.until(driver -> !driver.findElement(By.id("availableBalance")).getText().trim().isEmpty());

	    String balanceText = balanceElement.getText();

	    // 👇 PUT DEBUG HERE
	    System.out.println("Balance text: '" + balanceText + "'");

	    balanceText = balanceText.replace("$", "").trim();

	    if (balanceText.isEmpty()) {
	        throw new RuntimeException("Balance is empty — check locator or page load");
	    }

	    return Double.parseDouble(balanceText);
	}
	
	public int getTransactionCount() {
	    By rows = By.xpath("//table[@id='transactionTable']//tbody/tr");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(rows));

	    return driver.findElements(rows).size();
	}
	  
	public boolean areTransactionsDisplayed() {
	        return getTransactionCount() > 0;
	    }
	
    public List<String> getTransactionDescriptions() {
        List<WebElement> descriptions = driver.findElements(
                By.xpath("//table[@id='transactionTable']//tbody/tr/td[2]")
        );

        List<String> descList = new ArrayList<>();

        for (WebElement el : descriptions) {
            descList.add(el.getText());
        }

        return descList;
    }
	public void clickFirstAccount() {
	    List<WebElement> accounts = driver.findElements(
	        By.xpath("//table[@id='accountTable']//a")
	    );

	    accounts.get(1).click(); // always click first available account
	}
	
    public List<Transaction> getAllTransactions() {

        By rows = By.xpath("//table[@id='transactionTable']//tbody/tr");

        wait.until(ExpectedConditions.visibilityOfElementLocated(rows));

        List<WebElement> rowElements = driver.findElements(rows);

        List<Transaction> transactions = new ArrayList<>();

        for (WebElement row : rowElements) {

            String date = row.findElement(By.xpath("./td[1]")).getText();
            String description = row.findElement(By.xpath("./td[2]")).getText();
            String amount = row.findElement(By.xpath("./td[3]")).getText();
            String type = row.findElement(By.xpath("./td[4]")).getText();

            transactions.add(new Transaction(date, description, amount, type));
        }

        return transactions;
    }



 

}
