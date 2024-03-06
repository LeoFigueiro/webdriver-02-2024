package com.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.core.BaseTest;
import com.page.LoginBBPage;
import com.page.RegisterBBPage;

public class RegisterBBTest extends BaseTest {
	
	private LoginBBPage loginPage;
	private RegisterBBPage registerPage;
	
	@Test
	public void testRegisterUser() throws InterruptedException {
		
		loginPage = new LoginBBPage();
		loginPage.open();
		
		registerPage = loginPage.clickRegister();
		registerPage.inputEmail("cursoautomacao@targettrust.com.br");
		registerPage.inputName("Automacao");
		registerPage.inputPassword("123456");
		registerPage.inputConfirmationPassword("123456");
				
		Thread.sleep(1000);
		registerPage.checkToggleSaldo();
		registerPage.clickCadastrar();
		
		Thread.sleep(1000);
		String message = registerPage.getTextModal();
		System.out.println(message);	
		
		assertTrue(message.matches("^A conta [0-9]{3}-[0-9]{1} foi criada com sucesso$"));			
	}

}
