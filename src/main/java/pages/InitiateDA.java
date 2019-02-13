package pages;

import org.openqa.selenium.WebElement;
import frameworkBasics.BaseMethods;

public class InitiateDA extends BaseMethods{
	
	public InitiateDA selectPoolType(String poolType) {
		WebElement pltyp = locateElement("xpath", "//label[text()='POOL TYPE']/following::input[1]");
		typeAndTab(pltyp, poolType);
		return this;
	}
	
	public InitiateDA enterTentativeAmount(String amountInCrores) {
		WebElement tentamt = locateElement("xpath", "//label[text()='TENTATIVE AMOUNT']/following::input[1]");
		clearAndType(tentamt, amountInCrores);
		return this;
	}
	
	public InitiateDA selectTentativeSettlementDate(String date) {
		WebElement tentdate = locateElement("xpath", "//label[text()='TENTATIVE SETTLEMENT DATE']/following::input[1]");
		typeAndTab(tentdate, date);
		return this;		
	}
	
	public InitiateDA enterTentativePricing(String percent) {
		WebElement tentprice = locateElement("xpath", "//label[text()='TENTATIVE PRICING']/following::input[1]");
		clearAndType(tentprice, percent);
		return this;
	}
	
	public InitiateDA selectAssigneeRepresentative(String assigneeRep) throws InterruptedException {
		WebElement asgnrep = locateElement("xpath", "//label[text()='ASSIGNEE REPRESENTATIVE (OPTIONAL)']/following::input[1]");
		typeWaitAndTab(asgnrep, assigneeRep);
		return this;
	}
	
	public InitiateDA selectCreditRatingAgency(String agencyName) throws InterruptedException {
		WebElement crrtagncy = locateElement("xpath", "//label[text()='Credit Rating Agency']/following::input[1]");
		typeWaitAndTab(crrtagncy, agencyName);
		return this;
	}
	
	public InitiateDA selectLawFirm(String firmName) throws InterruptedException {
		WebElement lawfrm = locateElement("xpath", "//label[text()='Law Firm']/following::input[1]");
		typeWaitAndTab(lawfrm, firmName);
		return this;
	}
	
	public InitiateDA selectAuditor(String auditorName) throws InterruptedException {
		WebElement audname = locateElement("xpath", "//label[text()='Auditor']/following::input[1]");
		typeWaitAndTab(audname, auditorName);
		return this;
	}
	
	/**
	 * Please call the "selectPreferencePriority" methods in a ordered manner from 1, 2 & 3 when using in test scripts.
	 * 
	 * @param pref1 - First Preference for priority considerations
	 */
	public InitiateDA selectPreferencePriority1(String pref1) {
		WebElement prefpr1 = locateElement("xpath", "//label[text()='Preference Priorty']/following::input[1]");
		typeAndTab(prefpr1, pref1);
		return this;
	}

	/**
	 * Please call the "selectPreferencePriority" methods in a ordered manner from 1, 2 & 3 when using in test scripts.
	 * 
	 * @param pref2 - Second Preference or priority considerations
	 */
	public InitiateDA selectPreferencePriority2(String pref2) {
		WebElement prefpr2 = locateElement("xpath", "//label[text()='Preference Priorty']/following::input[3]");
		typeAndTab(prefpr2, pref2);
		return this;
	}
	
	/**
	 * Please call the "selectPreferencePriority" methods in a ordered manner from 1, 2 & 3 when using in test scripts.
	 * 
	 * @param pref3 - Third Preference for priority considerations
	 */
	public InitiateDA selectPreferencePriority3(String pref3) {
		WebElement prefpr3 = locateElement("xpath", "//label[text()='Preference Priorty']/following::input[5]");
		typeAndTab(prefpr3, pref3);
		return this;
	}
	
	public DAUploadMCD clickProceed() {
		WebElement prcdbtn = locateElement("xpath", "//button[text()='Proceed']");
		click(prcdbtn);
		return new DAUploadMCD();
	}
	
}