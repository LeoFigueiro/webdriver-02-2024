package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CacheTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {		
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");		
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao");
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();	
	}
	
	@Test
	public void testNavigationCache() {
		assertEquals("Treino Automação de Testes", driver.getTitle());		
		
		WebElement menuCalculadora = driver.findElement(By.linkText("Calculadora"));
		menuCalculadora.click();
		
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		WebElement menuLocalizarTable = driver.findElement(By.linkText("Localizar Table"));
		menuLocalizarTable.click();
		
		assertEquals("Trabalhando com tables", driver.getTitle());	
		
		driver.navigate().back();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().back();
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		driver.navigate().forward();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		driver.navigate().forward();
		assertEquals("Trabalhando com tables", driver.getTitle());
		
		driver.navigate().refresh();
		assertEquals("Trabalhando com tables", driver.getTitle());
		
	}

}
