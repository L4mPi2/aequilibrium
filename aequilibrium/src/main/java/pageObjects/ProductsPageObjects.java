package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPageObjects {

	public WebDriver driver;

	By productsLabel = By.xpath("//div[@class='product_label']");

	By burgerButton = By.xpath("//button[contains(text(),'Open Menu')]");

	By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");
	
	By backPack = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
	
	By bikeLight = By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]");
	
	By addToCartButton = By.xpath("//button[@class='btn_primary btn_inventory']");
	
	By backButton = By.xpath("//button[@class='inventory_details_back_button']");
	
	By cart = By.id("shopping_cart_container");
	
	By filter = By.className("product_sort_container");
	
	By highToLow = By.xpath("//option[contains(text(),'Price (high to low)')]");
	
	

	public ProductsPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getProductsLabel() {

		return driver.findElement(productsLabel);

	}

	public WebElement getBurgerButton() {

		return driver.findElement(burgerButton);

	}

	public WebElement getBackPack() {

		return driver.findElement(backPack);

	}
	
	public WebElement getBikeLight() {

		return driver.findElement(bikeLight);

	}
	
	public WebElement getAddToCartButton() {

		return driver.findElement(addToCartButton);

	}
	
	public WebElement getBackButton() {

		return driver.findElement(backButton);

	}
	
	public WebElement getCart() {

		return driver.findElement(cart);

	}
	
	public WebElement getFilter() {

		return driver.findElement(filter);

	}
	
	public WebElement getLogoutButtonl() {

		return driver.findElement(logoutButton);

	}
	
	public WebElement getHighToLowl() {

		return driver.findElement(highToLow);

	}
}
