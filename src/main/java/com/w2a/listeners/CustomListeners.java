package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.org.base.Page;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends Page implements ITestListener {

	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output", "false"); // Required for showing screenshot link
																				// declared below
		TestUtil.captureScreenshot();

		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName
				+ "><img src=\"C:\\Users\\Ketan\\Pictures\\Screenshots\\Screenshot(2).png\" height=\"200px\" width=\"200px\"></img></a>");

		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		rep.endTest(test);
		rep.flush();
	}

	public void onTestStart(ITestResult arg0) {
		test = rep.startTest(arg0.getName().toUpperCase());
		System.out.println("Method name passed from onTestStart : " + arg0.getName());
		if (!TestUtil.isTestRunnable(arg0.getName(), excel)) {
			throw new SkipException("Skipping the test " + arg0.getName().toUpperCase() + " as the run mode is No");
		}
	}

	public void onTestSuccess(ITestResult arg0) {
		
		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + "PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {
		
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase() + " Skipped the test.");
		rep.endTest(test);
		rep.flush();
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
