package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginBBPage {
	
	public LoginBBPage open() {
		getDriver().get("https://bugbank.netlify.app");
		return this;
	}
	
	public RegisterBBPage clickRegister() {
		WebElement btnRegister = getDriver().findElement(By.xpath("//button[.='Registrar']"));
		btnRegister.click();
		
		return new RegisterBBPage();
	}

}
