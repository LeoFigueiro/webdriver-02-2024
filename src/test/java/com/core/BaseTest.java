package com.core;

import org.junit.After;

public class BaseTest {
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		DriverFactory.killDriver();
	}

}
