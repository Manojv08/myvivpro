package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkBasics.BaseMethods;

public class ForgotPassword extends BaseMethods{

	@BeforeClass
	public void setData() {

		testCaseName = "Forgot Password";
		testCaseDescription = "Reset password flow";
		author = "Manoj";
		category = "Sanity";
		
	}

	@Test
	public void exeForgotPassword() throws AWTException {
		
		String emailToReset = "vistra@vivriticapital.com";
		
		String pswdToReset = "Think@123";

		startApp("chrome", "https://mp-qa.vivriti.in/login");

		WebElement frgtpswd = locateElement("linktext", "Forgot Password?");
		click(frgtpswd);

		WebElement entemal = locateElement("name", "email");
		clearAndType(entemal, emailToReset);

		WebElement subbtn = locateElement("xpath", "//button[text()='Submit']");
		click(subbtn);

		WebElement resultele = locateElement("class", "text-center");
		getText(resultele);
		
		resetFromYop(pswdToReset);
		
		loginAfterReset(emailToReset, pswdToReset);
		
		logoutAfterReset();

	}
	
	public void resetFromYop(String pswdToReset) throws AWTException {
		
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
		
		WebElement elereset = locateElement("xpath", "//a[text()=' Reset your password ']");
		click(elereset);
		
		switchToDefaultContent();
		
		switchToWindow(2);
		
		WebElement pswd = locateElement("name", "password");
		clearAndType(pswd, pswdToReset);
		
		WebElement cnfrmPswd = locateElement("name", "confirmPassword");
		clearAndType(cnfrmPswd, pswdToReset);
		
		WebElement chgbtn = locateElement("xpath", "//button[@type='submit']");
		click(chgbtn);
		
	}
	
	public void loginAfterReset(String emailrst, String pswdrst) {
		
		WebElement email = locateElement("name", "email");
		clearAndType(email, emailrst);
		WebElement pswd = locateElement("name", "password");
		clearAndType(pswd, pswdrst);
		WebElement submit = locateElement("xpath", "//button[@type='submit']");
		click(submit);
		
	}
	
	public void logoutAfterReset() {

		WebElement userprofile = locateElement("class", "hub-contact");
		click(userprofile);
		WebElement logoutbtn = locateElement("linktext", "Logout");
		click(logoutbtn);
		closeAllBrowsers();

	}

}