package frameworkBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utilities.DataReader;

public class ProjectSpecificWrapper extends BaseMethods{

	public static String username, password, dataWBookName, browser, url;

	@BeforeMethod
	public void login() throws InterruptedException, AWTException {

		startApp(browser, url);
		WebElement email = locateElement("name", "email");
		clearAndType(email, username);
		WebElement pswd = locateElement("name", "password");
		clearAndType(pswd, password);
		WebElement submit = locateElement("xpath", "//button[@type='submit']");
		click(submit);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains("otp"));

		String currentUrl = driver.getCurrentUrl();

		if(currentUrl.contains("otp")) {

			String otpcd = "9";

			List<WebElement> otpboxes = locateElements("xpath", "//div[@class='otp']//input");
			
			for(WebElement otpbox : otpboxes) {
				type(otpbox, otpcd);
			}

			WebElement verifyotp = locateElement("xpath", "//button[text()='Verify']");
			click(verifyotp);
		}

	}

	public String getOTP() throws AWTException {

		Robot robot = new Robot();

		robot.setAutoDelay(2000);

		//Copy the url and keep it in the system clip board
		StringSelection ss = new StringSelection("http://www.yopmail.com/en/");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		switchToWindow(1);

		WebElement sbemal = locateElement("id", "login");
		clearAndType(sbemal, "vivriti_sandbox");
		WebElement chkibox = locateElement("xpath", "//input[@value='Check Inbox']");
		click(chkibox);

		//Enter into the frame to interact with email body
		WebElement yopfrm = locateElement("id", "ifmail");
		switchToFrame(yopfrm);

		//read OTP text
		WebElement otpread = locateElement("class", "act-it");

		String otp = getText(otpread);

		switchToDefaultContent();

		switchToWindow(0);

		return otp;
	}

	@AfterMethod
	public void logout() {

		WebElement userprofile = locateElement("class", "hub-contact");
		click(userprofile);
		WebElement logoutbtn = locateElement("linktext", "Logout");
		click(logoutbtn);
		closeBrowser();

	}

	@DataProvider(name="fetchData")
	public String[][] getData() {
		return DataReader.readData(dataWBookName);
	}

}
