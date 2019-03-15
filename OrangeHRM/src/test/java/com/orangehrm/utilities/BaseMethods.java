package com.orangehrm.utilities;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import utilities.HelperMethods;
//import utilities.Pages;

public class BaseMethods {
	protected WebDriver driver;
	// protected Pages pages;

	public static UsableMethods myLib;
	protected static ExtentReports report;
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentTest extentLogger;

	@BeforeMethod
	public void setupMethod() {
		driver = Driver.getDriver();
		// pages = new Pages();
		// we can write method here
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		// if any test fails it can detect it, take a screen shot at the point and
		// attach it to report
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotLocation = HelperMethods.getScreenshot(result.getName());
				extentLogger.fail("Test Failed - " + result.getName());
				extentLogger.addScreenCaptureFromPath(screenshotLocation);
				extentLogger.fail(result.getThrowable());

//				String screenshotLocation;
//				screenshotLocation = System.getProperty("user.dir") + "\\ExtentReports\\report_" + HelperMethods.getScreenshot(result.getName())+".png";
//				htmlReporter = new ExtentHtmlReporter(screenshotLocation);
//				report.attachReporter(htmlReporter);

				htmlReporter.config().setDocumentTitle("Orange HRM Reports_Pictures");
				htmlReporter.config().setReportName("Orange HRM Reports_All_Pictures");

				// myLib.captureScreenshot("failure", result.getName());
				extentLogger.fail("Test Failed - " + result.getName());
				extentLogger.addScreenCaptureFromPath(screenshotLocation);
				extentLogger.fail(result.getThrowable());
				Thread.sleep(1000);
				// Driver.closeDriver();
			} else if (result.getStatus() == ITestResult.SKIP) {
				// extentLogger.skip("Test Case Skipped - " + result.getName());
				// myLib.captureScreenshot("skipped", result.getName());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				//extentLogger.pass("Test Passed - " + result.getName());
				// myLib.captureScreenshot("passed", result.getName());
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// assertTrue(true);
		}
	}

	@BeforeTest
	public void setUpTest() {
		report = new ExtentReports();
		String filePath;
		if (System.getProperty("os.name").toLowerCase().contains("mac"))
			filePath = System.getProperty("user.dir") + "/test-output/report.html";
		else
			filePath = System.getProperty("user.dir") + "\\ExtentReports\\report_" + UsableMethods.getCurrentTime()
					+ ".html";
		htmlReporter = new ExtentHtmlReporter(filePath);
		report.attachReporter(htmlReporter);
		// report.setSystemInfo("HostName", "LAPTOP-TPX1Yoga2ndSE");
		// report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
		htmlReporter.config().setDocumentTitle("Orange HRM Reports");
		htmlReporter.config().setReportName("Orange HRM Reports_All");
	}

	@AfterTest
	public void tearDownTest() {
		report.flush();
		Driver.closeDriver();
	}
}
