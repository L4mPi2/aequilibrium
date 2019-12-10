package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPageObjects {

	public WebDriver driver;

	By continueShoppingButton = By.xpath("//a[@class='btn_secondary']");

	By checkoutButton = By.xpath("//a[@class='btn_action checkout_button']");

	By backPackPrice = By.xpath("//div[contains(text(),'29.99')]");

	By bikeLightPrice = By.xpath("//div[contains(text(),'9.99')]");

	By subHeader = By.xpath("//div[@class='subheader']");

	public CartPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getContinueShoppingButton() {

		return driver.findElement(continueShoppingButton);

	}

	public WebElement getCheckoutButton() {

		return driver.findElement(checkoutButton);

	}

	public WebElement getBackPackPrice() {

		return driver.findElement(backPackPrice);

	}

}
