package com.eleks.Demo1.core.web;

import org.openqa.selenium.WebDriver;

public abstract class Components<T extends Components<T>> {
	
	protected WebDriver driver;
	
	public Components(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract boolean isAwailable();
	
	public T waitUntilAwailable() {
		return new WaitingClass<T>().forComponent((T)this).toBeAwailable();
	}

}
