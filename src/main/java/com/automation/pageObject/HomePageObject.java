package com.automation.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

	private String searchTxt = "Mobile";
	@FindBy(xpath = "//span[@class='nav-line-1' and contains(text(),'Sign')]")
	private WebElement signinLink;

	@FindBy(xpath = "//span[@class='nav-line-1' and contains(text(),'Saritha')]")
	private WebElement loggedInPath;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTxtPath;

	public HomePageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public String getSearchTxt() {
		return this.searchTxt;

	}

	public WebElement linkTosignin() {

		return this.signinLink;
	}

	public WebElement loggedInName() {
		return this.loggedInPath;
	}

	public WebElement searchTxtBox() {
		return this.searchTxtPath;
	}
}
