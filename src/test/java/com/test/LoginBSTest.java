package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.core.BaseTest;
import com.page.IndexBSPage;
import com.page.LoginBSPage;

public class LoginBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private IndexBSPage indexPage;

	@Test
	public void testLoginValido() {
		loginPage = new LoginBSPage();
		loginPage.open();
		loginPage.inputUser("test");
		loginPage.inputPassword("secret");
		
		indexPage = loginPage.clickLogin();	
		
		assertTrue("Login deveria ter sido realizado!", indexPage.isLogin());
		
	}
	
}
