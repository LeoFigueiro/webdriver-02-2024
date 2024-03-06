package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterBBPage {
	
	public RegisterBBPage inputEmail(String mail) {		
		WebElement tfEmail = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='email']"));
		tfEmail.sendKeys(mail);	
		return this;				
	}
	
	public RegisterBBPage inputName(String name) {
		WebElement tfName = getDriver().findElement(By.xpath("//input[@name='name']"));
		tfName.sendKeys(name);		
		return this;
	}
	
	public RegisterBBPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='password']"));
		tfPass.sendKeys(pass);		
		return this;			
	}
	
	public RegisterBBPage inputConfirmationPassword(String pass) {
		WebElement tfConfirmPass = getDriver().findElement(By.xpath("//input[@name='passwordConfirmation']"));
		tfConfirmPass.sendKeys(pass);		
		return this;
	}
	
	public RegisterBBPage checkToggleSaldo() {		
		WebElement checkSaldo = getDriver().findElement(By.id("toggleAddBalance"));						
		checkSaldo.click();		
		return this;
	}
	
	public RegisterBBPage clickCadastrar() {							
		WebElement btnCadastrar = getDriver().findElement(By.xpath("//button[.='Cadastrar']"));
		btnCadastrar.click();		
		return this;
	}
	
	public String getTextModal() {
		WebElement labelMessage = getDriver().findElement(By.id("modalText"));
		return labelMessage.getText();
	}

}
