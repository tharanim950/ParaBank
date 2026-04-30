package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest extends BaseTest {
	
	@BeforeMethod
	public void setUp() {

	    WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();

	    driver.manage().window().maximize();
	    driver.get("https://parabank.parasoft.com/parabank/index.htmm");
	}

    @Test
    public void openSite() {

        System.out.println("Site opened successfully");

    }

}
