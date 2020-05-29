package com.org.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.base.Page;
import com.org.pages.actions.HomePage;
import com.w2a.utilities.TestUtil;

public class FlightSearchTest extends TestUtil {
	
	@BeforeTest
	public void setUp() {
		log.debug("Before test method.");
		Page.initConfiguration();
		System.out.println("In Before test.");
	}
	
	@Test(dataProvider ="dp")
	public void flightSearchTestCase(Hashtable<String,String> table){
		System.out.println("In flightsearchTestCase.");
		HomePage home= new HomePage();
		log.debug("GotoFlight method called.");
		home.gotoFlight();
		log.debug("bookAFlight method called.");
		home.bookAFlight(table.get("from"),table.get("to"));
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("After Test called.");
		log.debug("AfterTest method called");
		//Can write quit() for driver.
		Page.quitBrowser();
	}
	
}
