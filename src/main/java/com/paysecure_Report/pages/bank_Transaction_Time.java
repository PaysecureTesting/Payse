package com.paysecure_Report.pages;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;



public class bank_Transaction_Time {

	// navigate upto Bank Transaction Time Report
	private By analytics = By.xpath("//span[text()='Analytics']");
	private By report = By.xpath("(//span[text()='Report'])[2]");
	private By bank_Transaction_Time= By.xpath("//span[contains(text(),'Transaction Time')]");
	private By bank_Transaction_Time_Report = By.xpath("//h1[text()='Bank Transaction Time Report']");
	


	// todays date verify
	private By todaysDate= By.xpath("//span[@class='settleFont']");
	@FindBy(xpath="//span[@class='settleFont']")private WebElement TODAYS_DATE;


	// verify dates in select bank
	private By disableDate = By.xpath("(//td[text()='2'])[2]");
	
	@FindBy(xpath="//span[@class='settleFont']")private WebElement DISABLE_DATE;
	
	private By enableDate = By.xpath("(//td[@data-title='r0c2'])[1]");
	
	@FindBy(xpath="(//td[@data-title='r0c2'])[1]")private WebElement ENABLE_DATE;
	
	private By cancel= By.xpath("//button[text()='Cancel']");
	private By apply = By.xpath("//button[text()='Apply']");
	private By calendar = By.xpath("//img[@class='left_calander']");
	
	

	// select bank
	private By selectbank = By.xpath("//select[@id='bnk']");
	@FindBy(xpath="//select[@id='bnk']")private WebElement SELECT_BANK;
	

	// Transaction Time more than
	private By enterTime = By.xpath("//input[@id='moreThanSeconds']");
	

	// search button
	private By searchButton = By.xpath("//button[text()='Search']");
	private ActionDriver actionDriver;


	// page factory constructor
	public bank_Transaction_Time(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void navigateUptoBankTransactionTimeReport(WebDriver driver) throws InterruptedException {
		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(1800);
		// scroll to element
		actionDriver.scrollToElement(analytics);
	
		Reporter.log("SCROOLL UPTO ANALYTICS", true);

		actionDriver.click(report);
		
		Reporter.log("Click on Report Module", true);
		actionDriver.click(bank_Transaction_Time);
		
		Reporter.log("Click on Bank Transaction Time Sub Module", true);

		Assert.assertTrue(actionDriver.isDisplayed(bank_Transaction_Time_Report),
				"user is not on the Bank Transaction Time Report this page");
		Reporter.log("verify user is on the Bank Transaction Time Report", true);
	}

	public void convertDateFormat() {
		// rawDate is like: "02-07-2025 00:00"
		String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Reporter.log("todays date :- " + expectedDate, true);

		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String inputDate = TODAYS_DATE.getText();

		TemporalAccessor date = inputFormat.parse(inputDate);
		String convertedDate = outputFormat.format(date);

		Reporter.log("Converted Date: " + convertedDate, true);

		Assert.assertEquals(convertedDate, expectedDate, "if Both date are not matching then our Test Cases is failed");

		Reporter.log("checking todays date are displays on this Bank transaction report page", true);

	}

	public void selectDateisDisabled(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		actionDriver.click(calendar);
		

		boolean date = actionDriver.isDisplayed(disableDate);

		System.out.println(date);

		Assert.assertFalse(DISABLE_DATE.isEnabled(), "The field should be disabled but it's enabled.");
		Reporter.log("Date is disabled", true);

		
		actionDriver.click(cancel);
		Reporter.log("Click on Cancel Button in Calendor", true);

	}

	public void verifySelectDateIsEnabled(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		actionDriver.click(calendar);
	

		boolean date = ENABLE_DATE.isEnabled();

		Assert.assertFalse(date, "The field should be enable but it's disable.");
		Reporter.log("Date is enabled", true);

		
		actionDriver.click(enableDate);
		Reporter.log("Click on Date", true);

	
		actionDriver.click(apply);
		Reporter.log("Click on Apply Button in Calendor", true);
	}

	public void selectDate(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		actionDriver.click(calendar);
		
		Reporter.log("Click on Calendor Button in Calendor", true);
		actionDriver.click(enableDate);
		
		Reporter.log("Click on Date", true);
	}

	public void cancelButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		actionDriver.click(cancel);
		Reporter.log("Click on Cancel Button in Calendor", true);

	}

	public void applyButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		actionDriver.click(apply);
		Reporter.log("Click on Apply Button in Calendor", true);

	}

	public void selectBank(WebDriver driver, String bank) {
		Select s = new Select(SELECT_BANK);
		s.selectByVisibleText(bank);
		Reporter.log("user select value :- "+bank, true);
	}

	public void enterTimeIn_Transaction_Time_more_than(WebDriver driver, String time) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		actionDriver.enterText(enterTime, time);
		Reporter.log("user enter time "+time, true);

	}

	public void searchButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
	
		actionDriver.click(searchButton);
		Reporter.log("Click on search Button in Calendor", true);

	}
}
