package com.eleks.Demo1.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WebComponent<T extends WebComponent<T>> extends Components<T> {

	protected final By findByMethod;
	
	public WebComponent(WebDriver driver, By findByMethod) {
		super(driver);
		this.findByMethod = findByMethod;
	}
	
	protected WebElement getWebElement() {
		return driver.findElement(findByMethod);
	}

}
