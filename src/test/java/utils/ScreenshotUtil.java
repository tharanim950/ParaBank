package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    String folderPath = System.getProperty("user.dir") 
	            + File.separator + "target" 
	            + File.separator + "screenshots";
	    
	    if (driver != null) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        ts.getScreenshotAs(OutputType.FILE);
	    }

	    File folder = new File(folderPath);

	    if (!folder.exists()) {
	        folder.mkdirs();
	    }

	    String fileName = testName + "_" + timeStamp + ".png";
	    String absolutePath = folderPath + File.separator + fileName;

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    File destination = new File(absolutePath);

	    try {
	        Files.copy(source.toPath(), destination.toPath(), 
	                   java.nio.file.StandardCopyOption.REPLACE_EXISTING);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // 🔥 RETURN RELATIVE PATH FOR EXTENT
	    return "screenshots/" + fileName;
	}
	
	
}