package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.Driver;
public class PIM_SearchEmployeePage {

	public PIM_SearchEmployeePage() {

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//b[contains(text(),'PIM')]")
	public WebElement pimbutton;
	
	@FindBy(xpath = "//input[@id='empsearch_employee_name_empName']")
	public WebElement employeeNameBox;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	public void searchEmployee(String employeeName) {
		
		try {
			pimbutton.click();
			Thread.sleep(2000);
			employeeNameBox.click();
			Thread.sleep(2000);
			employeeNameBox.clear();
			Thread.sleep(2000);
			employeeNameBox.sendKeys(employeeName);
			Thread.sleep(2000);

			searchBtn.click();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
