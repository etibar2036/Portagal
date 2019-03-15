package com.orangehrm.smoketests;

import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIM;
import com.orangehrm.utilities.BaseMethods;

public class AddEmployeeFunctionality extends BaseMethods {

	PIM pim1 = new PIM();
	LoginPage login = new LoginPage();

	@Test
	public void addEmployee() {
		report.createTest("AddEmployeeFunctionality");
		login.validCredentials();
		pim1.addEmployees("Tofig", "Daglar");
		pim1.editEmployeeInfo();
		pim1.addManager();
	}

}
