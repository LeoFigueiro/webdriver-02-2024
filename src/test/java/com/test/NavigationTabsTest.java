package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTabsTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {		
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");		
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao");		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();	
	}
	
	@Test
	public void testValidaNavigationForTabs() {
		assertEquals("Treino Automação de Testes", driver.getTitle());
				
		WebElement linkDragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
	
		WebElement linkBookStore = driver.findElement(By.linkText("Book Store"));
		linkBookStore.click();
				
		//Monta um array com as janelas/tabs abertas
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//Navega nas posições do array
		driver.switchTo().window(tabs.get(1));
		
		assertEquals("Login", driver.getTitle());
		
		driver.switchTo().window(tabs.get(2));
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());		
	
		driver.switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", driver.getTitle());
	}

}
