package com.sample.page.flipkart;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sample.common.CommonFunction;

public class HomePage extends CommonFunction {

	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']") // button[text()='✕']
	public WebElement closeLoginPopUp;

	@FindBy(xpath = "//input[contains(@title,'Search for products')]")
	public WebElement searchBox;

	@FindBy(xpath = "//span[text()='Cart']/preceding-sibling::span")
	public WebElement productAddedInCart;

	private final String menuField = "//span[text()='%s']";

	public WebElement getMenufield(String name) {
		WebElement element = driver.findElement(By.xpath(String.format(menuField, name)));
		return element;
	}

	private final String subMenuField = "//*[@title='%s']";

	public WebElement getSubMenufield(String name) {
		WebElement element = driver.findElement(By.xpath(String.format(subMenuField, name)));
		return element;
	}

	public void verifyPage() {
		if(closeLoginPopUp.isDisplayed()){
			closeLoginPopUp.click();
		}
		assertTrue(driver.getTitle().contains("Online Shopping Site for Mobiles"), "user is not on homepage");
		assertTrue(searchBox.isDisplayed(), "search box is not present");
	}

	/*
	 * Used to click sub category present under category for ex: click IPhone
	 * present under electronics tab
	 */
	public void clickOnMenuElement(String subCategory, String category) throws InterruptedException {
		moveToElement(getMenufield(category));
		waitForVisible(getSubMenufield(subCategory));
		assertTrue(getMenufield(subCategory).isDisplayed());
		getSubMenufield(subCategory).click();
		Thread.sleep(5000);
	}

	/*
	 * Used for- verify how many product is added into the cart where
	 * NumberOfProduct - will be the actual product present into the cart
	 */
	public void verifyProductAddedInCart(String NumberOfProduct) {
		assertEquals(productAddedInCart.getText(), NumberOfProduct);
	}
}
