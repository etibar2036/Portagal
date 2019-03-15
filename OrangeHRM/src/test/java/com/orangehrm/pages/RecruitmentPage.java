package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.utilities.Driver;

public class RecruitmentPage {
	
	public RecruitmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
	
	@FindBy(id= "menu_recruitment_viewRecruitmentModule")
    public WebElement recruitMenuTab;

    @FindBy(id="menu_recruitment_viewJobVacancy")
    public WebElement vacanciesMenuTab;

    @FindBy (id = "btnAdd")
    public WebElement addBtn;
    
    @FindBy (id = "addJobVacancy_jobTitle")
    public WebElement jobTitleDrop;
    
    @FindBy (id = "addJobVacancy_name")
    public WebElement vacNameBox;
    
    @FindBy(id = "addJobVacancy_hiringManager")
    public WebElement hirManagerBox;
    
    @FindBy(xpath= "//div[@class='ac_results']//ul/li")
    public List<WebElement> name;
    
    @FindBy(id="btnSave")
    public WebElement saveBtn;
    
    
    public void addVacancy(String hirManager, int indexValue, String vacanName) {
    	
    	recruitMenuTab.click();
    	vacanciesMenuTab.click();
    	addBtn.click();
    	
    	Select dropDown = new Select(jobTitleDrop);
    	dropDown.selectByVisibleText("Sales Manager");
    	vacNameBox.click();
    	vacNameBox.sendKeys(vacanName);
    	hirManagerBox.click();
    	hirManagerBox.sendKeys(hirManager);
    	name.get(indexValue).click();
    	saveBtn.click();
    	
    	
    	
    	
    	
    	
    }

}
