package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementTest {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		//Identifica o driver do browser
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		//Criando o driver do tipo chromedriver
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();		
	}

	@Test
	public void testInputTextFieldHelloWorld() throws InterruptedException {
		//identifica o elemento
		WebElement textField = driver.findElement(By.name("txtbox1"));	
		//envia um valor de texto para o elemento		
		textField.sendKeys("Hello World!!");		
		//espera 3 segundos
		Thread.sleep(3000);
		//valida o resultado esperado é igual ao resultado atual
		assertEquals("Hello World!!", textField.getAttribute("value"));
	}
	
	@Test
	public void testValidaHabilitadoTextFields() {
		WebElement textField1 = driver.findElement(By.name("txtbox1"));
		WebElement textField2 = driver.findElement(By.name("txtbox2"));
		
		//elemento está habilitado?
		assertTrue(textField1.isEnabled());
		//elemento está desabilitado?
		assertFalse(textField2.isEnabled());			
		
	}
}
