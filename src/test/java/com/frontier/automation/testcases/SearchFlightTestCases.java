package com.frontier.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frontier.automation.base.TestBase;
import com.frontier.automation.pageLocators.HomePage;
import com.frontier.automation.pageLocators.SearchFlightsPage;

public class SearchFlightTestCases extends TestBase {

	SearchFlightsPage searchFlightsPage;
	HomePage homePage;

	public SearchFlightTestCases() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initializaton();
		homePage = new HomePage();
		searchFlightsPage = homePage.selectFlightOption();
	}

	@Test(groups = { "Simple", "UI" })
	public void TC001_VerifyHeaderContent() {
		Assert.assertEquals(searchFlightsPage.getPageHeader(), "Search flights");
	}

	@Test(groups = { "Simple", "UI" })
	public void TC003_VerifyHeaderContent() {
		Assert.assertEquals(searchFlightsPage.getPageHeader(), "Search flights");
	}

	@Test(groups = { "Simple", "UI" })
	public void TC005_VerifyHeaderContent() {
		Assert.assertEquals(searchFlightsPage.getPageHeader(), "Search flights");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() { 
		tearDownMain();
	} 
}
