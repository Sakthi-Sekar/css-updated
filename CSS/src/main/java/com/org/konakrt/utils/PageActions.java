package com.org.konakrt.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageActions {
	protected static WebDriver driver;
	Actions builder = new Actions(driver);
	String locatorType;
	String css;

	public static void clickOnElement(WebDriver driver, String css) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(2, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				driver.findElement(By.cssSelector(css)).click();
				return true;
			}
		});

	}

	public static void dropDownHandle(WebDriver driver, final String id) {

		Select oSelect = new Select(driver.findElement(By.id(id)));

		// Get the size of the Select element
		List<WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();
		System.out.println(elementCount.size());

		// Setting up the loop to print all the options
		for (int i = 0; i < iSize; i++) {
			// Storing the value of the option
			String sValue = elementCount.get(i).getText();

			// Printing the stored value
			System.out.println(sValue);
		}
	}

	public static void elementEnabled(WebDriver driver, final String id) {
		boolean Field = driver.findElement(By.id(id)).isEnabled();
		System.out.print(Field);
	}

	public static void validateSearch(WebDriver driver, final String id) {
		driver.findElement(By.linkText(id)).click();
	}

	public void locators(WebDriver driver, String locatorType) {

		switch (locatorType) {
		case "CLASSNAME":

			driver.findElement(By.className("locatorValue")).click();
			break;
		case "CSSSELECTOR":

			driver.findElement(By.cssSelector("locatorValue")).click();
			break;
		case "ID":

			driver.findElement(By.id("locatorValue")).click();
			break;
		case "LINKTEXT":
			driver.findElement(By.linkText("locatorValue")).click();
			break;
		case "NAME":

			driver.findElement(By.name("locatorValue")).click();
			break;
		case "PARTIALLINKTEXT":

			driver.findElement(By.partialLinkText("locatorValue")).click();
			break;
		case "TAGNAME":

			driver.findElement(By.tagName("locatorValue")).click();
			break;
		case "XPATH":

			driver.findElement(By.xpath("locatorValue")).click();
		}
	}

	public void dropDownHandle() {
		WebElement element = driver.findElement(By.cssSelector("CSS"));
		Select oSelect = new Select(driver.findElement(By.cssSelector("CSS")));
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

}
