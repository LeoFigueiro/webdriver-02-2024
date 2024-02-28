package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {		
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");		
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();	
	}
	
	@Test
	public void testCheckBoxAPartirDeUmNome() {
		String sobreNome = "Mendes Beck";
		
		WebElement checkBox = driver.findElement(By.xpath("//td[contains(text(),'"+ sobreNome +"')]/../td/input"));
		checkBox.click();
		
		assertTrue(checkBox.isSelected());				
	}
	
	@Test
	public void testCopyEmail() {
		String nome = "Fulano da Silva";
		
		WebElement cellEmail = driver.findElement(By.xpath("//td[contains(text(),'"+ nome +"')]/following-sibling::td[1]"));
		String email = cellEmail.getText();
		
		WebElement tfEmailReserva = driver.findElement(By.id("txt01"));
		tfEmailReserva.sendKeys(email);
		
		assertEquals("mail2@gmail.com", tfEmailReserva.getAttribute("value"));
		
	}
	
	
	

}
