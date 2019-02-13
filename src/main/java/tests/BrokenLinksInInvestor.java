package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkBasics.ProjectSpecificWrapper;

public class BrokenLinksInInvestor extends ProjectSpecificWrapper{
	
	@BeforeClass
	public void setData() {

		browser = "chrome";
		url = "https://mp-staging.vivriti.in/login";
		username = "dcb@vivriticapital.com";
		password = "Test@123";
		testCaseName = "Investor Transaction page";
		testCaseDescription = "Check for any Broken links in the page";
		author = "Manoj";
		category = "Sanity";
	}
	
	@Test
	public void CheckBrokenLinksInInvestorTransaction() throws InterruptedException {
		
		WebElement eleLiveDeals = locateElement("xpath", "//a[text()='Live Deals']");
		click(eleLiveDeals);
		
		Thread.sleep(2000);
		
		WebElement eleFirstTrans = locateElement("xpath", "(//li[@class='tr-cname'])[2]/div");
		click(eleFirstTrans);
		
		Thread.sleep(1000);
		
		checkBrokenLinksInPage();
		
	}

}
