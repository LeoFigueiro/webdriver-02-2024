package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginBSPage {
	
	public LoginBSPage open(String url) {		
		getDriver().get(url);
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
	
	public IndexBSPage clickLoginValido() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();
		
		return new IndexBSPage();
		
	}
	
	public LoginBSPage clickLoginInvalido() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();
		
		return this;
	}
	
	public String getMessageError() {
		WebElement labelMessage = getDriver().findElement(By.id("errorMessage"));		
		return labelMessage.getText();
	}

}
