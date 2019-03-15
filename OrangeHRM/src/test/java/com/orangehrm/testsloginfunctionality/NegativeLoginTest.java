package com.orangehrm.testsloginfunctionality;

import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.BaseMethods;

public class NegativeLoginTest extends BaseMethods{
	
	LoginPage page = new LoginPage();
	
		
	@Test(description = "1.01", priority = 1)	
	public void negTest1() {
		report.createTest("OrangeHRM_01");
		page.wrongCredentials("admin12345", "admin12345");
	}
	
	@Test(description = "1.02", priority = 2)
	public void negTest2() {
		report.createTest("OrangeHRM_02");
		page.wrongCredentials("admin123", "admin123");
	}
	
	@Test(description = "1.03", priority = 3)
	public void negTest3() {
		report.createTest("OrangeHRM_03");
		page.wrongCredentials("admin", "admin12345");
	}
	@Test(description = "1.04", priority = 4)
	public void negTest4() {
		report.createTest("OrangeHRM_04");
		page.wrongCredentials("admin", "");
	}

}
