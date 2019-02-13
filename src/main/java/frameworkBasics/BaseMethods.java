package frameworkBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.HtmlReporter;

public class BaseMethods extends HtmlReporter implements BaseMethodsInt{

	public int i = 1;
	public static RemoteWebDriver driver;
	public static ChromeOptions op;
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				op = new ChromeOptions();
				op.addArguments("--disable-notifications");
				driver = new ChromeDriver(op);
			} else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("ie64")){
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe");
				driver = new InternetExplorerDriver();
			} else if(browser.equalsIgnoreCase("ie32")){
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe");
				
				DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
				cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				
				InternetExplorerOptions opt = new InternetExplorerOptions();
				opt.merge(cap);
				
				driver = new InternetExplorerDriver(opt);
			} else if(browser.equalsIgnoreCase("edge")){
				System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			} else if(browser.equalsIgnoreCase("opera")){
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver.exe");
				driver = new OperaDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportStep("The Browser "+browser+" Launched Successfully", "pass");
		} catch (WebDriverException e) {
			reportStep("The Browser "+browser+" not Launched", "fail");
		} catch (Exception e) {
			reportStep("The Browser "+browser+" not Launched successfully", "fail");
		}
		finally {
			 takeSnap(); 
		}

	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			locator = locator.toLowerCase();
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "name" : return driver.findElementByName(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "linktext" : return driver.findElementByLinkText(locValue);
			case "partialLink" : return driver.findElementByPartialLinkText(locValue);
			case "css" : return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element is not found", "fail");
		} catch (Exception e) {
			reportStep("Unknow Exception: "+ e.getMessage(), "fail");
		}
		return null;
	}
		

	public List<WebElement> locateElements(String locator, String locValue) {
		try {
			locator = locator.toLowerCase();
			switch(locator) {
			case "id"	 : return driver.findElementsById(locValue);
			case "name" : return driver.findElementsByName(locValue);
			case "class" : return driver.findElementsByClassName(locValue);
			case "tagname" : return driver.findElementsByTagName(locValue);
			case "xpath" : return driver.findElementsByXPath(locValue);
			case "linktext" : return driver.findElementsByLinkText(locValue);
			case "partialLink" : return driver.findElementsByPartialLinkText(locValue);
			case "css" : return driver.findElementsByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The Elements are not found", "fail");
		} catch (Exception e) {
			reportStep("Unknow Exception ", "fail");
		}
		return null;
	}
	
	public WebElement locateElement(String locValue) {
		try {
			return driver.findElementById(locValue);
		} catch (NoSuchElementException e) {
			reportStep("The Element is not found", "fail");
		} catch (Exception e) {
			reportStep("Unknow Exception ", "fail");
		}
		return null;
	}

	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data "+data+" is Entered Successfully", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele+" as the element not present in DOM","fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}
	
	public void typeAndTab(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data,Keys.TAB);
			reportStep("The data "+data+" is Entered Successfully", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele+" as the element not present in DOM","fail");
		}
		catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}
	
	public void typeWaitAndTab(WebElement ele, String data) throws InterruptedException {
		try {
			ele.clear();
			ele.sendKeys(data);
		    Thread.sleep(10000);
			ele.sendKeys(Keys.TAB);
			reportStep("The data "+data+" is Entered Successfully", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele+" as the element not present in DOM","fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportStep("The data "+data+" is Entered Successfully", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (StaleElementReferenceException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele+" as the element not present in DOM","fail");
		}
		catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}
	
	public void clickWithNoSnap(WebElement ele) {
		String text = null;
		try {
			text = ele.getText();
			ele.click();
			reportStep("The Element "+text+" Clicked Successfully", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The Element: "+text+" could not be clicked", "fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","fail");
		} 
	}

	public void click(WebElement ele) {
		String text = null;
		try {
			text = ele.getText();
			ele.click();
			reportStep("The Element "+text+" Clicked Successfully", "pass");
		} catch (NullPointerException e) {
			ele.click();
			reportStep("The Element "+ele+" not found Successfully", "fail");
		} catch (InvalidElementStateException e) {
			reportStep("The Element: "+text+" could not be clicked", "fail");
		} catch (Exception e) {
			reportStep("Unknown exception occured while clicking in the field :" + ele, "fail");
		} 
		finally {
			takeSnap();
		}
	}

	public String getText(WebElement ele) {
		String text = null;
		try {
			text = ele.getText();
			reportStep("Retrieved text is: "+text+".", "pass");
		} catch (NoSuchElementException e) {
			reportStep("Element" + ele + " not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
		return text;
	}
	
	public String getTitle() {		
		String text = null;
		try {
			text =  driver.getTitle();
		} catch (Exception e) {
			reportStep("Unknown Exception Occured While fetching Title", "fail");
		} 
		return text;
	}
	
	public String getAttribute(WebElement ele, String attribute) {		
		String text = null;
		try {
			text =  ele.getAttribute(attribute);
		} catch (Exception e) {
			reportStep("The attribute: "+attribute+" is not found for the element: "+ele+" could not be found.", "fail");
		}
		return text;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByVisibleText(value);
			reportStep("The DropDown is Selected with VisibleText: "+value, "pass");
		} catch (Exception e) {
			reportStep("The DropDown is not Selected with VisibleText: "+value, "fail");
		} finally {
			takeSnap();
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dd = new Select(ele);
			dd.selectByIndex(index);
			reportStep("The DropDown is Selected with index "+ index, "pass");
		} catch (Exception e) {
			reportStep("The DropDown is not Selected with index "+ index, "fail");
		} finally {
			takeSnap();
		}
	}
	
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByValue(value);
			reportStep("The DropDown is Selected with value "+ value, "pass");
		} catch (Exception e) {
			reportStep("The DropDown is not Selected with value "+ value, "fail");
		} finally {
			takeSnap();
		}
	}

	public void verifyTitle(String expectedTitle) {
		String title = getTitle();
		try {
			if(title.equals(expectedTitle))
			{
				reportStep("Current Page Title: "+title+" And expected title: "+expectedTitle+" matches exactly", "pass");
			}else {
				reportStep("Current Page Title: "+title+" And expected title: "+expectedTitle+ " doesn't matches", "fail");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "fail");
		}
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		String text = getText(ele);
		try {
			boolean check = text.equals(expectedText);
			if(check) {
				reportStep("The text: "+text+" matches with the value :"+expectedText,"pass");
			}else {
				reportStep("The text "+text+" doesn't matches the actual value "+expectedText,"fail");
			}
		} catch(Exception e) {
			reportStep("Unknown Exception occured while verifying the Exact text", "fail");
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		String text = getText(ele);
		try {
			boolean check = text.contains(expectedText);
			if(check) {
				reportStep("The expected text contains the actual "+expectedText,"pass");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"fail");
			}
		} catch(Exception e) {
			reportStep("Unknown exception occured while verifying the Partial Text", "fail");
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributevalue = getAttribute(ele, attribute);
			boolean check = attributevalue.equals(value);
			if(check) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"fail");
			}
		} catch(Exception e) {
			reportStep("Unknown exception occured while verifying the Attribute Text/Value", "fail");
		}
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributevalue = getAttribute(ele, attribute);
			boolean check = attributevalue.contains(value);
			if(check) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
			}
		} catch(Exception e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "fail");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			boolean selected = ele.isSelected();
			if(selected)
			{
				reportStep("Element " + ele + " is selected", "pass");
			}else {
				reportStep("Element " + ele + " is not selected", "pass");
			}
		} catch(Exception e) {
			reportStep("Unknown Exception found" + e.getMessage(), "fail");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			boolean displayed = ele.isDisplayed();
			if(displayed)
			{
				reportStep("Element " + ele + " is displayed", "pass");
			}else {
				reportStep("Element " + ele + " is not displayed", "pass");
			}
		} catch(Exception e) {
			reportStep("Unknown Exception found" + e.getMessage(), "fail");
		}
	}

	public void switchToWindow(int index) {
		try {
			Set<String> winset = driver.getWindowHandles();
			List<String> winlist = new ArrayList<String>();
			winlist.addAll(winset);
			driver.switchTo().window(winlist.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index, "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+e.getMessage(), "fail");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("switched in to the Frame by webelement "+ele, "pass");
		} catch (NoSuchFrameException e) {
			reportStep("Frame not found on the page " + e.getMessage(), "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+ e.getMessage(), "fail");
		}
	}
	
	public void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
			reportStep("switched in to the Frame by using index "+index, "pass");
		} catch (NoSuchFrameException e) {
			reportStep("Frame not found on the page " + e.getMessage(), "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+ e.getMessage(), "fail");
		}
	}
	
	public void switchToFrame(String locvalue) {
		try {
			driver.switchTo().frame(locvalue);
			reportStep("switched in to the Frame by using id or name "+locvalue, "pass");
		} catch (NoSuchFrameException e) {
			reportStep("Frame not found on the page " + e.getMessage(), "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+ e.getMessage(), "fail");
		}
	}
	
	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			reportStep("switched out of all the Frames and returned back to the main content", "pass");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+ e.getMessage(), "fail");
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.", "pass");
		} catch (NoAlertPresentException e) {
			reportStep("Alert not found on the page", "fail");
		} catch(UnhandledAlertException e) {
			reportStep("Alert is not handled properly", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+ e.getMessage(), "fail");
		}
	}

	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.", "pass");
		} catch (NoAlertPresentException e) {
			reportStep("Alert not found on the page", "fail");
		} catch(UnhandledAlertException e) {
			reportStep("Alert is not handled properly", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+ e.getMessage(), "fail");
		}
	}

	public String getAlertText() {
		String text = null;
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("Alert not found on the page", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found "+ e.getMessage(), "fail");
		}
		return text;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			reportStep("IOException", "fail");
		}
		i++;
	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","pass");
		} catch (Exception e) {
			reportStep("The browser could not be closed "+ e.getMessage(),"fail");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("All opened browsers are closed","pass");
		} catch (Exception e) {
			reportStep("Unexpected error occured in closing the browser "+ e.getMessage(),"fail");
		}
	}
	
	public void uploadFile(String pathOfFile) throws AWTException {
		
		try {
			Robot rbt = new Robot();
			
			StringSelection ss = new StringSelection(pathOfFile);
			
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			rbt.setAutoDelay(2000);
			
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_V);
			
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			
			reportStep("File from the path : "+pathOfFile+" has been uploaded successfully", "pass");
		} catch (AWTException e) {
			reportStep("File from the path: "+pathOfFile+" has not been uploaded successfully", "fail");
//			e.printStackTrace();
		}
	}
	
	public void checkBrokenLink(WebElement ele) {
		try {
			String url = getAttribute(ele, "href"); 
			verifyLinkActive(url);
		} catch (Exception e) {
			reportStep("Specific link might not be a real link that routes to a web page", "fail");
		}
	}
	
	public void checkBrokenLinksInPage() {
		
		List<WebElement> allLinks = locateElements("tagname", "a");
		reportStep("No.of.links in this page is: "+allLinks.size()+".", "pass");

		for(int i=0;i<allLinks.size();i++)
		{
			WebElement ele= allLinks.get(i);

			String url= getAttribute(ele, "href");

			verifyLinkActive(url);
		}
	}
	
	public void verifyLinkActive(String linkUrl)
	{
		try 
		{
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if(httpURLConnect.getResponseCode()==200)
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage(), "pass");
			}
			if(httpURLConnect.getResponseCode()==201)  
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage()+" - "+ HttpURLConnection.HTTP_CREATED, "pass");
			}
			if(httpURLConnect.getResponseCode()==202)  
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_ACCEPTED, "pass");
			}
			if(httpURLConnect.getResponseCode()==400)  
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_BAD_REQUEST, "fail");
			}
			if(httpURLConnect.getResponseCode()==401)  
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_UNAUTHORIZED, "fail");
			}
			if(httpURLConnect.getResponseCode()==402)  
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_PAYMENT_REQUIRED, "fail");
			}
			if(httpURLConnect.getResponseCode()==403)  
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_FORBIDDEN, "fail");
			}
			if(httpURLConnect.getResponseCode()==404)  
			{
				reportStep(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND, "fail");
			}
		} catch (Exception e) {
			reportStep(e.getMessage(), "pass");
		}

	}

}