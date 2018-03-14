package com.automation.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	private String loginId = "8147524882";

	private String passwdTxt = "Amazon123";

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement loginIdpath;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueBtnPath;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement passwdPath;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement loginBtnPath;

	public LoginPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public String getLoginid() {
		return this.loginId;
	}

	public String getPasswrd() {
		return this.passwdTxt;
	}

	public WebElement loginIDTxt() {
		return this.loginIdpath;
	}

	public WebElement continueBtn() {
		return this.continueBtnPath;
	}

	public WebElement passwordTxt() {
		return this.passwdPath;
	}

	public WebElement loginBtn() {
		return this.loginBtnPath;
	}

}
