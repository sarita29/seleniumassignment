package com.sample.page.flipkart;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sample.common.CommonFunction;

public class ElectronicsPage extends CommonFunction {

	private final static Logger logger = Logger.getLogger(ElectronicsPage.class);

	private final String subCategoryHeader = "//h1[contains(text(),'%s')]";

	public WebElement getSubCategoryHeader(String headerName) {
		WebElement element = driver.findElement(By.xpath(String.format(subCategoryHeader, headerName)));
		return element;
	}

	private final String appleItemCategory = "//*[@alt='%s']";

	public WebElement getAppleItemCategory(String itemName) {
		WebElement element = driver.findElement(By.xpath(String.format(appleItemCategory, itemName)));
		return element;
	}

	private final String electronicProducts = "//div[contains(text(),'%s')]";

	public List<WebElement> getElectronicProducts(String itemName) {
		List<WebElement> element = driver.findElements(By.xpath(String.format(electronicProducts, itemName)));
		return element;
	}

	/*
	 * Verify user present on selected page or not where headerName - will be
	 * SamSung, Apple, OPPO
	 */
	public void verifySubCategoryPageHeader(String headerName) {
		waitForVisible(getSubCategoryHeader(headerName));
		assertTrue(getSubCategoryHeader(headerName).isDisplayed(), "user is not on " + headerName + " page");
	}

	/*
	 * click on Apple sub category element like IPhone IPad etc where tabName -
	 * will be IPhone IPad etc
	 */
	public void clickOnAppleItemCategoryTab(String tabName) {
		assertTrue(getAppleItemCategory(tabName).isDisplayed());
		clickUsingJS(getAppleItemCategory(tabName));
	}

	/*
	 * select 1st product from list of product Where productName - will be
	 * product you want to select
	 */
	public void selectProduct(String productName) {
		waitForVisible(getElectronicProducts(productName).get(1));
		assertTrue(getElectronicProducts(productName).get(1).isDisplayed(), "product is not present");
		logger.info("Product is present on page");
		clickUsingJS(getElectronicProducts(productName).get(1));
	}
}
