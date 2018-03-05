package com.automation.amazonpractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Mainflow {

	String browser = "chrome";
	String url = "https://www.amazon.in";
	String signxpath = "//span[@class='nav-line-1' and contains(text(),'Sign')]";
	String loginidpath = "//input[@id='ap_email']";
	String loginid = "8147524882";
	String continuebtnpath = "//input[@id='continue']";
	String passwdpath = "//input[@id='ap_password']";
	String passwdtxt = "Amazon123";
	String loginbtnpath = "//input[@id='signInSubmit']";
	String loggedinpath = "//span[@class='nav-line-1' and contains(text(),'Saritha')]";

	WebDriver driver;

	@Test
	public void openurl() throws IOException {
		BrowserInteraction browserClassInstance = new BrowserInteraction();
		browserClassInstance.setDriver(this.browser);
		this.driver = browserClassInstance.getDriver();
		this.driver.get(this.url);
		String title = this.driver.getTitle();
		Assert.assertTrue(title.contains("Amazon"));

	}

	@Test(dependsOnMethods = "openurl")
	public void login() throws InterruptedException {
		this.driver.findElement(By.xpath(this.signxpath)).click();
		this.driver.findElement(By.xpath(this.loginidpath)).sendKeys(this.loginid);
		this.driver.findElement(By.xpath(this.continuebtnpath)).click();
		this.driver.findElement(By.xpath(this.passwdpath)).sendKeys(this.passwdtxt);
		this.driver.findElement(By.xpath(this.loginbtnpath)).click();
		Assert.assertEquals(this.driver.findElement(By.xpath(this.loggedinpath)).isDisplayed(), true);
	}

}
