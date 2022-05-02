package com.frontier.automation.pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frontier.automation.base.TestBase;
import com.frontier.automation.reports.ExtentReporterNG;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {

	public HomePage() {
		ExtentReporterNG.reporter.log(LogStatus.PASS, "In Home page");
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "cleartripLogo")
	WebElement logo;

	@FindBy(xpath = "//li[@class='humbger']//div[text()='Flights']")
	WebElement flightOption;

	@FindBy(className = "hotelApp")
	WebElement hotelOption;

	@FindBy(className = "trainsApp")
	@CacheLookup
	WebElement TrainOption;

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public SearchFlightsPage selectFlightOption() {
		if (flightOption.isEnabled()) {
			flightOption.click();
		}
		return new SearchFlightsPage();
	}

}
