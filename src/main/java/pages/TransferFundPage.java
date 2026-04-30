package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundPage {
    WebDriver driver;
    WebDriverWait wait;

    public TransferFundPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	private By transferFundsLink = By.linkText("Transfer Funds");
	private By amountField = By.id("amount");
	private By fromAccountDropdown = By.id("fromAccountId");
	private By toAccountDropdown = By.id("toAccountId");
	private By transferButton = By.xpath("//input[@value='Transfer']");
	private By transferSuccessMessage = By.xpath("//h1[@class='title' and text()='Transfer Complete!']");
	private By errorMessage = By.xpath("//h1[@class='title' and contains(text(),'Error')]");
	

	private By accountBalance = By.xpath("//td[contains(text(),'Balance')]/following-sibling::td");
	 By accountLink = By.xpath("//a[text()='19560']");
	 
	 By findTransactionsLink = By.xpath("//a[text()='Find Transactions']");
	
	public void clickTransferFunds() {
	    driver.findElement(transferFundsLink).click();
	}

	public void enterAmount(String amount) {
	    driver.findElement(amountField).clear();
	    driver.findElement(amountField).sendKeys(amount);
	}

	public void clickTransfer() {
	    driver.findElement(transferButton).click();
	}

	public boolean isTransferSuccessful() {

	    try {
	        return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//h1[contains(text(),'Transfer Complete')]")
	            )
	        ).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
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
	
	public void selectToAccountByText(String accountNumber) {
	    Select dropdown = new Select(driver.findElement(toAccountDropdown));
	    dropdown.selectByVisibleText(accountNumber);
	}
	
	public void clickFirstAccount() {
	    List<WebElement> accounts = driver.findElements(
	        By.xpath("//table[@id='accountTable']//a")
	    );

	    accounts.get(0).click(); // always click first available account
	}
	
	public void clickSecondAccount() {
	    List<WebElement> accounts = driver.findElements(
	        By.xpath("//table[@id='accountTable']//a")
	    );

	    accounts.get(1).click(); // always click first available account
	}
	public void selectDifferentAccounts() {

	    Select from = new Select(driver.findElement(By.id("fromAccountId")));
	    Select to = new Select(driver.findElement(By.id("toAccountId")));

	    from.selectByIndex(0);
	    to.selectByIndex(1); // ensure different account
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
    


    

    public void clickFindTransactions() {
        wait.until(ExpectedConditions.elementToBeClickable(findTransactionsLink));
        driver.findElement(findTransactionsLink).click();
    }
    
    public double getAccountBalance(String accountId) {

        driver.findElement(By.linkText("Accounts Overview")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

        WebElement balanceElement = driver.findElement(
            By.xpath("//a[text()='" + accountId + "']/parent::td/following-sibling::td[1]")
        );

        String balanceText = balanceElement.getText().replace("$", "").trim();

        return Double.parseDouble(balanceText);
    }
    
    public List<String> getAccountIds(By dropdownLocator) {

        Select dropdown = new Select(driver.findElement(dropdownLocator));

        List<WebElement> options = dropdown.getOptions();
        List<String> accountIds = new ArrayList<>();

        for (WebElement option : options) {
            accountIds.add(option.getAttribute("value")); // IMPORTANT
        }

        return accountIds;
    }
    
    public void goToTransferFundsPage() {
        driver.findElement(By.linkText("Transfer Funds")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
    }
    
    public String selectAccount(By dropdownLocator, int index) {

        Select dropdown = new Select(driver.findElement(dropdownLocator));
        dropdown.selectByIndex(index);

        return dropdown.getFirstSelectedOption().getAttribute("value");
    }
    


    public void performTransfer(String amount) {
        driver.findElement(By.id("amount")).sendKeys(amount);
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();
    }

    public void verifyTransferSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h1[contains(text(),'Transfer Complete')]")
        ));
    }
    
    public String openNewAccount() {

        // Step 1: Navigate to Open New Account page
        driver.findElement(By.linkText("Open New Account")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type")));

        // Step 2: Select account type (0 = Checking, 1 = Savings)
        Select accountType = new Select(driver.findElement(By.id("type")));
        accountType.selectByIndex(0);

        // Step 3: Select existing account (funding account)
        Select fromAccount = new Select(driver.findElement(By.id("fromAccountId")));
        fromAccount.selectByIndex(0);

        // Step 4: Click Open New Account
        driver.findElement(By.xpath("//input[@value='Open New Account']")).click();

        // Step 5: Wait for result
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[@id='newAccountId']")
        ));

        // Step 6: Get new account ID
        String newAccountId = driver.findElement(
            By.xpath("//a[@id='newAccountId']")
        ).getText();

        System.out.println("New Account Created: " + newAccountId);

        return newAccountId;
    }
    
    public boolean isInsufficientBalanceErrorDisplayed() {
        return driver.findElements(
            By.xpath("//*[contains(text(),'Insufficient')]")
        ).size() > 0;
    }
    
    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

	  
	  

}
