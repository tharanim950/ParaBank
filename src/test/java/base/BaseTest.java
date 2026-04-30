	package base;

	import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Listeners;
	import listeners.TestListener;

	@Listeners(TestListener.class)
	public class BaseTest {

	    protected  WebDriver driver;
	    protected WebDriverWait wait;
	    
	    public WebDriver getDriver() {
	        return driver;
	    }

	    @BeforeMethod(alwaysRun = true)
	    public void setUp() {

	        WebDriverManager.chromedriver().setup();

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-gpu");
	        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	        String headless = System.getProperty("headless");

	        if ("true".equalsIgnoreCase(headless)) {
	            options.addArguments("--headless=new");
	            options.addArguments("--disable-gpu");
	            options.addArguments("--window-size=1920,1080");
	        }
	        driver = new ChromeDriver(options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       // driver.manage().window().setSize(new Dimension(1920,1080));
	        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
	    }

	    @AfterMethod(alwaysRun = true)
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	

}
