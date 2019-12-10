package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	public WebDriver driver;
	
	By title = By.xpath("//title[contains(text(),'Swag Labs')]");

	By swagLabsLogo = By.xpath("//div[@class='login_logo']");

	By email = By.xpath("//input[@id='user-name']");

	By password = By.xpath("//input[@id='password']");

	By loginButton = By.xpath("//input[@class='btn_action']");

	By robotImage = By.xpath("//div[@class='bot_column']");
	
	By errorMessage = By.xpath("//h3[1]");
	
	By acceptedUsers = By.xpath("//h4[contains(text(),'Accepted usernames are:')]");
	
	By standardUser = By.xpath("//*[contains(@h4, 'standard_user')]");
	
	By lockedUser = By.xpath("//*[contains(@h4, 'locked_out_user')]");
	
	By problemUser = By.xpath("//*[contains(@h4, 'problem_user')]");
	
	By performanceGlitchUser = By.xpath("//*[contains(@h4, 'performance_glitch_user')]");
	
	By passwordForAllUsers = By.xpath("//*[contains(@h4, ' Failed On purpose')]");//Wrong locator on purpose ((grabbing Screenshot))
	
	By universalPassword = By.xpath("//*[contains(@h4, 'Failed On purpose')]");//Wrong locator on purpose (grabbing Screenshot)
	

	
	
	public LoginPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getEmail() {

		return driver.findElement(email);

	}

	public WebElement getPassword() {

		return driver.findElement(password);

	}

	public WebElement getLogin() {

		return driver.findElement(loginButton);

	}

	public WebElement getMainImage() {

		return driver.findElement(robotImage);

	}

	public WebElement getSwagLabsLogo() {

		return driver.findElement(swagLabsLogo);

	}
	
	public WebElement getTitle() {

		return driver.findElement(title);

	}

	public WebElement getErrorMessage() {

		return driver.findElement(errorMessage);

	}
	
	public WebElement getAcceptedUsersl() {

		return driver.findElement(acceptedUsers);

	}
	
	public WebElement getStandardUser() {

		return driver.findElement(standardUser);

	}
	
	public WebElement getLockedUser() {

		return driver.findElement(lockedUser);

	}
	
	public WebElement getProblemUser() {

		return driver.findElement(problemUser);

	}
	
	public WebElement getPerformanceGlitchUser() {

		return driver.findElement(performanceGlitchUser);

	}
	
	public WebElement getPasswordForAllUsers() {

		return driver.findElement(passwordForAllUsers);

	}
	
	public WebElement getUniversalPassword() {

		return driver.findElement(universalPassword);

	}
}
