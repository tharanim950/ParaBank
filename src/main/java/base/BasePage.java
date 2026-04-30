package base;

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

	public class BasePage {

	    protected WebDriver driver;
	    protected WebDriverWait wait;

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Wait for element visibility
	    protected WebElement waitForElement(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    // Click element
	    protected void click(By locator) {
	        waitForElement(locator).click();
	    }
	    
	    public void clear(By locator) {
	        driver.findElement(locator).clear();
	    }

	    // Type text
	    protected void type(By locator, String text) {
	        WebElement element = waitForElement(locator);
	        element.clear();
	        element.sendKeys(text);
	    }

	    // Get text
	    protected String getText(By locator) {
	        return waitForElement(locator).getText();
	    }

	    // Check if element displayed
	    protected boolean isDisplayed(By locator) {
	        return waitForElement(locator).isDisplayed();
	    }

	    // Scroll to element
	    protected void scrollToElement(By locator) {

	        WebElement element = waitForElement(locator);

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	    // Select dropdown by visible text
	    protected void selectDropdownByText(By locator, String text) {

	        WebElement element = waitForElement(locator);

	        Select dropdown = new Select(element);

	        dropdown.selectByVisibleText(text);
	    }

	    // Get page title
	    protected String getPageTitle() {

	        return driver.getTitle();
	    }

	    // Take screenshot
	    protected void takeScreenshot(String fileName) {

	        TakesScreenshot ts = (TakesScreenshot) driver;

	        File src = ts.getScreenshotAs(OutputType.FILE);

	        try {

	            FileUtils.copyFile(src, new File("screenshots/" + fileName + ".png"));

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	    }
	

}
