package com.orangehrm.smoketests;

import org.testng.annotations.Test;

import com.orangehrm.pages.JobPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.BaseMethods;

public class AddingJobFunc extends BaseMethods{

	JobPage jp = new JobPage();
	LoginPage lp = new LoginPage();
	
	@Test
	public void addJobTitle() {
		report.createTest("Adding_Job_Func");
		lp.validCredentials();
		jp.addjobTitle("Software Tester MMC");
		
		
	}
}
