package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressionCPFTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {		
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");		
		driver = new ChromeDriver();
		driver.get("https://www.geradordecpf.org/");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();	
	}
	
	@Test
	public void testValidaCpfComMascara() {
		
		WebElement cbPonto = driver.findElement(By.id("cbPontos"));
		cbPonto.click();
		
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfNumero = driver.findElement(By.id("numero"));
		
		String cpfGerado = tfNumero.getAttribute("value");
		
		System.out.println(cpfGerado);	
		
		//Expressão regular
		assertTrue(cpfGerado.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}"));		
	}
	
	@Test
	public void testValidaCpfSemMascara() {
		WebElement btnGerar = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfNumero = driver.findElement(By.id("numero"));
		
		String cpfGerado = tfNumero.getAttribute("value");
		
		System.out.println(cpfGerado);	
		
		//Expressão regular
		assertTrue(cpfGerado.matches("^\\d{11}$"));
		
	}
}
