package pages;

import java.awt.AWTException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkBasics.BaseMethods;

public class DAUploadRS extends BaseMethods{

	public DAUploadRS clickBrowseToUploadRS(String filePath) throws AWTException {
		WebElement rsup = locateElement("xpath", "//h4[text()='Upload RS File']/..//input");
		type(rsup, filePath);
		return this;
	}
	
	public DASuccess clickProceed() {
		WebElement prcdbtn = locateElement("xpath", "//button[text()='Proceed']");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(prcdbtn));
		click(prcdbtn);
		return new DASuccess();
	}
}