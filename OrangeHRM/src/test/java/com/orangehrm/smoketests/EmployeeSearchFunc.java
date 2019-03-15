package com.orangehrm.smoketests;

import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIM_SearchEmployeePage;
import com.orangehrm.utilities.BaseMethods;

public class EmployeeSearchFunc extends BaseMethods {

	LoginPage lp = new LoginPage();
	PIM_SearchEmployeePage pimSearch = new PIM_SearchEmployeePage();

	@Test
	public void employeeSearch() {
		report.createTest("EmployeeSearchFunc");
		//extentLogger = report.createTest("EmployeeSearchFunc");  // bele de ola biler !!!
		lp.validCredentials();
		pimSearch.searchEmployee("Tofig");
	}
}
