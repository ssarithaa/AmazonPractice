package com.automation.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObjects {

	@FindBy(xpath = "//div[@id='resultsCol']//ul//li[3]//h2")
	private WebElement itemToSelectPath;

	@FindBy(xpath = "//div[@id='centerCol']//span[@id='productTitle']")
	private WebElement selectedProductnamePath;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement addtocartBtnXpath;

	@FindBy(xpath = "//h1[contains(text(),'Added to Cart')]")
	private List<WebElement> cartConfrmXpath;

	public SearchPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement itemToSelectPath() {
		return this.itemToSelectPath;
	}

	public WebElement selectedProductnamePath() {
		return this.selectedProductnamePath;
	}

	public WebElement addtocartBtnXpath() {
		return this.addtocartBtnXpath;
	}

	public List<WebElement> cartConfrmXpath() {
		return this.cartConfrmXpath;
	}

}
