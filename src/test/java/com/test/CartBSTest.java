package com.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.core.BaseTest;
import com.page.IndexBSPage;
import com.page.LoginBSPage;

public class CartBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private IndexBSPage indexPage;
	private String url = "http://sahitest.com/demo/training/login.htm";
	
	@Before
	public void setUp() {
		loginPage = new LoginBSPage();
		loginPage.open(url);
		loginPage.inputUser("test");
		loginPage.inputPassword("secret");
		indexPage = loginPage.clickLoginValido();		
	}
	
	@Test
	public void testAddCart() {
		
		indexPage.inputQtdCoreJava("5"); 
		indexPage.inputQtdRubyForRails("2");
		indexPage.inputQtdPythonCookBook("3");
		indexPage.clickAdd();
		
		assertEquals("2950", indexPage.getTotalCart());
		
	}

}
