package com.sample.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.page.TestBase;

import cucumber.api.Scenario;

@SuppressWarnings("all")
public class CommonFunction {
	
	public GetDataFromExcel data = new GetDataFromExcel();
	public Scenario scenario;
	Properties prop = new Properties();
	InputStream input = null;
	
	public static WebDriver driver;
	
	public void getDriver() throws IOException{
		input = new FileInputStream("./src/test/resources/application.properties");
		prop.load(input);
		TestBase base =  TestBase.DRIVER;
		driver = base.getDriver(prop.getProperty("drivername"));
	}
	
	public void openApp() throws IOException {
		input = new FileInputStream("./src/test/resources/application.properties");
		prop.load(input);
		driver.get(prop.getProperty("baseurl"));
	}

	// Move to web element using actions class
	protected void moveToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	// Explicit Wait for element till element visible on screen
	protected void waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Click using java scripts
	protected void clickUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// Click using action class
	protected void clickUsingActionClass(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	// Sendkeys using java scripts, Using id of particular element and Also used
	// to select value from dropdown
	protected void sendKeysUsingJS(String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').value='" + value + "';");
	}

	// Sendkeys using java scripts, Using id of particular element
	protected void sendKeysUsingActionsClass(WebElement element, String value) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().sendKeys(value).build().perform();
	}

	// Get screenshot method
	protected void takeScreenShot(String methodName) throws IOException {
		File file = new File("testresults");
		file.getAbsolutePath();
		String screenShotName = methodName + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desFile = new File("./testresults/" + screenShotName);
		FileUtils.copyFile(scrFile, desFile);
	}

	// Drag and drop method using actions class
	protected void dragAndDropUsingActions(WebElement srcElement, WebElement desElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(srcElement, desElement).build().perform();
	}

	// Wait for particular element using fluent wait
	protected void waitForElementUsingFluentWait(final WebElement element) {
		try {
			if (!element.isEnabled()) {

				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
						.pollingEvery(1, TimeUnit.SECONDS);

				wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return element;
					}
				});
			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	// code to add firefox profile
	@SuppressWarnings("unused")
	protected void addFireFoxProfile() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("createdProfileName");
		WebDriver driver = new FirefoxDriver(myProfile);
	}

	// code to switch to new window
	protected void switchToWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	// select drop down value using select class
	protected void selectDropDownValueUsingSelectClass(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	// select drop down value using list of web element option value
	protected void selectDropDownValueUsingListOfWebElement(WebElement element, String text) {
		Select mySelect = new Select(element);
		List<WebElement> options = mySelect.getOptions();
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(text)) {
				option.click();
			}
		}
	}

	// select drop down value using action class
	protected void selectDropDownValueUsingActionClass(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

	protected void tearDown() {
		driver.quit();
	}
	
	protected void waiforPageToLoad() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageLoadStatus = (String) js.executeScript("return document.readyState");
		while (!pageLoadStatus.equals("complete")) {
			System.out.println("Page Loaded.");
		}
	}

	protected boolean isPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected void waitForInvisible(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
