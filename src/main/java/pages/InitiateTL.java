package pages;

import org.openqa.selenium.WebElement;
import frameworkBasics.BaseMethods;

public class InitiateTL extends BaseMethods {
	
	public InitiateTL enterFacilityLimit(String amtInCrores) {
		WebElement faclmt = locateElement("name", "facilityLimit");
		clearAndType(faclmt, amtInCrores);
		return this;
	}
	
	public InitiateTL selectAssetClass(String asset) {
		WebElement astcls = locateElement("xpath", "//label[text()='ASSET CLASS']/following::input[1]");
		typeAndTab(astcls, asset);
		return this;
	}
	
	public InitiateTL selectTenor(String years, String months, String days) {
		WebElement yrs = locateElement("xpath", "//label[text()='Tenor']/following::input[2]");
		typeAndTab(yrs, years);
		WebElement mnths = locateElement("xpath", "//div[text()='Years']/following::input[2]");
		typeAndTab(mnths, months);
		WebElement dys = locateElement("xpath", "//div[text()='Months']/following::input[2]");
		typeAndTab(dys, days);
		return this;
	}
	
	public InitiateTL selectAvailabilityPeriod(String mnths) {
		WebElement avlprd = locateElement("xpath", "//label[text()='AVAILABILITY PERIOD']/following::input[1]");
		typeAndTab(avlprd, mnths);
		return this;
	}
	
	public InitiateTL selectPreferredDisbursementDate(String date) {
		WebElement prfrddt = locateElement("xpath", "//label[text()='PREFERRED DISBURSEMENT DATE']/following::input[1]");
		typeAndTab(prfrddt, date);
		return this;
	}
	
	/**
	 * Call the methods "enterTrancheAmount" and "enterDeferralMonths" 
	 * only if the response parameter to the "selectTrancheDisbursement" method is Yes.
	 * 
	 * @param response - Either "Yes" or "No"
	 */
	public InitiateTL selectTrancheDisbursement(String response) {
		WebElement lblYes = locateElement("xpath", "//label[text()='Tranche Disbursement']/following::label[text()='"+response+"']");
		click(lblYes);
		return this;
	}
	
	public InitiateTL enterTrancheAmount(String trancheamt) {
		WebElement trnchamt = locateElement("xpath", "//label[text()='TRANCHE AMOUNT']/following::input[1]");
		clearAndType(trnchamt, trancheamt);
		return this;
	}
	
	public InitiateTL enterDeferralMonths(String mnths) {
		WebElement defmnth = locateElement("xpath", "//label[text()='DEFERRAL MONTHS']/following::input[1]");
		clearAndType(defmnth, mnths);
		return this;
	}
	
	public InitiateTL selectPrincipalRepayFreq(String repayfreq) {
		WebElement rpayfrq = locateElement("xpath", "//label[text()='PRINCIPAL REPAYMENT FREQUENCY']/following::input[1]");
		typeAndTab(rpayfrq, repayfreq);
		return this;
	}
	
	public InitiateTL selectInterestRepayFreq(String repayfreq) {
		WebElement rpayfrq = locateElement("xpath", "//label[text()='INTEREST REPAYMENT FREQUENCY']/following::input[1]");
		typeAndTab(rpayfrq, repayfreq);
		return this;
	}
	
	public InitiateTL selectRepaymentType(String repayType) {
		WebElement rpaytyp = locateElement("xpath", "//label[text()='REPAYMENT TYPE']/following::input[1]");
		typeAndTab(rpaytyp, repayType);
		return this;
	}
	
	/**
	 * Call the method "selectMoratoriumPeriod"
	 * only if the response parameter to the "selectPrincipalMoratorium" method is Yes.
	 * 
	 * @param response - Either "Yes" or "No"
	 */
	public InitiateTL selectPrincipalMoratorium(String response) {
		WebElement prmrt = locateElement("xpath", "//label[text()='Principal Moratorium']/following::label[text()='"+response+"']");
		click(prmrt);
		return this;
	}
	
	public InitiateTL selectMoratoriumPeriod(String periodInMonths) {
		WebElement mrtprd = locateElement("xpath", "//label[text()='PERIOD']/following::input[1]");
		typeAndTab(mrtprd, periodInMonths);
		return this;
	}
	
	/**
	 * Select the protection type which is optional.
	 * 
	 * @param protectionType - valid values are listed here for this parameter...
	 * SECURITY,
	 * CASH COLLATERAL,
	 * Corporate Guarantee,
	 * Promoter Guarantee
	 * 
	 */
	public InitiateTL selectProtection(String protectionType) {
		WebElement protcttype = locateElement("xpath", "//label[text()='Protection ']/following::label[text()='"+protectionType+"']");
		click(protcttype);
		return this;
	}
	
	public TLSuccess clickProceed() {
		WebElement prcdbtn = locateElement("xpath", "//button[text()='Proceed']");
		click(prcdbtn);
		return new TLSuccess();
	}
	
}