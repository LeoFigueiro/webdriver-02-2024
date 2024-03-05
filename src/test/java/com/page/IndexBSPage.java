package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IndexBSPage {

	public Boolean isLogin() {		
		return getDriver().getTitle().equals("Books");				
	}
	
	public IndexBSPage inputQtdCoreJava(String quantity) {
		WebElement tfCoreJava = getDriver().findElement(By.xpath("//td[contains(text(),'Core Java')]/..//input"));
		tfCoreJava.sendKeys(quantity);		
		return this;
	}

	public IndexBSPage inputQtdRubyForRails(String quantity) {
		WebElement tfRubyForRais = getDriver().findElement(By.xpath("//td[contains(text(),'Ruby for Rails')]/..//input"));
		tfRubyForRais.sendKeys(quantity);
		return this;			
	}

	public IndexBSPage inputQtdPythonCookBook(String quantity) {
		WebElement tfPythonCookBook = getDriver().findElement(By.xpath("//td[contains(text(),'Python')]/..//input"));
		tfPythonCookBook.sendKeys(quantity);
		return this;		
	}
	
	public IndexBSPage clickAdd() {
		WebElement btnAdd = getDriver().findElement(By.xpath("//input[@value='Add']"));
		btnAdd.click();
		return this;		
	}

	public String getTotalCart() {
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		return tfTotal.getAttribute("value");		
	}

}
