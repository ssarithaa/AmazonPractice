package com.automation.amazonpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInteraction {
	private WebDriver driver;

	void setDriver(String browser) throws IOException {
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(
				"C:\\Users\\saritha.pattathil\\eclipse-workspace\\amazonpractice\\src\\test\\java\\com\\automation\\amazonpractice\\datafile.properties");
		prop.load(fin);
		switch (browser.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriverpath"));
			this.driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
			this.driver = new ChromeDriver();
			break;
		default:
			System.out.println("Unsupported browser");

		}

	}

	WebDriver getDriver() throws IOException {
		if (this.driver == null) {
			this.setDriver(null);
		}

		return this.driver;

	}

	void click(String elementXpath) {
		this.driver.findElement(By.xpath(elementXpath)).click();

	}

	void enterText(String elemantXpath, String ValueToEnter) {
		this.driver.findElement(By.xpath(elemantXpath)).sendKeys(ValueToEnter);
	}

}
