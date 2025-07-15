package com.paysecure.Admin.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;

public class manageRoles_page {
	//Navigate - Manage Roles
	private By manageRoles= By.xpath("//span[text()='Manage Roles']");
	private By manage_Roles= By.xpath("//h1[text()='Manage Roles']");
 
	//search Functionality
	private By search= By.xpath("//input[@placeholder='Username or Merchant Name']");
	private By searchButton= By.xpath("//input[@placeholder='Username or Merchant Name']/following-sibling::button");
	
	@FindBy(xpath="//span[@name='fordeleterole']") private WebElement USERNAME;
	private By noRecordsFound= By.xpath("//td[text()='No Records Found']");
	
	//add role
	private By adddRole= By.xpath("//button[@title='Add Role']");
	private By username=By.xpath("//input[@id='username1']");
	private By password=By.xpath("//input[@id='password1']");
	private By emailAddress=By.xpath("//input[@id='emailaddress1']");
	private By role=By.xpath("//select[@id='role_id1']//input[@id='username1']");                                                                                                                                                                                          
	private By addRoleButton=By.xpath("//button[@id='addRoleButton']");
	
	private By usernameError=By.xpath("//input[@id='username1']/following-sibling::span[contains(normalize-space(), 'field is required')]");
	private By usernameError_Character=By.xpath("//input[@id='username1']/following-sibling::span[contains(normalize-space(), 'should be min 5 character')]");
	private By usernameError_Space=By.xpath("//input[@id='username1']/following-sibling::span[contains(normalize-space(), 'not allowed')]");
	
	
	private By passwordError=By.xpath("//input[@id='password1']/ancestor::div[@class='form-group col-md-12']/div/following-sibling::span//input[@id='username1']");
	private By password_Character=By.xpath("//input[@id='password1']/ancestor::div[@class='form-group col-md-12']//span[contains(normalize-space(), 'one small and one capital letter')]");
	
	private By emailError=By.xpath("//input[@id='emailaddress1']/following-sibling::span[contains(normalize-space(),'field is required')]");
	private By email_Character=By.xpath("//input[@id='emailaddress1']/following-sibling::span[contains(normalize-space(),'Email address')]");
	
	
	
	
	
	
	
	
	
	private ActionDriver actionDriver;
// page factory constructor
public manageRoles_page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.actionDriver = new ActionDriver(driver);
}


public void navigateToManageRoles() {
	actionDriver.click(manageRoles);
	Reporter.log("User Click on Main Module - Manage Roles", true);
	
	Assert.assertTrue(actionDriver.isDisplayed(manage_Roles),"If Manage Roles is not displays on Manage Roles page then user is not on the Manage Roles page");                                              
	Reporter.log("User is on the Manage Roles Main Module", true);
	

}


public void searchByUsername_Merchant(String username_Merchant) {
	actionDriver.enterText(search, username_Merchant);
	Reporter.log("User search username/Merchant :- "+username_Merchant, true);
	
	actionDriver.click(searchButton);
	Reporter.log("User Click on search button", true);

}

public void verifySearchRoleSameorNot(WebDriver driver,String username_Merchant) {
	actionDriver.enterText(search, username_Merchant);
	Reporter.log("User search username/Merchant :- "+username_Merchant, true);
	
	actionDriver.click(searchButton);
	Reporter.log("User Click on search button", true);
	
	String user_name = USERNAME.getAttribute("data-username");
	
	Assert.assertEquals(username_Merchant,user_name,"If both are not match then our TC is Fail");                                                                   
	Reporter.log("Verify search username is present on this manage role page :- "+ username_Merchant, true);
	
}
		
		
		public void verifyIfUserEnterWrongUsername() {
        Assert.assertTrue(actionDriver.isDisplayed(noRecordsFound));
        Reporter.log("If user enter any wrong username or merchant name then No records found is successfully displays", true);
		}
		
		
         public void refreshSearchPage(WebDriver driver) {
        	 JavascriptExecutor js = (JavascriptExecutor) driver;
        	    js.executeScript("location.reload();");
        	 
        	  Assert.assertTrue(driver.getTitle().contains("Manage Roles - Paysecure"));
        	  
         }



        public void verifyAllErrorsInAddRole() {
        	
        	
        	
        	
        }
        		
        		






































































































}
