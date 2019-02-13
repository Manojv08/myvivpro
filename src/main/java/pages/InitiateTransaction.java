package pages;

import org.openqa.selenium.WebElement;

import frameworkBasics.BaseMethods;

public class InitiateTransaction extends BaseMethods{
	
	public InitiatePTC clickPTC() {
		WebElement PTC = locateElement("xpath", "//a[@href='/client/initiate/ptc']");
		click(PTC);
		return new InitiatePTC();
	}
	
	public InitiateDA clickDirectAssignment() {
		WebElement DA = locateElement("xpath", "//a[@href='/client/initiate/da']");
		click(DA);
		return new InitiateDA();
	}
	
	public InitiateTL clickTermLoan() {
		WebElement termloan = locateElement("xpath", "//a[@href='/client/initiate/tl']");
		click(termloan);
		return new InitiateTL();
	}
	
	public InitiateNCD clickNCD() {
		WebElement NCD = locateElement("xpath", "//a[@href='/client/initiate/ncd']");
		click(NCD);
		return new InitiateNCD();
	}
	
	public InitiatePS clickPreferenceShares() {
		WebElement PS = locateElement("xpath", "//a[@href='/client/initiate/ps']");
		click(PS);
		return new InitiatePS();
	}
	
	public InitiateCP clickCommercialPaper() {
		WebElement CP = locateElement("xpath", "//a[@href='/client/initiate/cp']");
		click(CP);
		return new InitiateCP();
	}

}