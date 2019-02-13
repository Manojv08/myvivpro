package utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class HtmlReporter {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static String testCaseName, testCaseDescription, author, category;

	@BeforeSuite
	public void startResult() {
		ExtentHtmlReporter html = new ExtentHtmlReporter
				("./reports/AutomationReport.html");
		html.setAppendExisting(false);
		html.config().setDocumentTitle("Mp Automation");
		html.config().setReportName("Mp Automation Report");
		// To hide the chart when opening the report set the Chart visibility to false
		html.config().setChartVisibilityOnOpen(false);
		//		html.config().setTestViewChartLocation(ChartLocation.TOP);
		html.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(html);
		extent.setReportUsesManualConfiguration(true);
	}

	@BeforeMethod
	public void startTestCase() {
		test = extent.createTest(testCaseName, testCaseDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
	}

	public void reportStep(String desc,String status) {
		if (status.equalsIgnoreCase("pass")) {
			test.pass(desc);
		}if (status.equalsIgnoreCase("fail")) {
			test.fail(desc);
		}
	}

	@AfterSuite
	public void stopResult(){		
		extent.flush();
	}

}