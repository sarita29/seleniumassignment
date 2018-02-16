package com.sample.page.cleartrip;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.sample.common.CommonFunction;

public class SearchFlightPage extends CommonFunction {
	private final static Logger logger = Logger.getLogger(SearchFlightPage.class);
	
	@FindBy(xpath = "//h1[contains(text(),'Search flights')]")
	public WebElement searchFlightHeader;
	
	@FindBy(xpath ="//a[@data-handler='next']")
	public WebElement calendarNextButton;
	
	@FindBy(xpath ="//input[@title='Depart date']")
	public WebElement departOnDate;
	
	@FindBy(xpath ="//input[@title='Return date']")
	public WebElement returnDate;
	
	@FindBy(xpath ="//input[@title='Any worldwide city or airport'][@id='FromTag']")
	public WebElement fromField;
	
	@FindBy(xpath ="//input[@title='Any worldwide city or airport'][@id='ToTag']")
	public WebElement toField;
	
	@FindBy(xpath ="//input[@id='SearchBtn']")
	public WebElement searchButton;
	
	@FindBy(xpath ="//select[@id='Adults']")
	public WebElement adultsdropDown;
	
	@FindBy(xpath ="//input[@value='OneWay']")
	public WebElement oneWayIcon;
	
	@FindBy(xpath ="//input[@value='RoundTrip']")
	public WebElement roundTripIcon;
	
	private final String selectDate = "//td[@data-month='%s' and @data-year='%s' ]/a[text()='%s']";

	public WebElement selectDate(int month, String year, String day) {
		WebElement element = driver.findElement(By.xpath(String.format(selectDate, month , year , day)));
		return element;
	}
	
	public void verifySearchPage(){
		assertTrue(searchFlightHeader.isDisplayed());
		logger.info("user is on search flight page");
		
	}

	public void selectDateFromCalendar(String typeOfDate , String date){
		if(typeOfDate.equalsIgnoreCase("depart on")){
			waitForVisible(departOnDate);
			assertTrue(departOnDate.isDisplayed());
			departOnDate.clear();
			departOnDate.sendKeys(date);
		}else{
			waitForVisible(returnDate);
			assertTrue(returnDate.isDisplayed());
			returnDate.clear();
			returnDate.sendKeys(date);
		}
		searchFlightHeader.click();
	}
	
	public void selectFromAndToValue(String fromValue, String toValue){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		waitForVisible(fromField);
		fromField.clear();
		fromField.sendKeys(fromValue);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		Reporter.log("User entered the From detail");
		
		toField.clear();
		toField.sendKeys(toValue);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		Reporter.log("User entered the To detail");
		
	}
	
	public void clickOnButton(String buttonName) {
		if (buttonName.equalsIgnoreCase("Search")) {
			assertTrue(searchButton.isEnabled());
			searchButton.click();
		}
		if(buttonName.equalsIgnoreCase("One Way")){
			assertTrue(oneWayIcon.isEnabled());
			oneWayIcon.click();
		}
		if(buttonName.equalsIgnoreCase("Round Trip")){
			assertTrue(roundTripIcon.isEnabled());
			roundTripIcon.click();
		}
		Reporter.log("user clicked on "+ buttonName + "button");
	}
	
	
	
}
