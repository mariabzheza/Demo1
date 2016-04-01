package com.eleks.Demo1.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.eleks.Demo1.core.TestBasement;

public class LoginTest2 extends TestBasement {
	
	@Test(alwaysRun = false)
	
	public void LoginTest() {
		driver.get(baseUrl);
		//driver.get("https://www.yahoo.com");
		driver.findElement(By.xpath("//div[@id='mega-uh']//div[text()='Sign in']")).click();
		driver.findElement(By.id("login-username")).click();
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys("bzheza.test1");
		
		//driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.xpath("//div[@id='inputs']//input[@id='login-passwd']")).click();
		
		//driver.findElement(By.id("login-passwd")).clear();
		driver.findElement(By.xpath("//div[@id='inputs']//input[@id='login-passwd']")).clear();
		
		//driver.findElement(By.id("login-passwd")).sendKeys("testtestTEST");
		driver.findElement(By.xpath("//div[@id='inputs']//input[@id='login-passwd']")).sendKeys("testtestTEST");
		
		//driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.xpath("//div[@id='submits']//div[text()='Sign in']")).click();
	}

}
