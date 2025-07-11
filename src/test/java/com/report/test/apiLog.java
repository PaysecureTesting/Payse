package com.report.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.pages.loginPage;
import com.paysecure_Report.pages.apiLog_page;
import com.paysecure_Report.pages.bank_Transaction_Time;
import com.paysecure_Report.pages.transactionPage;

public class apiLog extends baseClass{
	
	
	loginPage lp;
	transactionPage ts;
	bank_Transaction_Time bank;
	apiLog_page api;
	

	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {

		lp = new loginPage(getDriver());
		lp.login("Suhas", "Nick@123");

		ts = new transactionPage(getDriver());

		api=new apiLog_page(getDriver());
				

	}
	
	
	
	
	
  @Test
  public void f() throws InterruptedException, TimeoutException {
		api.verifyUserIsOnApiReportPage(getDriver());
		ts.selectDateRange(getDriver(),"This Week");
		api.selectAPI("Check_Customer_TrustScore");
		api.selectMecrchant(getDriver());
		
		api.click_SearchButton(getDriver());
		api.click_DownloadButton(getDriver());
	//	api.verify_AlertMessageForDownload(getDriver());
	    api.checkTransactionStatus(getDriver());
		
  }
}
