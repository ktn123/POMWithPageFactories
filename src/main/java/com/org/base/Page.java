package com.org.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.org.pages.actions.TopNavigation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

public class Page {
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger();// Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Excels\\TestData.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static TopNavigation topNav;
	
	public static void initConfiguration() {
		
		if(Constants.browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
			ChromeOptions crop = new ChromeOptions();
			crop.addArguments("--disable-extensions");
			crop.addArguments("--disable-infobars");
			driver = new ChromeDriver(crop);
			log.error("Chrome browser launched!!");
			
		}else {
			driver = new FirefoxDriver();
			log.error("Firefox browser launched!!");
		}
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		/*
		 * driver.manage().timeouts().implicitlyWait(Constants.implicitwait,
		 * TimeUnit.MILLISECONDS); wait = new WebDriverWait(driver,);
		 */
		topNav = new TopNavigation(driver);
	}
	
	public static void quitBrowser() {
		driver.quit();
		log.error("Quitting Driver.");
	}
	
	public static void click(WebElement element) {
		element.click();
		log.error("Clicking on an element : "+element);
	}
	
	
}
