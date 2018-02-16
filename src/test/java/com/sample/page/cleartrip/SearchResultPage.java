package com.sample.page.cleartrip;

import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sample.common.CommonFunction;

public class SearchResultPage extends CommonFunction {
	
	private final static Logger logger = Logger.getLogger(SearchResultPage.class);
	
	@FindBy(xpath = "//*[contains(@class,'listItem')]")
	public List<WebElement>  listOfFlights;

	@FindBy(xpath = "//button[@class='booking fRight']")
	public WebElement bookButton;
	
	
	public void verifyListOfFlight() {
		//waitForVisible(bookButton);
		logger.info("list of flights:::"+listOfFlights.size());
		Assert.assertThat(listOfFlights.size(), Matchers.greaterThan(0));
	}
	
}
