package common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class MobileSupport {
	private WebDriverWait wait;
	private MobileDriver<MobileElement> driver;
	public static final int TIME_OUT_IN_SECONDS = 30;
	public static final int SLEEP_IN_MILLIS = 2000;
	public static final int COMMAND_WAITING_MILLIS = 3500;

	public MobileSupport(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60, 2);
	}
	
	public void clickOnXpath(String xpath) {
		MobileElement elm = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		wait.until(ExpectedConditions.elementToBeClickable(elm)).click();
	}
	
	public void sendKeyToXpath(String xpath, String keys) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		MobileElement elm = driver.findElementByXPath(xpath);
		elm.clear();
		elm.sendKeys(keys);
	
	}

	/*
	 * Author Phuong Doan
	 */
	public void waitForElementToDisappear(String xpath) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		} catch (TimeoutException timeout) {
			throw new TimeoutException("Time out when wait for invisible of " + xpath);
		}
	}
	
	public void waitForElementToAppear(String xpath) {
		try {
			//WebElement elem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (TimeoutException timeout) {
			throw new TimeoutException("Time out when wait for visible of " + xpath);
		}
	}
	
	public void shortWaitForElementToAppear(String xpath) {
		try {
			//WebElement elem = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			getWait(20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (TimeoutException timeout) {
			throw new TimeoutException("Time out when wait for visible of " + xpath);
		}
	}
	
	public void failIfElementNotDisplay(String... xpaths) {
		for (String xpath : xpaths) {
			if (!driver.findElement(By.xpath(xpath)).isDisplayed())
				throw new AssertionError("The element is not visible on screen. " + xpath);
		}	
	}
	
	
	public void failIfElementDisplay(String... xpaths) {
		for (String xpath : xpaths) {
			if (driver.findElement(By.xpath(xpath)).isDisplayed())
				throw new AssertionError("The element is visible on screen. " + xpath);
		}	
	}

	/*Author Phuong add date 2/20 */
	public void waitForElementWithText(String xpath, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), text));
		
	}
	
	public void pauseForNextCommand() {
		try {
			Thread.sleep(COMMAND_WAITING_MILLIS);
		} catch (InterruptedException e) {
		}
	}
	
	public String getTextByXpath (String xpath) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
	}
	/*end */
	
	/*
	 * * Author Quynh Lai
	 */
	public WebDriverWait getWait(int timeOutInSeconds) {
		return new WebDriverWait(driver, timeOutInSeconds, SLEEP_IN_MILLIS);
	}
	
	public boolean checkElementDisplay(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}
	
	public boolean waitAndCheckXpathDisplay(String xpath, int waitTime) {
		try {
			getWait(waitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}
	
}