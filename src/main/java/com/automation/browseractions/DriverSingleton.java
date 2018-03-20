package com.automation.browseractions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private WebDriver driver;
	private static DriverSingleton driverinstance;

	private DriverSingleton() {
	}

	public static DriverSingleton getDriverinstance() {
		if (DriverSingleton.driverinstance == null) {
			DriverSingleton.driverinstance = new DriverSingleton();
		}
		return DriverSingleton.driverinstance;

	}

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

}
