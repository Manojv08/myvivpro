package pages;

import java.awt.AWTException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkBasics.BaseMethods;

public class InitiatePTC extends BaseMethods {
	
	public InitiatePTC selectPoolType(String poolType) {
		WebElement pltyp = locateElement("xpath", "//label[text()='Pool Type']/following::input[1]");
		typeAndTab(pltyp, poolType);
		return this;
	}
	
	public InitiatePTC clickBrowseToUploadMCD(String filePath) throws AWTException {
		WebElement mcdup = locateElement("xpath", "//h4[text()='Upload MCD File']/..//input");
		type(mcdup, filePath);
		return this;
	}
	
	public InitiatePTC clickBrowseToUploadRS(String filePath) throws AWTException {
		WebElement rsup = locateElement("xpath", "//h4[text()='Upload RS File']/..//input");
		type(rsup, filePath);
		return this;
	}
	
	public InitiatePTC clickProceed() {
		WebElement prcdbtn = locateElement("xpath", "//button[text()='Proceed']");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(prcdbtn));
		click(prcdbtn);
		return this;
	}
	
	public InitiatePTC selectPoolCutOffDate(String cutOffDate) {
		WebElement plctoff = locateElement("xpath", "//label[text()='Pool Cut Off Date']/following::input[1]");
		typeAndTab(plctoff, cutOffDate);
		return this;
	}
	
	public InitiatePTC enterPricing(String percent) {
		WebElement pricing = locateElement("xpath", "//label[text()='Pricing']/following::input[1]");
		clearAndType(pricing, percent);
		return this;
	}
	
	public InitiatePTC selectCEPreference(String cePref) {
		WebElement cepref = locateElement("xpath", "//label[text()='CE Preference']/following::input[1]");
		typeAndTab(cepref, cePref);
		return this;
	}
	
	public InitiatePTC selectPrefSettlementDate(String settlementDate) {
		WebElement prstdt = locateElement("xpath", "//label[text()='Preferred Settlement Date']/following::input[1]");
		typeAndTab(prstdt, settlementDate);
		return this;
	}
	
	/**
	 * Please call the "selectPriority#" methods in a ordered manner from 1, 2 & 3 when using in test scripts.
	 * 
	 * @param pref1 - First Preference for priority considerations
	 */
	public InitiatePTC selectPriority1(String pref1) {
		WebElement prefpr1 = locateElement("xpath", "//label[text()='Priority']/following::input[1]");
		typeAndTab(prefpr1, pref1);
		return this;
	}

	/**
	 * Please call the "selectPriority#" methods in a ordered manner from 1, 2 & 3 when using in test scripts.
	 * 
	 * @param pref2 - Second Preference or priority considerations
	 */
	public InitiatePTC selectPriority2(String pref2) {
		WebElement prefpr2 = locateElement("xpath", "//label[text()='Priority']/following::input[3]");
		typeAndTab(prefpr2, pref2);
		return this;
	}
	
	/**
	 * Please call the "selectPriority#" methods in a ordered manner from 1, 2 & 3 when using in test scripts.
	 * 
	 * @param pref3 - Third Preference for priority considerations
	 */
	public InitiatePTC selectPriority3(String pref3) {
		WebElement prefpr3 = locateElement("xpath", "//label[text()='Priority']/following::input[5]");
		typeAndTab(prefpr3, pref3);
		return this;
	}
	
	public PTCSuccess clickFinalProceed() {
		WebElement prcdbtn = locateElement("xpath", "//button[text()='Proceed']");
		click(prcdbtn);
		return new PTCSuccess();
	}
	
}