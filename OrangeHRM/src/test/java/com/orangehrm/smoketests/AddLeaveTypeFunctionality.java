package com.orangehrm.smoketests;

import org.testng.annotations.Test;

import com.orangehrm.pages.LeavePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.BaseMethods;

public class AddLeaveTypeFunctionality extends BaseMethods{
	
	LeavePage lp = new LeavePage();
	LoginPage page = new LoginPage();
	
	@Test
	public void addLeaveTypes() {
		report.createTest("AddLeaveTypeFunctionality");
		page.validCredentials();
		lp.addingLeaveType("Conference Attendences");
	}

}
