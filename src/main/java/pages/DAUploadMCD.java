package pages;

import java.awt.AWTException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkBasics.BaseMethods;

public class DAUploadMCD extends BaseMethods{

	public DAUploadMCD clickBrowseToUploadMCD(String filePath) throws AWTException {
		WebElement mcdup = locateElement("xpath", "//h4[text()='Upload MCD File']/..//input");
		type(mcdup, filePath);
		return this;
	}
	
	public DAUploadRS clickProceed() {
		WebElement prcdbtn = locateElement("xpath", "//button[text()='Proceed']");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(prcdbtn));
		click(prcdbtn);
		return new DAUploadRS();
		}
}
