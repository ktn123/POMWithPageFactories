package com.org.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.org.pages.locators.TopNavigationLocators;

public class TopNavigation  {
	
	public TopNavigationLocators topNavigate;
	
	public TopNavigation(WebDriver driver){
		this.topNavigate = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.topNavigate);
	}
	
	public SignInPage gotoSignIn() {
		
		return new SignInPage();
	}

	public void gotoSignUp() {

	}

	public void gotoList() {

	}

	public void gotoSupport() {
		topNavigate.support.click();
	}
	public void gotoHome() {

	}
	public void gotoFlights() {

	}

}
