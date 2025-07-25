package com.report.test;

import org.testng.annotations.Test;


import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.utilities.DataProviders;
import com.paysecure_Report.pages.cardSummary_transactionPage;
import com.paysecure_Report.pages.email_transactionPage;
import com.paysecure_Report.pages.transactionPage;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeMethod;

public class transaction extends baseClass {

	 private WebDriver driver;

	private transactionPage ts;
	private loginPage lp;
	email_transactionPage email;
	cardSummary_transactionPage card;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		lp = new loginPage(getDriver());
		lp.login("Suhas", "Nick@123");
		ts = new transactionPage(getDriver());
		ts.navigateUptoTransaction(getDriver());
		email = new email_transactionPage(getDriver());
		card = new cardSummary_transactionPage(getDriver());
	}

	@Test(priority = -1, enabled = true)

	public void transactionUsingSelectStatus() throws InterruptedException, TimeoutException {

		ts.filterTransactionThroughSelectStatus("Error");
		ts.clickOnSearchButton(getDriver());
		ts.checkTransactionStatus(getDriver());

	}

	@Test(priority = 0, enabled = true)

	public void transactionUsingSelectMerchant() throws InterruptedException, TimeoutException {

		ts.selectDashboardusinAllMerchant(getDriver());
		ts.clickOnSearchButton(getDriver());
		ts.checkTransactionStatus(getDriver());

	}

	@Test(enabled = true, priority = 1)

	public void transactionUsingSelectBank() throws InterruptedException, TimeoutException {
		ts.selectDashboardusinAllMerchant(getDriver());
		ts.selectDashboardusinAllBank(getDriver());
		ts.clickOnSearchButton(getDriver());
		ts.checkTransactionStatus(getDriver());

	}

	@Test(enabled = true, priority = 2)

	public void selectMIDBasedOnBank() throws InterruptedException, TimeoutException {
		ts.selectDashboardusinAllMerchant(getDriver());
		ts.selectDashboardusinAllBank(getDriver());
		ts.selectMID();
		ts.clickOnSearchButton(getDriver());
		ts.checkTransactionStatus(getDriver());

	}

	@Test(priority = 3, enabled = true)

	public void selectDate() throws InterruptedException, TimeoutException {

		ts.selectDateRange(getDriver(), "Yesterday");

		ts.clickOnSearchButton(getDriver());
		ts.checkTransactionStatus(getDriver());

	}

	@Test(priority = 4, enabled = true)

	public void selectDateRangeToAndFrom() throws InterruptedException, TimeoutException {
		ts.selectDateRange(getDriver(), "Custom Range");

		ts.selectDate_To(getDriver());

		ts.clickOnApplyButton(getDriver());

		// ts.clickOnSearchButton(driver);
		// ts.checkStatus(driver);
	}

	@Test(priority = 5, enabled = true)

	public void selectTimeZoneAndVerify() throws InterruptedException, TimeoutException {

		ts.selectTimeZone(getDriver());
		ts.clickOnSearchButton(getDriver());
		ts.checkTransactionStatus(getDriver());

	}

	@Test(priority = 6, enabled = true)

	public void selectCurrency() throws InterruptedException, TimeoutException {
		ts.selectCurrency(getDriver());

	}

	@Test(priority = 7, enabled = true)
	public void status() throws InterruptedException {
		ts.testSelectFilters(getDriver());
	}

	@Test(priority = 8, enabled = true)
	public void allActionOnTransactionPage() throws InterruptedException {
		ts.lastActionOnTransactionTable(getDriver());
		ts.historyOnTransaction(getDriver());
		ts.remarksOnTransactiontable(getDriver());

		ts.verifyErrorInRemarksField(getDriver());
		ts.verifyElementsInUserType(getDriver());

		ts.verifyUsers(getDriver());

		ts.selectError(getDriver());

		ts.checkAll_SelectError(getDriver());

		ts.enterMessage(getDriver());

		ts.clickOnSubmitButton(getDriver());

		ts.verifySuccessmessage(getDriver());

	}

	@Test(priority = 9, enabled = true)
	public void endToEndFlowOfTransaction() throws InterruptedException, TimeoutException {

		ts.filterTransactionThroughSelectStatus("Error");
		ts.selectDashboardusinAllMerchant(getDriver());
		ts.selectDashboardusinAllBank(getDriver());
		ts.selectMID();
		ts.selectDateRange(getDriver(), "Yesterday");
		ts.selectTimeZone(getDriver());
		ts.selectCurrency(getDriver());
		ts.clickOnSearchButton(getDriver());
		ts.checkTransactionStatus(getDriver());

	}

