package com.sample.stepdefs;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.sample.common.CommonFunction;
import com.sample.common.GetDataFromExcel;
import com.sample.page.cleartrip.SearchFlightPage;
import com.sample.page.cleartrip.SearchResultPage;
import com.sample.page.flipkart.ElectronicsPage;
import com.sample.page.flipkart.HomePage;
import com.sample.page.flipkart.ProductDetailPage;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination extends CommonFunction{
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@Given("^user open browser and application$")
	public void openBrowser() throws IOException{
		getDriver();
		openApp();
	}

	@Then("^user verify homepage")
	public void verifyHomePage(){
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.verifyPage();
	}
	
	@When("^user click on \"([^\"]*)\" under \"([^\"]*)\" tab$")
	public void clickOnSubCategoryUnderCategory(String subCategory , String category) throws Exception{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		home.clickOnMenuElement(data.get(scenario.getName(), subCategory),data.get(scenario.getName(), category));
	}
	
	@Then("^verify user landed on \"([^\"]*)\" page$")
	public void verifyPageHeader(String pageName){
		ElectronicsPage electronics = PageFactory.initElements(driver, ElectronicsPage.class);
		electronics.verifySubCategoryPageHeader(pageName);
	}
	
	@When("^user click on \"([^\"]*)\" tab$")
	public void clickOnTab(String tabName) {
		ElectronicsPage electronics = PageFactory.initElements(driver, ElectronicsPage.class);
		electronics.clickOnAppleItemCategoryTab(tabName);
	}
	
	@When("^user select \"([^\"]*)\" product$")
	public void selectProduct(String productName){
		ElectronicsPage electronics = PageFactory.initElements(driver, ElectronicsPage.class);
		electronics.selectProduct(productName);
	}
	
	@Then("^user verify product description page$")
	public void verifyProductDescription(){
		ProductDetailPage detailPage = PageFactory.initElements(driver, ProductDetailPage.class);
		detailPage.verifyProductDescriptionPage();
	}
	
	@Then("^user verify search flight page$")
	public void verifyHomePageOfApp() throws InterruptedException{
		SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;
		searchPage.verifySearchPage();
	}
	@When("^user click on \"([^\"]*)\" button$")
	public void clickOnButton(String buttonName){
		SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;
		searchPage.clickOnButton(buttonName);
	}
	
	@Then("^user verify the searched flight$")
	public void verifySearchedFlight(){
		SearchResultPage searchPage = PageFactory.initElements(driver, SearchResultPage.class);;
		searchPage.verifyListOfFlight();
	}
	@When("^user fill form \"([^\"]*)\" and to \"([^\"]*)\" detail$")
	public void fillFromAndToDetail(String fromValue,String toValue){
		SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;
		searchPage.selectFromAndToValue(fromValue, toValue);
	}
	
	@When("^user select \"([^\"]*)\" date \"([^\"]*)\"$")
	public void selectDate(String type,String date){
		SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;
		searchPage.selectDateFromCalendar(type,date);
	}
}