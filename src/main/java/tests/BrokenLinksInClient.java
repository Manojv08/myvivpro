package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameworkBasics.ProjectSpecificWrapper;

public class BrokenLinksInClient extends ProjectSpecificWrapper{
	
	@BeforeClass
	public void setData() {

		browser = "chrome";
		url = "https://mp-staging.vivriti.in/login";
		username = "laxmi@vivriticapital.com";
		password = "Test@123";
		testCaseName = "Client Transaction page";
		testCaseDescription = "Check for any Broken links in the page";
		author = "Manoj";
		category = "Sanity";
	}
	
	@Test
	public void CheckBrokenLinksInClientTransaction() throws InterruptedException {
		
		WebElement eleSetDeals = locateElement("xpath", "//a[text()='Settled Deals']");
		click(eleSetDeals);

		Thread.sleep(2000);

		WebElement eleFirstTrans = locateElement("xpath", "(//li[@class='tr-cname'])[2]/div/span");
		click(eleFirstTrans);

		WebElement eleInvestorTab = locateElement("xpath", "//span[text()='investor']");
		click(eleInvestorTab);
		
		checkBrokenLinksInPage();
	}

}