//	@Test(enabled =false)
//	public void validatetransactiondataWithCSV() throws InterruptedException {
//		ts.selectDateRange(driver,"Yesterday");
//		ts.clickOnSearchButton(driver);
//		ts.validateTransactiondataWithCSV(driver);
//		
//}
//	

	@Test(priority = 10, enabled = true)
	public void iterateAllTable_Pages() throws InterruptedException, TimeoutException {

		ts.filterTransactionThroughSelectStatus("Error");
		ts.selectDateRange(getDriver(), "Last 7 Days");
		ts.clickOnSearchButton(getDriver());

		ts.iterateAllTablePages(getDriver());

	}

	// in transaction page - verify purchase ID on transaction table and Transaction
	// page
	@Test(priority = 11, enabled = true)
	public void filter_Transaction_And_Open_Detail_Page() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.selectDateRange(getDriver(), "Yesterday");
		ts.clickOnSearchButton(getDriver());

	}

	@Test(priority = 12, enabled = true)
	public void verify_downloadInvoice() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.clickOnSearchButton(getDriver());
		ts.verifyDownloadInvoice("Paid");

	}

	@Test(priority = 13, enabled = true)
	public void verifyErrorIn_downloadInvoice() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.clickOnSearchButton(getDriver());
		ts.verifyDownloadInvoice("Paid");
		ts.verifyErrorInDownloadInvoice_LogoAndComapanyEmail();
		ts.verifyErrorInDownloadInvoice_addProduct();
		// ts.verifyTotalAmountInDownloadInvoice(5, 9);

	}



	@Test
	public void verifyPurchaseID_EmailSummaryPage() {
		email.clickOnEmail();
		email.clickOnTotal();
		email.verifyTransactionIDOnEmailSummeryPage();

	}

	@Test
	public void verifyTransaCTIONidIn_ActionPage() {

		email.clickOnEmail();
		email.clickOnTotal();
		email.validatePurchaseIDWithActions();

	}

	@Test
	public void validtePaginationInEmailSummaryPage() {
		email.clickOnEmail();
		email.clickOnTotal();
		email.iterateAllTablePages(getDriver());

	}

	@Test
	public void testClickFirstEmailOccurrence() {
		String targetEmail = "go************0 ...";
		email.clickOnSpecificEmail(getDriver(), targetEmail);
	}

	@Test (dataProvider ="EmailID", dataProviderClass = DataProviders.class)
	public void testClickFirstEmailOccurrenceOf_Card(String email_id) throws InterruptedException {

	
			ts.selectDateRange(getDriver(), "Last 7 Days");
			ts.clickOnSearchButton(getDriver());
			email.clickOnSpecificEmail(getDriver(),email_id);
			email.verifydayFrequesncy(getDriver());
			email.verifyMonthFrequesncy(getDriver());
			email.verifyWeekFrequesncy(getDriver());
			email.verifyYearFrequesncy(getDriver());
			email.verifyCustomerMerchantFrequency(getDriver());
			email.verifyCustomerCardFrequency(getDriver());
			email.verifyCustomerCountriesFrequency(getDriver());
			email.verifyCustomerIPSFrequency(getDriver());
			email.verifyAmountFrequency(getDriver());
			email.verifyCustomerDeviceID(getDriver());
			email.verifyTotal(getDriver());
		

	}
	

	@Test
	public void testClickFirstValid_TransactionOnCardOage() {
		String targetCard = "PAYID";
		card.clickOnCard(getDriver(), targetCard);
		card.clickFirstValidTransaction(getDriver());
		card.verifyTransactionIN_CardPage();
		
	}
	
	@Test (dataProvider ="cardNames", dataProviderClass = DataProviders.class)
	public void testTIDInActionCardSummarypage(String targetCard) throws InterruptedException {
		ts.selectDateRange(getDriver(),"Last 7 Days");
		ts.clickOnSearchButton(getDriver());
		
		card.clickOnCard(getDriver(), targetCard);
		card.clickOnActionColumn(getDriver());
		card.verifyPurchaseIDOnActionPage();
		card.verifymercahntNameOnActionPage();
		
		
	}
	
	@Test (dataProvider ="cardNames", dataProviderClass = DataProviders.class)
	public void testTIDInHistoryCardSummarypage(String targetCard) throws InterruptedException {
		ts.selectDateRange(getDriver(),"Last 7 Days");
		ts.clickOnSearchButton(getDriver());
		
		card.clickOnCard(getDriver(), targetCard);
		card.clickOnHistoryColumn(getDriver());
		card.verifyPurchaseIDOnHistoryPage();
		
		
	}
	
	@Test
	public void verifyTransactionIDAndStatus_Paid() throws InterruptedException{
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.clickOnSearchButton(getDriver());
		ts.verifyPaidTransaction(getDriver());
		ts.extractPurchaseIdFromSpanFormat(getDriver());
		ts.verifyTRNIDIn_Paid();
		

	}
	@Test
	public void verifyTransactionIDAndStatus_Paid123() throws InterruptedException{
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.clickOnSearchButton(getDriver());
		ts.verifyPaidTransaction(getDriver());
	
		ts.getJsonSpanValue(getDriver());
		ts.verifyStatus_Paid(getDriver());

	}

	// payment flow
	// mid
	// Issuerbank
	// MDR
	// PSP -payout/payin/accuring bank
	// Risk factor
	// rolling reserver

}
