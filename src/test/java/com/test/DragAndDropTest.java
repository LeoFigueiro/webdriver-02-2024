package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
	
private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {		
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();	
	}
	
	@Test
	public void testDragAndDrop() {
		
		WebElement origin = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
				
		assertEquals("Drag me to my target", origin.getText());
		assertEquals("Drop here", target.getText());
		
		new Actions(driver).dragAndDrop(origin, target).perform();
		
		assertEquals("Dropped!", target.getText());		
	}
}
