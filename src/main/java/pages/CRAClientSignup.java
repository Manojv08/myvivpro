package pages;

import org.openqa.selenium.WebElement;

import frameworkBasics.BaseMethods;

public class CRAClientSignup extends BaseMethods{
	
	public CRAClientSignup enterCompanyName(String companyName) {
		WebElement elecoName = locateElement("name", "companyName");
		clearAndType(elecoName, companyName);
		return this;
	}
	
	public CRAClientSignup enterCIN(String CIN) {
		WebElement elecin = locateElement("name", "cin");
		clearAndType(elecin, CIN);
		return this;
	}
	
	public CRAClientSignup enterContactName(String contactName) {
		WebElement eleContNm = locateElement("name", "contactPerson");
		clearAndType(eleContNm, contactName);
		return this;
	}
	
	public CRAClientSignup selectDesignation(String designation) {
		WebElement eleDsgn = locateElement("name", "designation");
		selectDropDownUsingText(eleDsgn, designation);
		return this;
	}
	
	public CRAClientSignup enterPhoneNumber(String phNumber) {
		WebElement elePhNum = locateElement("name", "contactNumber");
		clearAndType(elePhNum, phNumber);
		return this;
	}
	
	public CRAClientSignup enterEmail(String email) {
		WebElement eleEmail = locateElement("name", "contactEmail");
		clearAndType(eleEmail, email);
		return this;
	}
	
	public CRAClientSignup enterPromoterName(String promoterName) {
		WebElement eleProNm = locateElement("name", "promoters.0.name");
		clearAndType(eleProNm, promoterName);
		return this;
	}
	
	public CRAClientSignup enterPromoterExp(String promoterExp) {
		WebElement eleProExp = locateElement("name", "promoters.0.experience");
		clearAndType(eleProExp, promoterExp);
		return this;
	}
	
	public CRAClientSignup enterNoOfInstitutionalEquityInvestors(String Count) {
		WebElement eleInstInv = locateElement("name", "institutionalInvestors");
		clearAndType(eleInstInv, Count);
		return this;
	}
	
	public CRAClientSignup selectStatutoryAuditor(String auditorName) {
		WebElement eleStAud = locateElement("xpath", "//label[text()='Statutory auditor']/following::input[1]");
		typeAndTab(eleStAud, auditorName);
		return this;
	}
	
	public CRAClientSignup selectIndustry(String industryType) {
		WebElement eleInd = locateElement("name", "industry");
		selectDropDownUsingText(eleInd, industryType);
		return this;
	}
	
	public CRAClientSignup enterNatureOfBusiness(String nature) {
		WebElement elenatbus = locateElement("name", "natureOfBusiness");
		clearAndType(elenatbus, nature);
		return this;
	}
	
	public CRAClientSignup selectVintageOfOperations(String years) {
		WebElement elevintop = locateElement("name", "lendingVintage");
		selectDropDownUsingText(elevintop, years);
		return this;
	}
	
	public CRAClientSignup enterEBITDA(String current, String previous) {
		WebElement eleCurrebitda = locateElement("name", "financialPerformance.current.ebitda");
		clearAndType(eleCurrebitda, current);
		
		WebElement elePrevebitda = locateElement("name", "financialPerformance.previous.ebitda");
		clearAndType(elePrevebitda, previous);
		
		return this;
	}
	
	public CRAClientSignup enterRevenue(String current, String previous) {
		WebElement eleCurrrev = locateElement("name", "financialPerformance.current.revenue");
		clearAndType(eleCurrrev, current);
		
		WebElement elePrevrev = locateElement("name", "financialPerformance.previous.revenue");
		clearAndType(elePrevrev, previous);
		
		return this;
	}
	
	public CRAClientSignup enterNetWorth(String current, String previous) {
		WebElement eleCurrNW = locateElement("name", "financialPerformance.current.netWorth");
		clearAndType(eleCurrNW, current);
		
		WebElement elePrevNW = locateElement("name", "financialPerformance.previous.netWorth");
		clearAndType(elePrevNW, previous);
		
		return this;
	}
	
	public CRAClientSignup enterDebtOutstanding(String current, String previous) {
		WebElement eleCurrDebt = locateElement("name", "financialPerformance.current.debtOutstanding");
		clearAndType(eleCurrDebt, current);
		
		WebElement elePrevDebt = locateElement("name", "financialPerformance.previous.debtOutstanding");
		clearAndType(elePrevDebt, previous);
		
		return this;
	}
	
	public CRAClientSignup enterPAT(String current, String previous) {
		WebElement eleCurrPAT = locateElement("name", "financialPerformance.current.pat");
		clearAndType(eleCurrPAT, current);
		
		WebElement elePrevPAT = locateElement("name", "financialPerformance.previous.pat");
		clearAndType(elePrevPAT, previous);
		
		return this;
	}
	
	public CRAClientSignup selectProductInterested() {
		WebElement elePTC = locateElement("xpath", "//input[@value='PTC']");
		click(elePTC);
		
		WebElement eleTL = locateElement("xpath", "//input[@value='TL']");
		click(eleTL);
		
		return this;
	}
	
	public CRAClientSignup enterFundingRequirement(String amountInCrs) {
		WebElement elefundamt = locateElement("name", "investmentAmount");
		clearAndType(elefundamt, amountInCrs);
		return this;
	}
	
	public CRAClientSignup selectPartOfConglomerate(String response) {
		WebElement elepoc = locateElement("name", "partOfConglomerate");
		selectDropDownUsingText(elepoc, response);
		return this;
	}
	
	public CRAClientSignup enterConglomerateName(String name) {
		WebElement eleConNm = locateElement("name", "partOfConglomerateOther");
		clearAndType(eleConNm, name);
		return this;
	}
	
	public CRAClientSignup selectHowYouHearAboutUs(String channel) {
		WebElement eleSoi = locateElement("name", "sourceOfInformation");
		selectDropDownUsingText(eleSoi, channel);
		return this;
	}
	
	public CRAClientSignup agreeTermsAndConditions() {
		WebElement eleterms = locateElement("name", "termsAgreed");
		click(eleterms);
		return this;
	}
	
	public CRAClientSignup ClickSubmit() {
		WebElement elesub = locateElement("xpath", "//button[text()='Submit']");
		click(elesub);
		return this;
	}

}
