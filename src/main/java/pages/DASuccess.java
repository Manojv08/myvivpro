package pages;

import org.openqa.selenium.WebElement;

import frameworkBasics.BaseMethods;

public class DASuccess extends BaseMethods{
	
	public DASuccess getDealName() {
		WebElement dealele = locateElement("xpath", "//div[@class='initiate-success']/p/a");
		String dealnm = getText(dealele);
		String trnsid = driver.getCurrentUrl();
		reportStep("Deal name for the created Term Loan transaction is "+dealnm+" with transaction id: "+trnsid, "pass");
		return this;
	}
	
	public DASuccess clickDone() {
		WebElement donebtn = locateElement("xpath", "//div[@class='initiate-success']/div/a");
		click(donebtn);
		return this;
	}

}