package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class RegularExpressionCPFTest extends BaseTest{
	
	@Before
	public void setUp() throws Exception {			
		getDriver().get("https://www.geradordecpf.org/");
	}
	
	@Test
	public void testValidaCpfComMascara() {
		
		WebElement cbPonto = getDriver().findElement(By.id("cbPontos"));
		cbPonto.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfNumero = getDriver().findElement(By.id("numero"));
		
		String cpfGerado = tfNumero.getAttribute("value");
		
		System.out.println(cpfGerado);	
		
		//Expressão regular
		assertTrue(cpfGerado.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}"));		
	}
	
	@Test
	public void testValidaCpfSemMascara() {
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfNumero = getDriver().findElement(By.id("numero"));
		
		String cpfGerado = tfNumero.getAttribute("value");
		
		System.out.println(cpfGerado);	
		
		//Expressão regular
		assertTrue(cpfGerado.matches("^\\d{11}$"));
		
	}
}
