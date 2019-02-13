package tests;

import java.awt.AWTException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkBasics.ProjectSpecificWrapper;
import pages.ClientTransaction;

public class sampletestDA extends ProjectSpecificWrapper{

	@BeforeClass
	public void setData() {

		browser = "chrome";
		url = "https://mp-staging.vivriti.in/login";
		username = "sonata@vivriticapital.com";
		password = "Test@123";
		testCaseName = "Direct Assignment";
		testCaseDescription = "DA Transaction Initiation";
		author = "Manoj";
		category = "Sanity";
		dataWBookName = "DirectAssignment_Staging";
	}

	@Test(dataProvider="fetchData")
	public void initiateDA(String pltype, String tentamt, String tentsetlmntdt, String tentprcng, String asgnrep, String crrtagncy, 
			String lwfrm, String audtr, String prfrpr1, String prfrpr2, String prfrpr3, String mcdpath, String rspath) throws InterruptedException, AWTException {

		new ClientTransaction().clickInitiateTrans()
		.clickDirectAssignment()
		.selectPoolType(pltype)
		.enterTentativeAmount(tentamt)
		.selectTentativeSettlementDate(tentsetlmntdt)
		.enterTentativePricing(tentprcng)
		.selectAssigneeRepresentative(asgnrep)
		.selectCreditRatingAgency(crrtagncy)
		.selectLawFirm(lwfrm)
		.selectAuditor(audtr)
		.selectPreferencePriority1(prfrpr1)
		.selectPreferencePriority2(prfrpr2)
		.selectPreferencePriority3(prfrpr3)
		.clickProceed()
		.clickBrowseToUploadMCD(mcdpath)
		.clickProceed()
		.clickBrowseToUploadRS(rspath)
		.clickProceed()
		.getDealName()
		.clickDone();
		}
}
