package com.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.core.BaseTest;
import com.core.GlobalProperty;
import com.page.IndexBSPage;
import com.page.LoginBSPage;

public class LoginBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private IndexBSPage indexPage;
	private String url = GlobalProperty.getProperty("webdriver.url");
	
	@Before
	public void setUp() {
		loginPage = new LoginBSPage();
	}

	@Test
	public void testLoginValido() {				
		loginPage.open(url);
		loginPage.inputUser(GlobalProperty.getProperty("webdriver.user"));
		loginPage.inputPassword(GlobalProperty.getProperty("webdriver.pass"));
		
		indexPage = loginPage.clickLoginValido();	
		
		assertTrue("Login deveria ter sido realizado!", indexPage.isLogin());
		
	}
	
	@Test
	public void testLoginPasswordInvalido() {
		loginPage.open(url);
		loginPage.inputUser(GlobalProperty.getProperty("webdriver.user"));
		loginPage.inputPassword("passinvalido");
		
		loginPage.clickLoginInvalido();
		
		assertEquals("Mensagem deveria estar disponibilizada na tela", 
				"Invalid username or password", loginPage.getMessageError());		
		
	}
	
}
