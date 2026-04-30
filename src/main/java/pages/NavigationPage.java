package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;



public class NavigationPage {
	

	    WebDriver driver;

	    public NavigationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // 🔹 Locators
	    private By homeLink = By.xpath("//a[text()='Home']");
	    private By accountsLink = By.xpath("//a[contains(text(),'Accounts Overview')]");
	    private By transferLink = By.xpath("//a[@href='transfer.htm' and text()='Transfer Funds']");
	    private By loanLink = By.xpath("//a[@href='requestloan.htm' and text()='Request Loan']");
	    private By contactUsLink = By.linkText("Contact Us");
	    private By logo = By.xpath("//img[@title='ParaBank']");

	    // 🔹 Page validation elements
	    By welcomeMessage = By.xpath("//h1[contains(text(),'Welcome')]");
	    By successMessageHome = By.xpath("//p[contains(normalize-space(),'Your account was created successfully')]");
	    private By homePageTitle = By.xpath("//h1[contains(text(),'ParaBank')]");
	    private By accountsPageTitle = By.xpath("//h1[@class='title' and normalize-space()='Accounts Overview']");
	    private By transferPageTitle = By.xpath("//h1[@class='title' and text()='Transfer Funds']");
	    private By loanPageTitle = By.xpath("//h1[@class='title' and text()='Apply for a Loan']");
	    private By loanAmount = By.xpath("//input[@id='amount' and @class='input']");
	    private By contactPageTitle = By.xpath("//h1[@class='title' and text()='Customer Care']");
	    private By atmServicesText = By.xpath("//li[@class='captionone' and text()='ATM Services']");
	    private By transferForm =  By.id("amount");
	    
	 // Apply Loan button
	    private By applyLoanBtn = By.xpath("//input[@value='Apply Now']");

	    // Transfer button
	    private By transferBtn = By.xpath("//input[@value='Transfer']");

	    // Submit button (generic)
	    private By submitBtn = By.xpath("//input[@type='submit']");
	    
	 // Example elements (Home Page)
	    private By heading = By.xpath("//h1");
	    private By subHeading = By.xpath("//h2");
	    private By paragraph = By.xpath("//p");
	    
	    private By headingacc = By.xpath("//h1[contains(text(),'Accounts Overview')]");
	    private By accountTable = By.xpath("//table[@id='accountTable']");
	    
//	    WebElement element = driver.findElement(headingacc);
	    
	    public By getHeading() {
	        return heading;
	    }
	    
	    public By getHeadingAcc() {
	        return headingacc;
	    }
	    
	    public By getAcctable() {
	        return accountTable;
	    }
	    
	    public boolean isTextAlignedLeft(By headingacc, String expected) {
	    	WebElement element = driver.findElement(headingacc);
	        String alignment = element.getCssValue("text-align");

	        return alignment.equalsIgnoreCase("left") 
	            || alignment.equalsIgnoreCase("start");
	    }

	    public By getParagraph() {
	        return paragraph;
	    }
	    
	  
	    
//	    Point location = headingacc.getLocation();
	    
