package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPageObjects {

	public WebDriver driver;

	By firstNameInput = By.xpath("//input[@id='first-name']");

	By lastNameInput = By.xpath("//input[@id='last-name']");

	By postalCode = By.xpath("//input[@id='postal-code']");

	By cancelButton = By.xpath("//a[@class='cart_cancel_link btn_secondary']");

	By continueButton = By.xpath("//input[@class='btn_primary cart_button']");

	By itemTotal = By.xpath("//div[@class='summary_subtotal_label']");

	By taxTotal = By.xpath("//div[@class='summary_tax_label']");

	By total = By.xpath("//div[@class='summary_total_label']");

	By finishButton = By.xpath("//a[@class='btn_action cart_button']");

	By shippingInfo = By.xpath("//div[contains(text(),'FREE PONY EXPRESS DELIVERY!')]");

	By thanksLabel = By.xpath("//h2[@class='complete-header']");

	public CheckoutPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getFirstNameInput() {

		return driver.findElement(firstNameInput);

	}

	public WebElement getLastNameInput() {

		return driver.findElement(lastNameInput);

	}

	public WebElement getPostalCode() {

		return driver.findElement(postalCode);

	}

	public WebElement getCancelButton() {

		return driver.findElement(cancelButton);

	}

	public WebElement getContinueButton() {

		return driver.findElement(continueButton);

	}

	public WebElement getItemTotal() {

		return driver.findElement(itemTotal);

	}

	public WebElement getTaxTotal() {

		return driver.findElement(taxTotal);

	}

	public WebElement getTotal() {

		return driver.findElement(total);

	}

	public WebElement getThanksLabel() {

		return driver.findElement(thanksLabel);

	}

	public WebElement getFinishButton() {

		return driver.findElement(finishButton);

	}

	public WebElement getShippingInfo() {

		return driver.findElement(shippingInfo);

	}
}
