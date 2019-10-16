package com.org.konakart.helpers;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.org.konakart.reports.LogReports;
import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ReadPropertiesFile;
import com.org.konakrt.utils.ValidateTestResult;


public class ValidationOfHeroImageContents extends InvokeBrowser {
	public static WebDriver driver;
	Properties config = new Properties();
	protected ReadPropertiesFile read = new ReadPropertiesFile();
	protected String Xpath;
	protected ValidateTestResult validate = new ValidateTestResult();
	public LogReports log = new LogReports();
	@Test
	public void clickOnHeroImage() {
		css = read.readPropertiesFile("loc.heroimage.css");
		PageActions.clickOnElement(driver, css);
	}
	@Test
	public void validateContentKindle() {

		css = read.readPropertiesFile("loc.kindleproduct.css");
		String kindleproduct = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(kindleproduct, "coffeeproduct", "No match");

		css = read.readPropertiesFile("loc.kindlespec.css");
		PageActions.clickOnElement(driver, css);
		String kindlespec = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(kindlespec, "coffeespec", "No match");

		css = read.readPropertiesFile("loc.kindleereview.css");
		PageActions.clickOnElement(driver, css);
		String kindleReview = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(kindleReview, "coffeeReview", "No match");
	}
	@Test
	public void validateContentCoffeMaker() {
		css = read.readPropertiesFile("loc.coffeeproduct.css");
		PageActions.clickOnElement(driver, css);
		String coffeeproduct = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(coffeeproduct, "coffeeproduct", "No match");

		css = read.readPropertiesFile("loc.coffeespec.css");
		PageActions.clickOnElement(driver, css);
		String coffeespec = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(coffeespec, "coffeespec", "No match");

		css = read.readPropertiesFile("loc.coffeereview.css");
		PageActions.clickOnElement(driver, css);
		String coffeeReview = driver.findElement(By.cssSelector(css)).getText();
		ValidateTestResult.validateData(coffeeReview, "coffeeReview", "No match");
	}
}
