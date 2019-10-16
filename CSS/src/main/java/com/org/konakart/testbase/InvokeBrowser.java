package com.org.konakart.testbase;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.org.konakart.constants.*;
import com.org.konakart.reports.LogReports;
import com.org.konakrt.utils.ReadPropertiesFile;
import com.org.konakrt.utils.ValidateTestResult;

@Test
public class InvokeBrowser {
	public static LogReports log = new LogReports();
	public static WebDriver driver;
	Properties config = new Properties();
	protected static ReadPropertiesFile read = new ReadPropertiesFile();
	protected static String css;

	protected ValidateTestResult validate = new ValidateTestResult();

//To invoke the chrome browser by  URL

	public void setup() throws IOException {

		/*
		 * System.setProperty("webdriver.firefox.marionette",
		 * ConstantPaths.FIREFOX_FILE); WebDriver driver = new FirefoxDriver();
		 */

		System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
		driver = new ChromeDriver();

		/*
		 * DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
		 * ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
		 * "http://www.bing.com/"); driver = new InternetExplorerDriver(ieCaps);
		 */

		log.info("Chrome browser invoked...");

		driver.get(read.readPropertiesFile("url"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Application opened...");
		driver.manage().window().maximize();
	}

	/*
	 * @Test(priority = 2)
	 * 
	 * 
	 * public void ImageComaparision() throws IOException {
	 * 
	 * WebElement logoImage = driver.findElement(By.cssSelector("image"));
	 * 
	 * BufferedImage expectedImage = ImageIO.read(new
	 * File(System.getProperty("user.dir") +"\\Images\\blog.png")); Screenshot
	 * logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
	 * BufferedImage actualImage = logoImageScreenshot.getImage();
	 * 
	 * ImageDiffer imgDiff = new ImageDiffer(); ImageDiff diff =
	 * imgDiff.makeDiff(actualImage, expectedImage);
	 * Assert.assertFalse(diff.hasDiff(),"Images are Same");
	 * 
	 * driver.quit(); }
	 */

	/*
	 * // Initialize the Runner for your test. EyesRunner runner = new
	 * ClassicRunner();
	 * 
	 * // Initialize the eyes SDK Eyes eyes = new Eyes(runner);
	 * 
	 * // Change the APPLITOOLS_API_KEY API key with yours
	 * eyes.setApiKey("APPLITOOLS_API_KEY");
	 * 
	 * // Set AUT's name, test name and viewport size (width X height)
	 * eyes.open(driver, "Atmecs", "Test", new RectangleSize(1500, 600));
	 * 
	 * // Navigate the browser to the "ATMECS" driver.get("http://www.atmecs.com/");
	 * // This line takes the screenshot eyes.checkWindow("Home Page"); // End the
	 * test. eyes.closeAsync();
	 * 
	 * // Close the browser. driver.quit();
	 */

	// If the test was aborted before eyes.close was called, ends the test as
	// aborted.
	// eyes.abortIfNotClosed();
	// Wait and collect all test results
	// TestResultsSummary allTestResults = runner.getAllTestResults();

	// Print results
	// System.out.println(allTestResults);

}
