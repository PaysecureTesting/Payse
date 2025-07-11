package com.report.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.pages.loginPage;
import com.paysecure_Report.pages.bank_Transaction_Time;
import com.paysecure_Report.pages.transactionPage;

@Test
public class bankTransactionTime extends baseClass {
	loginPage lp;
	transactionPage ts;
	bank_Transaction_Time bank;

	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {

		lp = new loginPage(getDriver());
		lp.login("Suhas", "Nick@123");

		ts = new transactionPage(getDriver());

		bank = new bank_Transaction_Time(getDriver());

	}

	@Test
	public void verifyBankTransactionTimeReport() throws InterruptedException {
		bank.navigateUptoBankTransactionTimeReport(getDriver());
		bank.convertDateFormat();
		bank.selectDate(getDriver());
		bank.applyButton(getDriver());
		ts.selectDashboardusinAllBank(getDriver());
		bank.enterTimeIn_Transaction_Time_more_than(getDriver(), "0");
		bank.searchButton(getDriver());

	}

}
