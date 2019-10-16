package com.org.konakart.testscripts;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.konakart.helpers.SortingHelper;
import com.org.konakart.helpers.ValidateDate;
import com.org.konakart.helpers.ValidationOfHeroImageContents;
import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ValidateTestResult;

public class HeroImagePage extends InvokeBrowser {
	ValidateDate validatedate = new ValidateDate();
	SortingHelper sort = new SortingHelper();

	// click on the hero image (used as Westclox 32042r Retro 1950 Kitchen Wall
	// Clock 9.5-inch Red)
	@Test(priority = 2)
	public void clickOnHeroImage() {
		css = read.readPropertiesFile("loc.heroimage.css");
		PageActions.clickOnElement(driver, css);
	}

	@Test(priority = 3)
	public void validatetabsOfHeroImage() {
		if ("loc.title.css" != null) {
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
		} else

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

	@Test(priority = 4)
	public void sortByAscending() {
		PageActions.scrollDown(driver);
		validatedate.validateReviewDate();
		log.info("Date matches");
		List<WebElement> list = driver.findElements(By.cssSelector("span[class*='product-review-details-date']"));
		String[] dataarray = sort.sortDate(list);
		System.out.println(Arrays.toString(dataarray));
		int[] dateArray = Arrays.stream(dataarray).mapToInt(Integer::parseInt).toArray();
		boolean asc = sort.isSortedAscending(dateArray);
		Assert.assertTrue(asc, "No Ascending");
		log.info("Ascending Order");

	}
	public void sortByDescending() {
		List<WebElement> list = driver.findElements(By.cssSelector("span[class*='product-review-details-date']"));
		String[] dataarray = sort.sortDate(list);
		System.out.println(Arrays.toString(dataarray));
		int[] dateArray = Arrays.stream(dataarray).mapToInt(Integer::parseInt).toArray();
		boolean asc = sort.isSortedAscending(dateArray);
		Assert.assertTrue(asc, "No Ascending");
		log.info("Ascending Order");
		
	}

}
