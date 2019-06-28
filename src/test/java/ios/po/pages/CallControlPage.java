package ios.po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import common.MobileSupport;
import core.Log;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import ios.po.selectors.CallControlSelector;

/**
 * @author Quynh Lai
 * 
 */
public class CallControlPage {
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	private static String className = CallControlPage.class.getName();
	
	public CallControlPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
	}
	
	/** Methods for single call
	 * 
	 */
	public void waitForIncomingCall() {
		Log.logger.info(String.format("%s: Waiting the incoming call", className));
		try {
			mobileSupport.getWait(60).until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id("Accept")),
				ExpectedConditions.visibilityOfElementLocated(By.id("Hold & Accept"))));
		}catch (TimeoutException timeout) {
			throw new TimeoutException("No have any incoming call");		
		}
	}
	
	public void acceptIncomingCall() {
		Log.logger.info(String.format("%s: Accept the incoming call", className));
		driver.findElement(By.id("Accept")).click();
	}
	
	public void pressTransferButton() {
		Log.logger.info(String.format("%s: Press transfer button", className));
		mobileSupport.clickOnXpath(CallControlSelector.transfer_call_button);
	}
	
	public void pressHoldButton () {
		Log.logger.info(String.format("%s: Press hold button", className));
		mobileSupport.clickOnXpath(CallControlSelector.hold_call_button);
	}
	
	public void pressSpeakerButton () {
		Log.logger.info(String.format("%s: Press speaker button", className));
		mobileSupport.clickOnXpath(CallControlSelector.speaker_button);
	}
	
	public void pressKeypadButton () {
		Log.logger.info(String.format("%s: Press keypad button", className));
		mobileSupport.clickOnXpath(CallControlSelector.keypad_button);
	}

	public void pressMuteButton () {
		Log.logger.info(String.format("%s: Press mute button", className));
		mobileSupport.clickOnXpath(CallControlSelector.mute_call_button);
	}

	public void endCall () {
		Log.logger.info(String.format("%s: End the call", className));
		mobileSupport.clickOnXpath(CallControlSelector.end_button);
	}
	
	public void verifyCallEstablishSuccessful(String fullName) {
		Log.logger.info(String.format("%s: Verify that call establish successfully.", className));
		String actualName = mobileSupport.getTextByXpath(CallControlSelector.user_name_text);
		Log.logger.info(String.format("%s: Actual result: %s -  Expected result: %s", className, actualName, fullName));
		Assert.assertEquals(actualName, fullName);
	}

}
