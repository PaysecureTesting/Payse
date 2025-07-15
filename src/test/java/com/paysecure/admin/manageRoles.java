package com.paysecure.admin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.Admin.pages.manageRoles_page;
import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;

public class manageRoles extends baseClass{
	
	
private loginPage lp;
manageRoles_page mr;
	
	@BeforeMethod
	public void setupPages() {
		lp= new loginPage(getDriver());
		lp.login("Suhas","Nick@123");
		mr=new manageRoles_page(getDriver());
		mr.navigateToManageRoles();
	}

	
	@Test
  public void verifySearchFunctionality() {
		mr.searchByUsername_Merchant("gouri_sharma");
		mr.verifySearchRoleSameorNot(getDriver(),"gouri_sharma");
		
  }
	
	@Test
	  public void verifySearchFunctionalityIfUserEnterWrongMerchant_Username() {
			mr.searchByUsername_Merchant("(*&^%$#$%^&*hgvhf)(*&^%^&*");
            mr.verifyIfUserEnterWrongUsername();
			
	  }
	
	@Test
	  public void verifyRefreshPage_SearchFunctionalityIfUserEnterWrongMerchant_Username() {
			mr.searchByUsername_Merchant("gouri_sharma");
            mr.refreshSearchPage(getDriver());
			
	  }
	
}
