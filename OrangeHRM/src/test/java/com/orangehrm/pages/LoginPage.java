package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.ConfigurationReader;
import com.orangehrm.utilities.Driver;

public class LoginPage {
	
	public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
	
	@FindBy(id= "txtUsername")
    public WebElement userNameBox;

    @FindBy(id="txtPassword")
    public WebElement passBox;

    @FindBy (xpath = "//input[@id='btnLogin']")
    public WebElement submitBtn;
    
    
    public void validCredentials() {
    	//Choose the project
        userNameBox.click();
        userNameBox.sendKeys(ConfigurationReader.getProperty("loginUser"));
        passBox.click();
        passBox.sendKeys(ConfigurationReader.getProperty("passwordUser"));
        //Submit button click
        submitBtn.click();
    }
    
    
    /**
     * Method to test commonSteps with wrong credentials.
     * @param mail
     * @param password
     */
    public void wrongCredentials(String loginName, String password){
        //Choose the project
        userNameBox.click();
        userNameBox.sendKeys(loginName);
        passBox.click();
        passBox.sendKeys(password);
        //Submit button click
        submitBtn.click();
    }

}
