package com.eleks.Demo1.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
	
	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";
	private static final String IE = "ie";
	
	private static WebDriver driver;

	public static WebDriver getDriver(String browsername) throws Exception{
		if (driver == null){
			if (FIREFOX.equals(browsername)) {
				driver = new FirefoxDriver();
			} else if (IE.equals(browsername)) {
				setIEDriver();
			} else if (CHROME.equals(browsername)) {
				setChromeDriver();
			} else {
				throw new Error("Unsupported browser: " + browsername);
			}
		}
		
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	private static void setIEDriver() {
		System.setProperty("webdriver.ie.driver", "D:\\Tools\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	private static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
	}


}
