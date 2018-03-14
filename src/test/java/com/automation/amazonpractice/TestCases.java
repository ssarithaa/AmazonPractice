package com.automation.amazonpractice;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.browseractions.BrowserInteraction;
import com.automation.pageObject.HomePageObject;
import com.automation.pageObject.LoginPageObject;
import com.automation.pageObject.SearchPageObjects;

public class TestCases {

	String browser = "chrome";
	String url = "https://www.amazon.in";

	WebDriver driver;
	BrowserInteraction browserObj;
	LoginPageObject loginobj;
	HomePageObject homeobj;
	SearchPageObjects searchobj;

	@BeforeClass
	public void getData() throws IOException {
		// FileInputStream fin = new FileInputStream(
		// "C:\\Users\\saritha.pattathil\\eclipse-workspace\\amazonpractice\\InputDataFile.xlsx");
		// XSSFWorkbook wb = new XSSFWorkbook(fin);
		// XSSFSheet sheet = wb.getSheet("DDTest");
		// XSSFRow row = sheet.getRow(0);
		// XSSFCell cell = row.getCell(1);
		// this.browser = cell.getStringCellValue();

		this.browserObj = new BrowserInteraction();
		this.browserObj.setDriver(this.browser);
		this.driver = this.browserObj.getDriver();
		this.loginobj = new LoginPageObject(this.driver);
		this.homeobj = new HomePageObject(this.driver);
		this.searchobj = new SearchPageObjects(this.driver);

	}

	@Test
	public void openUrl() throws IOException {

		this.driver.get(this.url);
		String title = this.driver.getTitle();
		Assert.assertTrue(title.contains("Amazon"));

	}

	@Test(dependsOnMethods = "openUrl")
	public void login() {

		this.homeobj.linkTosignin().click();
		this.loginobj.loginIDTxt().sendKeys(this.loginobj.getLoginid());
		this.loginobj.continueBtn().click();
		this.loginobj.passwordTxt().sendKeys(this.loginobj.getPasswrd());
		this.loginobj.loginBtn().click();

		Assert.assertEquals(this.homeobj.loggedInName().isDisplayed(), true);
	}

	@Test(dependsOnMethods = "login")
	public void searchItem() throws InterruptedException, IOException {
		this.homeobj.searchTxtBox().sendKeys(this.homeobj.getSearchTxt());

		Thread.sleep(3000);
		this.homeobj.searchTxtBox().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		String clickeditemname = this.browserObj.openinnewtab(this.searchobj.itemToSelectPath());
		this.browserObj.switchtabs();
		String selecteditem = this.searchobj.selectedProductnamePath().getText();
		Assert.assertTrue(selecteditem.contains(clickeditemname));

	}

	@Test(dependsOnMethods = "searchItem")
	public void addToCart() throws IOException {
		this.searchobj.addtocartBtnXpath().click();
		this.browserObj.switchtabs();
		Assert.assertEquals((this.browserObj.isTextPresent(this.searchobj.cartConfrmXpath())), true);

	}

}
