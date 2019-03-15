package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.Driver;

public class JobPage {

	public JobPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//input[@id='jobTitle_jobTitle']")
	public WebElement jobTab;

	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement saveBtn;

	@FindBy(xpath = "//b[contains(text(),'Admin')]")
	public WebElement adminTab;

	@FindBy(xpath = "//a[@id='menu_admin_Job']")
	public WebElement jobMenuBtn;

	@FindBy(xpath = "//input[@id='btnAdd']")
	public WebElement addBtn;

	@FindBy(xpath = "//a[@id='menu_admin_viewJobTitleList']")
	public WebElement jobTitleMenuList;

	public void addjobTitle(String title) {

		try {
			adminTab.click();

			Actions action = new Actions(Driver.getDriver());

			action.moveToElement(jobMenuBtn).moveToElement(jobTitleMenuList).click().build().perform();

			addBtn.click();
			Thread.sleep(1000);
			jobTab.click();
			Thread.sleep(1000);
			jobTab.sendKeys(title);
			Thread.sleep(1000);
			saveBtn.click();
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
