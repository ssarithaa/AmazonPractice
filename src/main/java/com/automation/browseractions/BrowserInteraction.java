package com.automation.browseractions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserInteraction {
	DriverSingleton driverinstance = DriverSingleton.getDriverinstance();

	public String openinnewtab(WebElement elementPath) throws IOException {

		String clickeditemname = elementPath.getText();
		Actions a = new Actions(this.driverinstance.getDriver());
		a.keyDown(Keys.CONTROL).click(elementPath).build().perform();
		return clickeditemname;
	}

	public void switchtabs() throws IOException {
		String parenthandle = this.driverinstance.getDriver().getWindowHandle();
		Set<String> handles = this.driverinstance.getDriver().getWindowHandles();
		for (String handle : handles) {
			if (!(parenthandle.equalsIgnoreCase(handle))) {
				this.driverinstance.getDriver().switchTo().window(handle);
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

	public void takeScreenshot(String testname) throws IOException {

		File srcfile = ((TakesScreenshot) this.driverinstance.getDriver()).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srcfile, new File("C:/Users/saritha.pattathil/TestScreenshots/" + testname + ".png"));

	}

}
