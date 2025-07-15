package com.paysecure.utilities;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders {

	private static final String FILE_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/testdata/TestData.xlsx";

	@DataProvider(name = "validLoginData")
	public static Object[][] validLoginData() {
		return getSheetData("validLoginData");
	}

	@DataProvider(name = "inValidLoginData")
	public static Object[][] inValidLoginData() {
		return getSheetData("inValidLoginData");
	}

	@DataProvider(name = "emplVerification")
	public static Object[][] emplVerfication() {
		return getSheetData("emplVerfication");
	}

	private static Object[][] getSheetData(String sheetName) {
		List<String[]> sheetData = ExcelReaderUtility.getSheetData(FILE_PATH, sheetName);

		Object[][] data = new Object[sheetData.size()][sheetData.get(0).length];

		for (int i = 0; i < sheetData.size(); i++) {
			data[i] = sheetData.get(i);
		}

		return data;
	}

	@DataProvider(name = "cardNames")
	public Object[][] getCardNames() {
		return new Object[][] {
//			{ "MOBILEMONEY" }, 
//			{ "INTERAC" }, 
//			{ "PIX" },
//			{ "50785078******7812" }, 
			{ "PAYID" },
//				{ "40840840****4081" }, 
//				{ "VIRTUAL-ACCOUNT" }, 
				};
	}

	@DataProvider(name = "EmailID")
	public Object[][] getEmailID() {
		return new Object[][] { { "al********o@b** ..." }, { "ra**l@p******** ..." }, { "cu*****r@e****. ..." },
				{ "go************0 ..." }, { "bh***********r@ ..." },

		};
	}
	
	@DataProvider(name = "expectedHeadersProvider")
	public Object[][] expectedHeadersProvider() {
	    return new Object[][] {
	        { Arrays.asList("DATE","BANK NAME", "TRANSACTION ID", "MERCHANT NAME", "TRANSACTION PROCESS TIME") }
	    };
	}
	
	
	
	@DataProvider(name = "HeadersProvider")
	public Object[][] expectedHeadersProvider_APILog() {
	    return new Object[][] {
	        { Arrays.asList("DATE","API PARAMETER", "RESPONSE", "REDIRECT API") }
	    };
	}
	
	
	@DataProvider(name = "Headers")
	public Object[][] expectedHeadersProvider_transactionLog() {
	    return new Object[][] {
	        { Arrays.asList("DATE", "PURCHASE ID","TEXT") }
	    };
	}
	
	
	

}
