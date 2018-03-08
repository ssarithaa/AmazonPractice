package com.automation.amazonpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
			this.driver = new ChromeDriver();
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

	String click(String elementXpath) {
		WebElement we = this.driver.findElement(By.xpath(elementXpath));
		String clickeditemname = we.getText();
		we.click();

		return clickeditemname;

	}

	void enterText(String elemantXpath, String ValueToEnter) {
		this.driver.findElement(By.xpath(elemantXpath)).sendKeys(ValueToEnter);
	}

	void moveCursorDown(String elementXpath) {

		WebElement we = this.driver.findElement(By.xpath(elementXpath));
		we.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

	}

}
