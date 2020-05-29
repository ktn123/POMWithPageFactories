package com.org.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.org.base.Page;
import com.org.pages.locators.HomePageLocators;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Page {

	public HomePageLocators home;

	public HomePage() {
		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.home);
		test.log(LogStatus.INFO	, "HomePage elements Initialized.");
		log.debug("HomePage elements Intialized.");
		System.out.println("HomePage Constructor called.");
	}

	public void gotoFlight() {
		click(home.flightTab);
		test.log(LogStatus.INFO	, "Flight Tab Clicked.");
		log.debug("FLight Tab Clicked");
		System.out.println("Flight tab is clicked.");
	}

	public void bookAFlight(String from, String to) {
		System.out.println("BookAFlight method called.");
		Actions builder = new Actions(driver);
		home.fromInputField.sendKeys(from);
		builder.sendKeys(Keys.TAB);
		test.log(LogStatus.INFO	, "From city enetered and Tab Pressed.");
		log.debug("From city enetered and Tab Pressed.");
		home.to.sendKeys(to);
		builder.sendKeys(Keys.TAB);
		test.log(LogStatus.INFO	, "To city enetered and TAB Presses.");
		log.debug("To city enetered and TAB Presses.");
		click(home.openCalender);
		test.log(LogStatus.INFO	, "Calender clicked.");
		log.debug("Calender clicked.");
		click(home.departuringDate);
		test.log(LogStatus.INFO	, "Departuring Date Selected.");
		log.debug("Departuring Date Selected.");
		click(home.searchButton);
		test.log(LogStatus.INFO	, "SearchButton Clicked.");
		log.debug("SearchButton Clicked.");
		
	}

}
