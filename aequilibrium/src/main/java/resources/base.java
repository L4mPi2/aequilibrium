package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static WebDriver driver;
	public Properties prop;

	public ExtentReports extent;  // These steps handle the reports functionality.
	public ExtentTest logger;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();/* I used user.dir property so you don't have to hardcode this path. */
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser"); // this is how we connect properties to the base file

		if (browserName.equals("chrome"))

		{
			WebDriverManager.chromedriver().setup();/*
													 * Chrome driver and Firefoxdriver are gonna be loaded dynamically
													 * so you don't have to download and install them
													 */
			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox"))

		{

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver; // This is gonna determine the waiting time until an element gets found

	}

	public static String getScreenshotOnFailure(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhss").format(new java.util.Date());// I added the date format
																							// so the SS don't overwrite
																							// themselves
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);// after execution you'll see a "FailedTestsScreenshots" under
															// src folder

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";// This creates fills the FailedTestsScreenshots folder with Failed Tests' SSs.
							// I used user.dir so you don't have to hardcode the path
		File finaDestination = new File(destination);
		FileUtils.copyFile(source, finaDestination);
		return destination;

	}

}
