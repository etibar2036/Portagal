package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.Driver;

public class LeavePage {
			
		public LeavePage() {
	        PageFactory.initElements(Driver.getDriver(), this);
	    }
		
		@FindBy(xpath= "//b[contains(text(),'Leave')]")
	    public WebElement leaveType;

	    @FindBy(id="menu_leave_leaveTypeList")
	    public WebElement leaveTypeList;

	    @FindBy (id = "btnAdd")
	    public WebElement addBtn;
	    
	    @FindBy (id = "leaveType_txtLeaveTypeName")
	    public WebElement leaveTypeNameBox;
	    
	    @FindBy (id = "saveButton")
	    public WebElement saveBtn;
	    
	    @FindBy(css = "#menu_leave_Configure")
	    public WebElement configureMenuBtn;
	    
	    
	    public void addingLeaveType(String leaveTxt) {
	    	
	    	Actions action = new Actions(Driver.getDriver());
	    	leaveType.click();
	    	
	    	action.moveToElement(configureMenuBtn).moveToElement(leaveTypeList).click().build().perform();
	    	addBtn.click();
	    	
	    	leaveTypeNameBox.click();
	    	leaveTypeNameBox.sendKeys(leaveTxt);
	    	saveBtn.click();
	    	
	    	
	    	
	    	
	    }

}
