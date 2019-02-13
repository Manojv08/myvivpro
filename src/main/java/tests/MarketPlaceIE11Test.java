package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkBasics.ProjectSpecificWrapper;

public class MarketPlaceIE11Test extends ProjectSpecificWrapper {

	@BeforeClass
	public void setData() {

		browser = "ie32";
		url = "https://mp-staging.vivriti.in/login";
		username = "product_admin@vivriticapital.com";
		password = "Think@123";
		testCaseName = "MP IE testing";
		testCaseDescription = "MP Staging Login";
		author = "Manoj";
		category = "Sanity";
	}

	@Test
	public void MPIETesting() {


	}

}
