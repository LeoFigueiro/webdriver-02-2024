package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		Thread.sleep(3000);
		driver.quit();		
	}

	@Test
	public void testInputTextFieldHelloWorld() {
		//identifica o elemento
		WebElement textField = driver.findElement(By.name("txtbox1"));	
		//envia um valor de texto para o elemento		
		textField.sendKeys("Hello World!!");				
		
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
	
	@Test
	public void testValidaRadioButton() {
		//mapeia
		List<WebElement> radios = driver.findElements(By.name("radioGroup1"));	
		
		//faz a iteração
		for (WebElement radio : radios) {
			if (radio.getAttribute("value").equals("Radio 3")) {
				radio.click();
			}			
		}		
		//Outra forma de fazer por posição
		//radios.get(2).click();
				
		//faz a validação
		assertTrue(radios.get(2).isSelected());
		
		assertFalse(radios.get(0).isSelected());
		assertFalse(radios.get(1).isSelected());
		assertFalse(radios.get(3).isSelected());		
	}
	
	@Test
	public void testValidaCheckBox() {
		//mapeia
		List<WebElement> checkBoxes = driver.findElements(By.name("chkbox"));
		
		//valida se a lista tem 4 elementos
		assertEquals(4, checkBoxes.size());

		//faz a iteração com elemnto
		for (WebElement checkBox : checkBoxes) {
			if (checkBox.getAttribute("value").equals("Check 3") || 
					(checkBox.getAttribute("value").equals("Check 4"))) {
				checkBox.click();
			}			
		}		
				
		//faz a validação
		assertTrue(checkBoxes.get(2).isSelected());
		assertTrue(checkBoxes.get(3).isSelected());
		
		assertFalse(checkBoxes.get(0).isSelected());
		assertFalse(checkBoxes.get(1).isSelected());		
	}
	
	@Test
	public void testValidaSelectSingle() {
		//mapeia o elemento
		WebElement dropdownSingle = driver.findElement(By.name("dropdownlist"));		
		Select selectSingle = new Select(dropdownSingle);
		
		//faz a iteração
		selectSingle.selectByVisibleText("Item 6");		
		
		selectSingle.selectByVisibleText("Item 7");
		
		//faz a validação
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());
	}
	
	
}
