package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkBasics.BaseMethods;
import pages.CRAClientSignup;

public class ClientSignUpIE11Test extends BaseMethods{

	@BeforeClass
	public void setData() {

		testCaseName = "CRA IE testing";
		testCaseDescription = "CRA Staging Login";
		author = "Manoj";
		category = "Sanity";
	}

	@Test
	public void CRAIETesting() {

		startApp("ie32", "https://cra-staging.vivriti.in/client/sign-up");
		WebElement headerele = locateElement("tagname", "h1");
		String headertxt = getText(headerele);
		reportStep("Found header as: "+headertxt+". So page loaded successfully in IE browser", "pass");

		new CRAClientSignup().enterCompanyName("Fresh Capital")
		.enterCIN("U11101UP1995PTC018264")
		.enterContactName("Paul Walker")
		.selectDesignation("Manager")
		.enterPhoneNumber("9865410292")
		.enterEmail("manojve@gmail.com")
		.enterPromoterName("Jack")
		.enterPromoterExp("3")
		.enterNoOfInstitutionalEquityInvestors("2")
		.selectStatutoryAuditor("Grant Thorton")
		.selectIndustry("Capital Goods")
		.enterNatureOfBusiness("Machineries")
		.selectVintageOfOperations("3")
		.enterEBITDA("3","4")
		.enterRevenue("3","4")
		.enterNetWorth("3","4")
		.enterDebtOutstanding("1","2")
		.enterPAT("1","2")
		.selectProductInterested()
		.enterFundingRequirement("8")
		.selectPartOfConglomerate("Yes")
		.enterConglomerateName("McDonalds")
		.selectHowYouHearAboutUs("Vivriti Capital client referral")
		.agreeTermsAndConditions();
		//		.ClickSubmit();
		
		closeBrowser();
	}

}