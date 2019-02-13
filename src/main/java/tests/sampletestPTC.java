package tests;

import java.awt.AWTException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameworkBasics.ProjectSpecificWrapper;
import pages.ClientTransaction;

public class sampletestPTC extends ProjectSpecificWrapper{

	@BeforeClass
	public void setData() {

		browser = "chrome";
//		url = "https://mp-qa.vivriti.in/login";
		url = "https://mp-staging.vivriti.in/login";
		username = "laxmi@vivriticapital.com";
		password = "Test@123";
		testCaseName = "Pass Through Certificates";
		testCaseDescription = "PTC Transaction Initiation";
		author = "Manoj";
		category = "Sanity";
		dataWBookName = "PassThroughCertificate";
	}

	@Test(dataProvider="fetchData")
	public void initiatePTC(String pltype, String mcdPath, String rsPath, String plctofDt, String pricng, String CEPref, 
			String prefSetlmntdt, String prty1, String prty2, String prty3) throws AWTException {
		new ClientTransaction().clickInitiateTrans()
		.clickPTC()
		.selectPoolType(pltype)
		.clickBrowseToUploadMCD(mcdPath)
		.clickBrowseToUploadRS(rsPath)
		.clickProceed()
		.selectPoolCutOffDate(plctofDt)
		.enterPricing(pricng)
		.selectCEPreference(CEPref)
		.selectPrefSettlementDate(prefSetlmntdt)
		.selectPriority1(prty1)
		.selectPriority2(prty2)
		.selectPriority3(prty3)
		.clickFinalProceed()
		.getDealName()
		.clickDone();
	}

}