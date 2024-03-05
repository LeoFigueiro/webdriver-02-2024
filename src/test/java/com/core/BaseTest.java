package com.core;

import static com.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void tearDown() throws InterruptedException, IOException {
		//Thread.sleep(3000);
		//Screenshot da execução
		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		//salva o arquivo com .jpg
		FileUtils.copyFile(screen, new File("target" + File.separator + testName.getMethodName()+".jpg"));
		
		DriverFactory.killDriver();
	}

}
