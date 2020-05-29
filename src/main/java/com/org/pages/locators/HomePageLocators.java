package com.org.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	
	@FindBy(xpath ="//*[@id=\"header\"]/div[1]/ul/li[1]/a")
	public WebElement flightTab;
	
	@FindBy(id ="gosuggest_inputSrc")
	public WebElement fromInputField;
	
	@FindBy(id ="gosuggest_inputDest")
	public WebElement to;
	
	@FindBy(xpath ="//*[@id=\"departureCalendar\"]")
	public WebElement openCalender;
	
	@FindBy(id ="fare_20200528")
	public WebElement departuringDate;
	
	@FindBy(xpath ="//*[@id=\"departureCalendar\"]")
	public WebElement enterDate;
	
//	@FindBy(xpath ="//*[@data-day=\"22\"]")
//	public WebElement depDate;
//	
//	@FindBy(xpath ="//*[@data-day=\"25\"]")
//	public WebElement retDate;

	@FindBy(id ="gi_search_btn")
	public WebElement searchButton;
	
//	@FindBy(xpath ="//*[@id=\"wizard-flight-pwa-1\"]/div[3]/div[3]/div/button[1]")
//	public WebElement travelers;
//	
//	@FindBy(xpath ="//*[@id=\"wizard-flight-pwa-1\"]/div[4]/div/button")
//	public WebElement search;
	
	
}
