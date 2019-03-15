package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.utilities.Driver;

public class PIM {

	public PIM() {

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//b[contains(text(),'PIM')]")
	public WebElement pimbutton;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmployeeTab;

	@FindBy(id = "firstName")
	public WebElement firsNamebox;

	@FindBy(id = "lastName")
	public WebElement lastNamebox;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	@FindBy(xpath = "//a[contains(text(),'Employee List')]")
	public WebElement employeeList;

	@FindBy(partialLinkText = "0012")
	public WebElement employeeId;

	@FindBy(xpath = "//a[@href='/index.php/pim/viewJobDetails/empNumber/12']")
	
	public WebElement jobEdit;

	@FindBy(xpath="//input[@value='Edit']")
	public WebElement editBtn;

	@FindBy(id = "job_job_title")
	public WebElement jobTitle;

	@FindBy(xpath = "//select[@id='job_emp_status']")
	public WebElement employeementStatus;

	@FindBy(id = "job_sub_unit")
	public WebElement subUnit;

	@FindBy(xpath = "//a[contains(text(),'Report-to')]")
	public WebElement reportTo;

	@FindBy(xpath = "//input[@id='btnAddSupervisorDetail']")
	public WebElement addSupervisor;

	@FindBy(xpath = "//input[@id='reportto_supervisorName_empName']")
	public WebElement enterSupName;

	@FindBy(xpath = "//select[@id='reportto_reportingMethodType']")
	public WebElement repMod;

	@FindBy(xpath = "//input[@id='btnSaveReportTo']")
	public WebElement saveRepTo;

	public void addEmployees(String firstName, String lastName) {
		try {
			pimbutton.click();
			addEmployeeTab.click();
			firsNamebox.click();
			Thread.sleep(1500);
			firsNamebox.sendKeys(firstName);
			lastNamebox.click();
			Thread.sleep(1500);
			lastNamebox.sendKeys(lastName);
			saveBtn.click();
			Thread.sleep(1500);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editEmployeeInfo() {
		try {
			employeeList.click();
			Thread.sleep(1500);
			employeeId.click();
			Thread.sleep(1500);
			jobEdit.click();
			Thread.sleep(1500);
			editBtn.click();
			Thread.sleep(1500);

			Select jbTl = new Select(jobTitle);
			Thread.sleep(2000);
			jbTl.selectByVisibleText("IT Manager");

			Select emSt = new Select(employeementStatus);
			emSt.selectByVisibleText("Full-Time Permanent");

			Select sbUt = new Select(subUnit);
			sbUt.selectByIndex(2);
			Thread.sleep(1000);

			saveBtn.click();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addManager() {
		try {
			editBtn.click();
			Thread.sleep(1000);
			reportTo.click();
			Thread.sleep(1000);
			addSupervisor.click();
			Thread.sleep(1000);
			enterSupName.click();
			Thread.sleep(1000);
			enterSupName.sendKeys("t");
			Thread.sleep(1000);
			enterSupName.findElement(By.xpath("/html[1]/body[1]/div[4]/ul[1]/li[5]")).click();

			Select repmode = new Select(repMod);
			Thread.sleep(1000);
			repmode.selectByVisibleText("Direct");
			Thread.sleep(1000);
			saveRepTo.click();
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
