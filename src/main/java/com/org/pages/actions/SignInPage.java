package com.org.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.org.base.Page;
import com.org.pages.locators.SignInPageLocators;


public class SignInPage {
public SignInPageLocators signIn;
	
	public SignInPage(){
		this.signIn = new SignInPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(Page.driver,10);
		PageFactory.initElements(factory, this.signIn);
	}
	
}