	    public boolean isLeftAligned(By element1, By element2) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element1));
	        WebElement el2 = wait.until(ExpectedConditions.visibilityOfElementLocated(element2));

	        int x1 = el1.getLocation().getX();
	        int x2 = el2.getLocation().getX();

	        System.out.println("Heading X: " + x1);
	        System.out.println("Table X: " + x2);

	        return x1 == x2;
	    }

	    // 🔹 Actions + Validations

	    public void goToHome() {
	        driver.findElement(homeLink).click();
	    }
	    
	    public void clickLogo() {
	        driver.findElement(logo).click();
	    }
	    
	    public boolean isElementVisible(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	    }

	    public boolean isElementClickable(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
	    }
	    
	    public boolean isApplyButtonVisible() {
	        return isElementVisible(applyLoanBtn);
	    }

	    public boolean isApplyButtonClickable() {
	        return isElementClickable(applyLoanBtn);
	    }

	    public boolean isTransferButtonVisible() {
	        return isElementVisible(transferBtn);
	    }

	    public boolean isTransferButtonClickable() {
	        return isElementClickable(transferBtn);
	    }

	    public boolean isSubmitButtonVisible() {
	        return isElementVisible(submitBtn);
	    }

	    public boolean isSubmitButtonClickable() {
	        return isElementClickable(submitBtn);
	    }
	    
	    



	    public boolean isHomePageLoaded() {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        return wait.until(
		            ExpectedConditions.visibilityOfElementLocated(homePageTitle)
		        ).isDisplayed();
	        
	    }
	    
	    public boolean isATMServicesTitleLoaded() {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        return wait.until(
		            ExpectedConditions.visibilityOfElementLocated(atmServicesText)
		        ).isDisplayed();
	        
	    }

	    public void goToAccounts() {
	        driver.findElement(accountsLink).click();
	    }

	    public boolean isAccountsPageLoaded() {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        return wait.until(
		            ExpectedConditions.visibilityOfElementLocated(accountsPageTitle)
		        ).isDisplayed();
	        
	    }

	    public void goToTransfer() {
	        driver.findElement(transferLink).click();
	    }

	    public boolean isTransferPageLoaded() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(transferForm)
	        ).isDisplayed();
	    }

	    public void goToLoan() {
	        driver.findElement(loanLink).click();
	    }

	    public boolean isLoanPageLoaded() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(loanAmount)
	        ).isDisplayed();
	        
	    }
	    public boolean isAmountDisplayed() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(transferForm)
	        ).isDisplayed();
	        
	    }

	    public void goToContact() {
	        driver.findElement(contactUsLink).click();
	    }

	    public boolean isContactPageLoaded() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(contactPageTitle)
	        ).isDisplayed();
	        
	    }
	    
	    public String getCssValue(By locator, String property) {
	        return waitForElement(locator).getCssValue(property);
	    }
	    
	    public Point getElementLocation(By locator) {
	        return waitForElement(locator).getLocation();
	    }

	    public Dimension getElementSize(By locator) {
	        return waitForElement(locator).getSize();
	    }
	    
	    public boolean isFontConsistent(By element1, By element2) {
	        String font1 = getCssValue(element1, "font-family");
	        String font2 = getCssValue(element2, "font-family");

	        return font1.equals(font2);
	    }
	    
	    public boolean isTextAligned(By element, String expectedAlignment) {
	        String actualAlignment = getCssValue(element, "text-align");

	        return actualAlignment.equalsIgnoreCase(expectedAlignment);
	    }
	    

	    
	    public WebElement waitForElement(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	    
	    public boolean isTextAligned(WebElement element, String expectedAlignment) {
	        String alignment = element.getCssValue("text-align");
	        
	        return alignment.equalsIgnoreCase(expectedAlignment) 
	            || alignment.equalsIgnoreCase("start");
	    }
	    public boolean isAccountTableDisplayed() {
	        return driver.findElement(accountTable).isDisplayed();
	    }
	    
	    public int getVerticalSpacing(WebElement headingacc, WebElement accountTable) {
	        int topY = headingacc.getLocation().getY() + headingacc.getSize().getHeight();
	        int bottomY = accountTable.getLocation().getY();

	        return bottomY - topY;
	    }
	    
	    public int getVerticalSpacingBy(By headingacc, By accountTable) {
	        WebElement heading = driver.findElement(headingacc);
	        WebElement table = driver.findElement(accountTable);

	        int topY = heading.getLocation().getY() + heading.getSize().getHeight();
	        int bottomY = table.getLocation().getY();

	        return bottomY - topY;
	    }
	    
	    public boolean setScreenSizeAndCheck(int width, int height) {
	        driver.manage().window().setSize(new Dimension(width, height));

	        Dimension size = driver.manage().window().getSize();

	        return size.getWidth() == width && size.getHeight() == height;
	    }
	    
	    public boolean isNotOverlapping(By firstElement, By secondElement) {
	        WebElement e1 = driver.findElement(firstElement);
	        WebElement e2 = driver.findElement(secondElement);

	        Rectangle r1 = e1.getRect();
	        Rectangle r2 = e2.getRect();

	        return !(r1.getX() < r2.getX() + r2.getWidth() &&
	                 r1.getX() + r1.getWidth() > r2.getX() &&
	                 r1.getY() < r2.getY() + r2.getHeight() &&
	                 r1.getY() + r1.getHeight() > r2.getY());
	    }
	    
	    public boolean isProperlyAligned(By e1, By e2) {
	    	WebElement e = driver.findElement(e1);
	    	WebElement d = driver.findElement(e2);
	    	
	        return Math.abs(e.getLocation().getX() - d.getLocation().getX()) < 5;
	    }
	    
	    public boolean isWidthWithinScreen(By locator) {
	        WebElement element = driver.findElement(locator);

	        int elementRight = element.getLocation().getX() + element.getSize().getWidth();
	        int screenWidth = driver.manage().window().getSize().getWidth();

	        return elementRight <= screenWidth;
	    }
	

}
