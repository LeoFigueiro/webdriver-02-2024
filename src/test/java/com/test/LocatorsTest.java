package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class LocatorsTest extends BaseTest{
		
	@Before
	public void setUp() throws Exception {			
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
	}
		
	@Test
	public void testCheckBoxAPartirDeUmNome() {
		String sobreNome = "Mendes Beck";
		
		WebElement checkBox = getDriver().findElement(By.xpath("//td[contains(text(),'"+ sobreNome +"')]/../td/input"));
		checkBox.click();
		
		assertTrue(checkBox.isSelected());				
	}
	
	@Test
	public void testCopyEmail() {
		String nome = "Fulano da Silva";
		
		WebElement cellEmail = getDriver().findElement(By.xpath("//td[contains(text(),'"+ nome +"')]/following-sibling::td[1]"));
		String email = cellEmail.getText();
		
		WebElement tfEmailReserva = getDriver().findElement(By.id("txt01"));
		tfEmailReserva.sendKeys(email);
		
		assertEquals("mail2@gmail.com", tfEmailReserva.getAttribute("value"));
		
	}
	
	
	

}
