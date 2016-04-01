package com.eleks.Demo1.core.web;

import org.openqa.selenium.WebDriver;

public abstract class WebPage<T extends WebPage<T>> extends Components<T> {
	
	public WebPage(WebDriver driver) {
		super(driver);
	}
	
	public abstract T load();
	
	public T loadAndWaitUntilAwailable(){
		load();
		return waitUntilAwailable();
	}
	
}
