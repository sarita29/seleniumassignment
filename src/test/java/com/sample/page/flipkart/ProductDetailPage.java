package com.sample.page.flipkart;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sample.common.CommonFunction;

public class ProductDetailPage extends CommonFunction{
	
	@FindBy(xpath = "//*[text()='BUY NOW' or text()='Buy']")//button[contains(text(),'BUY')]/ancestor::li //li/descendant::button[text()='BUY NOW'] And //li/following::button[text()='BUY NOW'] And //*[text()='BUY NOW' and @class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']
	//*[text()='BUY NOW' or @class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c'] 
	
	public WebElement buyNowButton;

	/* Verify product details page */
	 public void verifyProductDescriptionPage() {
		switchToWindow();
		assertEquals(buyNowButton.isDisplayed(), true);
	}

}
