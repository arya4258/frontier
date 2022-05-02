
  package com.frontier.automation.testcases;
  
  import org.testng.Assert; import org.testng.annotations.*;

import com.frontier.automation.base.TestBase;
import com.frontier.automation.pageLocators.HomePage;
import
  com.google.common.base.Verify;
  
  public class FlightTestCases extends TestBase {
  
  HomePage homepage;
  
  public FlightTestCases() { super(); }
 
  
  
  @BeforeSuite(alwaysRun = true) public void setUp() { initializaton();
  homepage = new HomePage(); }
  
  
  @AfterSuite(alwaysRun = true)
  public void tearDown() { 
  tearDownMain(); 
  }
  }
 