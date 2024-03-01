package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class CalculadoraTest extends BaseTest{
		
	private WebElement tfNumber1;
	private WebElement tfNumber2;
	private WebElement tfTotal;
	private WebDriverWait wait;	
	
	
	@Before
	public void setUp() throws Exception {					
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		
		//espera explícita
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
		
		//mapeia elemento
		tfNumber1 = getDriver().findElement(By.xpath("//*[@id='number1']"));				
		tfNumber2 = getDriver().findElement(By.id("number2"));
		tfTotal = getDriver().findElement(By.id("total"));		
	}

	
	@Test
	public void testSoma() throws InterruptedException {
		
		Double valor1 = 20d;
		Double valor2 = 45.6d;
		
		Double totalTest = valor1 + valor2;
		
		tfNumber1.sendKeys(Double.toString(valor1));
		tfNumber2.sendKeys(Double.toString(valor2));
		
		WebElement btnSomar = getDriver().findElement(By.xpath("//input[@value='Somar']"));
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
				
		WebElement btnSutrair = getDriver().findElement(By.id("subtrair"));
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
				
		WebElement btnMultiplicacao = getDriver().findElement(By.id("multiplicar"));
		btnMultiplicacao.click();		
		
		String totalCalculadora = tfTotal.getAttribute("value");
		
		System.out.println(totalTest);
		System.out.print(Double.parseDouble(totalCalculadora));
		
		assertEquals(totalTest, Double.parseDouble(totalCalculadora), 0.00001);		
	}

}
