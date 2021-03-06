package com.frontier.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.frontier.automation.reports.ExtentReporterNG;
import com.frontier.automation.utilities.GenericActions;
import com.frontier.automation.utilities.TestUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	protected static WebDriver driver;
	protected static Properties properties;
	protected static GenericActions sele_Actions;
	protected static EventFiringWebDriver e_driver;
	protected static ChromeOptions chromeOptions;
	protected static Logger log;

	/*
	 * protected ITestResult result; protected ExtentReports extent; protected
	 * ExtentTest extentTest;
	 */
	public TestBase() {

		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/frontier/automation/config/config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");

		}

	}

	protected static void initializaton() {
		ExtentReporterNG.setupExtentReport();
		ExtentReporterNG.reporter.log(LogStatus.PASS, "In inititializer");
		String browserName = properties.getProperty("browser");
		driver = getDriver(browserName);

		e_driver = new EventFiringWebDriver(driver);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));

		sele_Actions = new GenericActions();

	}

	private static WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", TestUtils.WORKSAPCE_PATH + "//drivers//chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", TestUtils.WORKSAPCE_PATH + "//drivers//geckodriver.exe");
			return new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", TestUtils.WORKSAPCE_PATH + "//drivers//IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;
	}

	public void tearDownMain() {
		ExtentReporterNG.extentReport.endTest(ExtentReporterNG.reporter);
		ExtentReporterNG.extentReport.flush();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	/*
	 * public void setExtend() { extent = new
	 * ExtentReports(System.getProperty("user.dir") +
	 * "//test-output//+NewExtentReport.html", true); Map<String, String> info = new
	 * HashMap<String, String>(); info.put("host name", "Krishna Windows");
	 * info.put("user name", "Krishna"); info.put("Environment", "QA");
	 *
	 * extent.addSystemInfo(info);
	 *
	 * }
	 *
	 * public void FormatResult() { if (result.getStatus() == ITestResult.FAILURE) {
	 * extentTest.log(LogStatus.FAIL, "Failed test case is ::" + result.getName());
	 * extentTest.log(LogStatus.FAIL, "Failed test case is ::" +
	 * result.getThrowable()); TestUtils.takeScreenShot(driver);
	 * extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreenCapture(TestUtils.SCREENSHOT_PATH)); } else if
	 * (result.getStatus() == ITestResult.SKIP) { extentTest.log(LogStatus.SKIP,
	 * "Skipped test case is ::" + result.getName()); } else if (result.getStatus()
	 * == ITestResult.SUCCESS) { extentTest.log(LogStatus.PASS,
	 * "Passed testc case is ::" + result.getName()); }
	 *
	 * extent.endTest(extentTest);
	 *
	 * }
	 */}
