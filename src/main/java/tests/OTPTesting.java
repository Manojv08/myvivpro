package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkBasics.BaseMethods;

public class OTPTesting extends BaseMethods{

	@BeforeClass
	public void setData() {

		testCaseName = "MFA OTP testing";
		testCaseDescription = "Authorization from Sandbox OTP";
		author = "Manoj";
		category = "Sanity";
	}

	@Test
	public void login() throws InterruptedException, AWTException {

		startApp("chrome", "https://mp-staging.vivriti.in/login");
		WebElement email = locateElement("name", "email");
		clearAndType(email, "product_admin@vivriticapital.com");
		WebElement pswd = locateElement("name", "password");
		clearAndType(pswd, "Think@123");
		WebElement submit = locateElement("xpath", "//button[@type='submit']");
		click(submit);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains("otp"));

		String currentUrl = driver.getCurrentUrl();

		if(currentUrl.contains("otp")) {

			String otpcd = getOTP();

			WebElement otpbox = locateElement("xpath", "//div[@class='otp']/div/div[1]/input");
			type(otpbox, otpcd);
			WebElement verifyotp = locateElement("xpath", "//button[text()='Verify']");
			click(verifyotp);

		}
		
		WebElement userprofile = locateElement("class", "hub-contact");
		click(userprofile);
		WebElement logoutbtn = locateElement("linktext", "Logout");
		click(logoutbtn);
		
		closeAllBrowsers();

	}

	public String getOTP() throws AWTException {

		Robot robot = new Robot();

		robot.setAutoDelay(2000);

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

		WebElement yopfrm = locateElement("id", "ifmail");
		switchToFrame(yopfrm);

		WebElement otpread = locateElement("class", "act-it");

		String otp = getText(otpread);

		switchToDefaultContent();

		switchToWindow(0);

		return otp;
	}

}
