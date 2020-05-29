package com.org.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/span/a/small/span")
	public WebElement support;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/ul/li[2]/a")
	public WebElement hotels;
	
	//Demo Of FindAll
	@FindAll({
		@FindBy(id= ""),        //If id not found then will look for css else won't.
		@FindBy(css = "")
	})
	public List<WebElement> Hotels;
	
	/*
	@FindBys : When the required WebElement objects need 
	to match all of the given criteria use @FindBys annotation

	@FindAll : When required WebElement objects need to match at 
	least one of the given criteria use @FindAll annotation
	
	Syntax Same
	*/
	
}
