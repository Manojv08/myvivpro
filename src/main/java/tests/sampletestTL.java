package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkBasics.ProjectSpecificWrapper;
import pages.ClientTransaction;

public class sampletestTL extends ProjectSpecificWrapper{

	@BeforeClass
	public void setData() {

		browser = "chrome";
		url = "https://mp-staging.vivriti.in/login";
		username = "laxmi@vivriticapital.com";
		password = "Test@123";
		testCaseName = "Term Loan";
		testCaseDescription = "TL Transaction Initiation";
		author = "Manoj";
		category = "Sanity";
		dataWBookName = "TermLoan";
	}

	@Test(dataProvider="fetchData")
	public void initiateTL(String faclmt, String astcls, String tenoryr, String tenormnth, String tenordays, String avlprd, 
			String prfdisbrdt, String trnchdisbrsmnt, String trnchamt, String defmnth, String prrpyfrq, String intrpyfrq, 
			String rpaytyp, String prinmort, String mortprd, String protct) {

		new ClientTransaction().clickInitiateTrans()
		.clickTermLoan()
		.enterFacilityLimit(faclmt)
		.selectAssetClass(astcls)
		.selectTenor(tenoryr, tenormnth, tenordays)
		.selectAvailabilityPeriod(avlprd)
		.selectPreferredDisbursementDate(prfdisbrdt)
		.selectTrancheDisbursement(trnchdisbrsmnt)
		.enterTrancheAmount(trnchamt)
		.enterDeferralMonths(defmnth)
		.selectPrincipalRepayFreq(prrpyfrq)
		.selectInterestRepayFreq(intrpyfrq)
		.selectRepaymentType(rpaytyp)
		.selectPrincipalMoratorium(prinmort)
		.selectMoratoriumPeriod(mortprd)
		.selectProtection(protct)
		.clickProceed()
		.getDealName()
		.clickDone();

	}

}