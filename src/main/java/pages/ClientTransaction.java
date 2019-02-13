package pages;

import org.openqa.selenium.WebElement;

import frameworkBasics.BaseMethods;

public class ClientTransaction extends BaseMethods{

	public InitiateTransaction clickInitiateTrans() {

		WebElement initTrans = locateElement("xpath", "//a[text()='Initiate Transaction']");
		click(initTrans); 
		return new InitiateTransaction();

	}

}
