package com.orangehrm.smoketests;

import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentPage;
import com.orangehrm.utilities.BaseMethods;

public class AddNewVacancies extends BaseMethods{
	
	LoginPage page = new LoginPage();
	RecruitmentPage rP = new RecruitmentPage();
	
	@Test
	public void addVacancy() {
		report.createTest("AddNewVacancies");
		page.validCredentials();
		rP.addVacancy("t", 1, "tester2");
		
	}
	
 
}
