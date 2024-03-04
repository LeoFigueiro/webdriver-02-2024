package com.page;

import static com.core.DriverFactory.getDriver;

public class IndexBSPage {

	public Boolean isLogin() {		
		return getDriver().getTitle().equals("Book");				
	}

}
