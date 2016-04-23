package com.eleks.Demo1.core.web;

import org.openqa.selenium.WebDriver;

public abstract class Components<T extends Components<T>> {
	
	protected WebDriver driver;
	
	public Components(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract boolean isAvailable();
	
	public T waitUntilAvailable() {
		return new WaitingClass<T>().forComponent((T)this).toBeAvailable();
	}

}
