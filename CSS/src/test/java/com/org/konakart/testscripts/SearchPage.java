package com.org.konakart.testscripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.konakart.testbase.InvokeBrowser;
import com.org.konakrt.utils.PageActions;
import com.org.konakrt.utils.ReadExcelData;

public class SearchPage extends InvokeBrowser {
	// Click on dropdown
	@Test(priority = 1)
	public void clickOnDropDown() {
		css = read.readPropertiesFile("loc.dropdown.class.css");
		PageActions.clickOnElement(driver, css);
	}

	// select a product from dropdown(Games-call of duty)
	// Providing the data through data provider(

	@Test(priority = 2, dataProvider = "data", dataProviderClass = ReadExcelData.class)
	public void enterData(String[] in) {
		// select value from dropdown
		css = read.readPropertiesFile("loc.dropdown.class.css");
		driver.findElement(By.cssSelector(css)).sendKeys(in[0]);
		log.info("Selected the data");

		// Click on search
		css = read.readPropertiesFile("loc.serachfield.css");
		driver.findElement(By.cssSelector(css)).sendKeys(in[1]);
		PageActions.clickOnElement(driver, css);
		log.info("selected Call of duty");

		// click search button
		css = read.readPropertiesFile("loc.searchbutton.css");
		PageActions.clickOnElement(driver, css);
		log.info("Searching...");

		css = read.readPropertiesFile("loc.msg.css");
		List<WebElement> list = driver.findElements(By.cssSelector(css));

		if (list.size() > 0) {		
			String msg = list.get(0).getText();
			Assert.assertEquals(msg, in[2]);
			System.out.println(msg);

		} else {
			css = read.readPropertiesFile("loc.name.css");
			String msg = driver.findElement(By.cssSelector(css)).getText();
			Assert.assertEquals(msg, in[2]);
			System.out.println(msg);

		}

	}
}
