package com.test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculadoraTest {
	
	private WebDriver driver;
	private WebElement tfNumber1;
	private WebElement tfNumber2;
	private WebElement tfTotal;
	private WebDriverWait wait;	
	
	
	@Before
	public void setUp() throws Exception {		
		System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");		
		driver = new ChromeDriver();
		
		//espera implícita
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		
		//espera explícita
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//mapeia elemento
		tfNumber1 = driver.findElement(By.xpath("//*[@id='number1']"));				
		tfNumber2 = driver.findElement(By.id("number2"));
		tfTotal = driver.findElement(By.id("total"));		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();	
	}
	
	@Test
	public void testSoma() throws InterruptedException {
		
		Double valor1 = 20d;
		Double valor2 = 45.6d;
		
		Double totalTest = valor1 + valor2;
		
		tfNumber1.sendKeys(Double.toString(valor1));
		tfNumber2.sendKeys(Double.toString(valor2));
		
		WebElement btnSomar = driver.findElement(By.xpath("//input[@value='Somar']"));
		btnSomar.click();
		
		//espera explícita			
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("total"), Double.toString(totalTest)));
				
		String totalCalculadora = tfTotal.getAttribute("value");		
		assertEquals(Double.toString(totalTest), totalCalculadora);						
	}
	
	@Test
	public void testSubtracao() {
		Double valor1 = 60d;		
		Double valor2 = 45.5d;
		
		Double totalTest = valor1 - valor2;
				
		tfNumber1.sendKeys(Double.toString(valor1));		
		tfNumber2.sendKeys(Double.toString(valor2));
				
		WebElement btnSutrair = driver.findElement(By.id("subtrair"));
		btnSutrair.click();		
		
		String totalCalculadora = tfTotal.getAttribute("value");
		System.out.println(totalCalculadora);
		
		assertEquals(Double.toString(totalTest), totalCalculadora);
	}
	
	@Test
	public void testMultiplicacao(){
		Double valor1 = 60d;		
		Double valor2 = 3.5d;
		
		Double totalTest = valor1 * valor2;
				
		tfNumber1.sendKeys(Double.toString(valor1));		
		tfNumber2.sendKeys(Double.toString(valor2));
				
		WebElement btnMultiplicacao = driver.findElement(By.id("multiplicar"));
		btnMultiplicacao.click();		
		
		String totalCalculadora = tfTotal.getAttribute("value");
		
		System.out.println(totalTest);
		System.out.print(Double.parseDouble(totalCalculadora));
		
		assertEquals(totalTest, Double.parseDouble(totalCalculadora), 0.00001);		
	}

}
