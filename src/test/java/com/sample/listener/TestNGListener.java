package com.sample.listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sample.common.CommonFunction;

public class TestNGListener extends CommonFunction implements ITestListener {

	WebDriver driver = null;

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName().toString().trim();
		System.out.println("methodName:::" + methodName);
		try {
			takeScreenShot(methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tearDown();
		System.out.println("methodName:::" + methodName);
	}

	public void onTestFailure(ITestResult result) {
		String methodName =result.getName().toString().trim();
		System.out.println("methodName:::" + methodName);
		try {
			takeScreenShot(methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tearDown();
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		tearDown();
	}

}
