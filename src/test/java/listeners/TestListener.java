package listeners;

import reports.ExtentManager;
import utils.ScreenshotUtil;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseTest;

import org.testng.*;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
        test.get().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
    	// ✅ Get driver from test instance
        Object testClass = result.getInstance();
        BaseTest base = (BaseTest) testClass;
        
        String path = ScreenshotUtil.captureScreenshot(
        		base.getDriver(), result.getName());

        test.get().pass("Test Passed",
                MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
    	// ✅ Get driver from test instance
        Object testClass = result.getInstance();
        BaseTest base = (BaseTest) testClass;
        
        String path = ScreenshotUtil.captureScreenshot(
        		base.getDriver(), result.getName());

        test.get().fail(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Flushing report now...");
        extent.flush();
    }
}
