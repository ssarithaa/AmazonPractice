package com.automation.amazonpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mainflow {

	String browser;
	String url = "https://www.amazon.in";
	String signxpath = "//span[@class='nav-line-1' and contains(text(),'Sign')]";
	String loginidpath = "//input[@id='ap_email']";
	String loginid = "8147524882";
	String continuebtnpath = "//input[@id='continue']";
	String passwdpath = "//input[@id='ap_password']";
	String passwdtxt = "Amazon123";
	String loginbtnpath = "//input[@id='signInSubmit']";
	String loggedinpath = "//span[@class='nav-line-1' and contains(text(),'Saritha')]";
	String searchtxtpath = "//input[@id='twotabsearchtextbox']";
	String searchtxt = "Mobile";
	String itemtoselectPath = "//div[@id='resultsCol']//ul//li[2]//h2";
	String selectedproductnamepath = "//div[@id='centerCol']//span[@id='productTitle']";
	// String drophangerpath =
	// "(//div[@class='nav-fill'])[2]//(input[@type='hidden'])";

	WebDriver driver;
	BrowserInteraction browserClassInstance = new BrowserInteraction();
	String cellvalue;

	@BeforeClass
	public void getdata() throws IOException {
		FileInputStream fin = new FileInputStream(
				"C:\\Users\\saritha.pattathil\\eclipse-workspace\\amazonpractice\\InputDataFile.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sheet = wb.getSheet("DDTest");

		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(1);
		this.browser = cell.getStringCellValue();

	}

	@Test
	public void openurl() throws IOException {

		this.browserClassInstance.setDriver(this.browser);
		this.driver = this.browserClassInstance.getDriver();
		this.driver.get(this.url);
		String title = this.driver.getTitle();
		Assert.assertTrue(title.contains("Amazon"));

	}

	@Test(dependsOnMethods = "openurl")
	public void login() {

		this.browserClassInstance.click(this.signxpath);
		this.browserClassInstance.enterText(this.loginidpath, this.loginid);
		this.browserClassInstance.click(this.continuebtnpath);
		this.browserClassInstance.enterText(this.passwdpath, this.passwdtxt);
		this.browserClassInstance.click(this.loginbtnpath);
		Assert.assertEquals(this.driver.findElement(By.xpath(this.loggedinpath)).isDisplayed(), true);
	}

	@Test(dependsOnMethods = "login")
	public void searchItem() throws InterruptedException {
		this.browserClassInstance.click(this.searchtxtpath);
		this.browserClassInstance.enterText(this.searchtxtpath, this.searchtxt);
		Thread.sleep(3000);
		this.browserClassInstance.moveCursorDown(this.searchtxtpath);
		String clickeditemname = this.browserClassInstance.click(this.itemtoselectPath);
		System.out.println(clickeditemname);
		String selecteditem = this.browserClassInstance.click(this.selectedproductnamepath);
		System.out.println(selecteditem);
		Assert.assertTrue(selecteditem.contains(clickeditemname));
	}

}
