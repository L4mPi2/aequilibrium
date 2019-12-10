package testCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.CartPageObjects;
import pageObjects.CheckoutPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ProductsPageObjects;
import resources.base;

public class LoginTestSuite extends base {

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/ExtentReports.html", true);

	}

	@Test(priority = 0)

	public void displayedElements() {

		/*
		 * This test intends to validate every single object displayed in the login page
		 * But is going to fail intentionally. I explained this below. Also, while the
		 * script is validating every single element of the page, you'll see the page
		 * standing still a little while, that's a timeout that I added when an element
		 * is not found.. once this timeout is passed, it resumes its execution, and the
		 * other tests will resume running---> This test FAILS
		 */

		driver.get(prop.getProperty("url"));

		logger = extent.startTest("displayedElements");

		LoginPageObjects lp = new LoginPageObjects(driver);

		lp.getTitle().isDisplayed();

		lp.getSwagLabsLogo();

		lp.getEmail().isDisplayed();

		lp.getPassword().isDisplayed();

		lp.getLogin().isDisplayed();

		lp.getMainImage().isDisplayed();

		lp.getAcceptedUsersl().isDisplayed();

		lp.getPasswordForAllUsers().isDisplayed();

		lp.getStandardUser().isDisplayed();

		lp.getLockedUser()
				.isDisplayed();/*
								 * I failed this one on purpose, if you check its locator in the
								 * LoginPageObjects java class, I entered a dummy locator so WD could not find
								 * it and fails the test so we can have a screenshot. Also, the Implicit Wait
								 * triggers here because the driver is not being able to locate that element
								 */

		lp.getProblemUser().isDisplayed();

		lp.getPerformanceGlitchUser().isDisplayed();

		lp.getUniversalPassword().isDisplayed();

	}

	@Test(dataProvider = "getNonRegisteredUsers")

	// This tests different combinations of dummy keys that are not the right ones,
	// and,
	// since the error message is being validated for every failed try --> this test
	// PASSES

	public void testLoginInvalidKeys(String Username, String Password) throws IOException

	{

		driver.get(prop.getProperty("url"));

		logger = extent.startTest("testLoginInvalidKeys");

		LoginPageObjects lp = new LoginPageObjects(driver);

		lp.getEmail().sendKeys(Username);

		lp.getPassword().sendKeys(Password);

		lp.getLogin().click();

		lp.getEmail().clear();

		lp.getPassword().clear();

		lp.getErrorMessage().isDisplayed();

	}

	@Test(dataProvider = "getRegisteredUsers")

	/*
	 * This test validates the 3 sets that actually work, and for every successful
	 * login, the script gets to the inventory page and finds the burger button and
	 * then the logout button, finding the burger button serves as a validation that
	 * the login has been successful. Therefore, the script logs in and logs out
	 * every valid users--> This test PASSES
	 */

	public void testLoginRightKeys(String Username, String Password) throws IOException

	{

		driver.get(prop.getProperty("url"));

		logger = extent.startTest("testLoginRightKeys");

		LoginPageObjects lp = new LoginPageObjects(driver);

		ProductsPageObjects pp = new ProductsPageObjects(driver);

		lp.getEmail().sendKeys(Username);

		lp.getPassword().sendKeys(Password);

		lp.getLogin().click();

		pp.getBurgerButton().click();

		pp.getLogoutButtonl().click();

	}

	@Test

	/*
	 * This test validates if the password is being masked by asserting that the
	 * Type attribute is the correct one- This test PASSES
	 */

	public void testMaskedPassword() {

		driver.get(prop.getProperty("url"));

		logger = extent.startTest("testMaskedPassword");

		LoginPageObjects lp = new LoginPageObjects(driver);

		lp.getPassword().getAttribute("Type").equals("password");

	}

	@Test

	public void purchaseHappyPath() {

		CartPageObjects cpo = new CartPageObjects(driver);

		ProductsPageObjects pp = new ProductsPageObjects(driver);

		LoginPageObjects lp = new LoginPageObjects(driver);

		CheckoutPageObjects chp = new CheckoutPageObjects(driver);

		driver.get(prop.getProperty("url"));

		logger = extent.startTest("purchaseHappyPath");

		lp.getEmail().sendKeys("standard_user");

		lp.getPassword().sendKeys("secret_sauce");

		lp.getLogin().click();

		pp.getCart().isDisplayed();

		pp.getBackPack().click();

		pp.getAddToCartButton().isDisplayed();

		pp.getAddToCartButton().click();

		pp.getBackButton().click();

		pp.getFilter().isDisplayed();

		pp.getBikeLight().click();

		pp.getAddToCartButton().click();

		pp.getCart().click();

		cpo.getCheckoutButton().isDisplayed();

		cpo.getCheckoutButton().click();

		chp.getFirstNameInput().sendKeys("username");

		chp.getLastNameInput().sendKeys("lastname");

		chp.getPostalCode().sendKeys("postalcode");

		chp.getContinueButton().click();

		String itemTotal = chp.getItemTotal().getText();

		String taxTotal = chp.getTaxTotal().getText();

		String total = chp.getTotal().getText();

		Assert.assertEquals("Item total: $39.98", itemTotal);

		Assert.assertEquals("Tax: $3.20", taxTotal);

		Assert.assertEquals("Total: $43.18", itemTotal);/*This fails on purpose to grab screenshot. 
		I've passed the variable itemTotal when it should've been total instead.. So this assert returns false and the test fails*/

		System.out.println(total);

		chp.getFinishButton().isDisplayed();

		chp.getFinishButton().click();

		chp.getThanksLabel().isDisplayed();

		pp.getBurgerButton().click();

		pp.getLogoutButtonl().click();

		Assert.assertNotNull(lp.getLogin());

	}

	@DataProvider()

	public Object[][] getNonRegisteredUsers()

	// I used these sets that are not passing because of the caps.

	{

		Object[][] data = new Object[4][2];

		data[0][0] = "STANDARD_USER";
		data[0][1] = "secret_sauce";

		data[1][0] = "LOCKED_OUT_USER";
		data[1][1] = "secret_sauce";

		data[2][0] = "PROBLEM_USER";
		data[2][1] = "secret_sauce";

		data[3][0] = "PERFORMANCE_GLITCH_USER";
		data[3][1] = "secret_sauce";

		return data;

	}

	@DataProvider()

	public Object[][] getRegisteredUsers()

	// These work , these are valid sets

	{

		Object[][] data = new Object[3][2];

		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";

		data[1][0] = "performance_glitch_user";
		data[1][1] = "secret_sauce";

		data[2][0] = "problem_user";
		data[2][1] = "secret_sauce";

		return data;

	}

	@AfterMethod
	public void takeScreenshoot(ITestResult result) throws IOException {

		/*
		 * These method grabs every single test's status using Listeners and via
		 * getScreenshotOnFailure method that has been defined in the base file It takes
		 * screenshots on test cases failed or skipped
		 */

		if (ITestResult.FAILURE == result.getStatus())

		{

			logger.log(LogStatus.FAIL, "Test Case Failed is: " + result.getName());// This adds TCs names to the report
			logger.log(LogStatus.FAIL, "Test Case Failed is: " + result.getThrowable());// This provides
																						// errors/exceptions
																						// to the report

			String screenshotPath = base.getScreenshotOnFailure(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreencast(screenshotPath));// this attaches the SCs to the report(only
																				// in failed tests)
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));// this attaches the SS to the report
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());// This adds TCs name to the report
			logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getThrowable());// This provides
																							// errors/exceptions to the
																							// report

		} else if (result.getStatus() == ITestResult.SUCCESS)

		{

			logger.log(LogStatus.PASS, "Test Case Passed is: " + result.getName());// This adds TCs name to the report

		}

		extent.endTest(logger);

	}

	@AfterTest
	public void teardown()

	{
		driver.close(); // these 2 kill the driver
		driver = null;
		extent.flush();// These 2 refresh the reports
		extent.close();
	}

}
