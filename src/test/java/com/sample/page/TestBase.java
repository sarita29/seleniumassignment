package com.sample.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum TestBase {
	DRIVER;

	public static WebDriver driver;

	public WebDriver getDriver(String driverName) {
		if (driverName.equalsIgnoreCase("chromeDriver")) {
			System.setProperty("webdriver.chrome.driver", "./server/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		}
		return null;
	}
}
