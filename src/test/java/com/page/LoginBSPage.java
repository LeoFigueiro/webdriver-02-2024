package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginBSPage {
	
	public LoginBSPage open() {		
		getDriver().get("http://sahitest.com/demo/training/login.htm");
		return this;		
	}
	
	public LoginBSPage inputUser(String user) {
		WebElement tfUser = getDriver().findElement(By.name("user"));
		tfUser.sendKeys(user);
		return this;
	}
	
	public LoginBSPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.name("password"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public IndexBSPage clickLogin() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();
		
		return new IndexBSPage();
		
	}

}
