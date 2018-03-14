package com.automation.browseractions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserInteraction {
	private WebDriver driver;

	public void setDriver(String browser) throws IOException {
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

	public WebDriver getDriver() throws IOException {
		if (this.driver == null) {
			this.setDriver(null);
		}

		return this.driver;

	}

	public String openinnewtab(WebElement elementPath) {

		String clickeditemname = elementPath.getText();
		Actions a = new Actions(this.driver);
		a.keyDown(Keys.CONTROL).click(elementPath).build().perform();
		return clickeditemname;
	}

	public void switchtabs() {
		String parenthandle = this.driver.getWindowHandle();
		Set<String> handles = this.driver.getWindowHandles();
		for (String handle : handles) {
			if (!(parenthandle.equalsIgnoreCase(handle))) {
				this.driver.switchTo().window(handle);
			}

		}

	}

	public boolean isTextPresent(List<WebElement> elementXpath) {

		System.out.println(elementXpath.size());
		if (elementXpath.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

}
