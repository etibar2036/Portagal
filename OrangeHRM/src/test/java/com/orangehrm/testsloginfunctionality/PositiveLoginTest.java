package com.orangehrm.testsloginfunctionality;

import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.BaseMethods;

public class PositiveLoginTest extends BaseMethods{
	
	LoginPage page = new LoginPage();

	@Test
	public void loginUser() {
		extentLogger =report.createTest("OrangeHRM_Positive_Login_Test");
		page.validCredentials();
		
	}
	
	
}
