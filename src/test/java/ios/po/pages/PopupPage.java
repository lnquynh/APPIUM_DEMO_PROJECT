/**
 * 
 */
package ios.po.pages;

import common.MobileSupport;
import core.Log;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import ios.po.selectors.PopupSelector;

/**
 * @author Quynh Lai
 *
 */
public class PopupPage {
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	private static String className = PopupPage.class.getName();
	private final String REQUEST_NOTIFICATION_TITLE = "“Mitel Connect” Would Like to Send You Notifications";
	private final String REQUEST_ACCESS_CONTACT_TITLE = "“Mitel Connect” Would Like to Access Your Contacts";
	private final String REQUEST_ACCESS_CALENDAR_TITLE = "“Mitel Connect” Would Like to Access Your Calendar";
	private final String REQUEST_ACCESS_MICROPHONE_TITLE = "“Mitel Connect” Would Like to Access the Microphone";
	private final String EMERGENCY_CALL_WARNING_TITLE = "Emergency Call Warning";
	private final String SSL_WARNING_TITLE = "SSL Certificate";
	private final String PROVISIONING_TITLE = "Provisioning";
	private final String VOICEMAIL_TITLE = "Voicemail";
	private final String ENHANCE_MITEL_APPLICATION_TITLE = "Enhance Mitel Application Performance?";
	
	
	public PopupPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
	}
	
	public void autoAgreeContentInPopup() {
		boolean bShouldWaiting = false;
		do {
			bShouldWaiting = false;
			if (mobileSupport.waitAndCheckXpathDisplay(PopupSelector.popup_aleart_class, 5)) {
				bShouldWaiting = true;
				String popupText = mobileSupport.getTextByXpath(PopupSelector.popup_aleart_class);
				if (!popupText.isEmpty()) {
					Log.logger.info(String.format("%s: Title of popup is '%s'", className, popupText));
					switch(popupText) {
						case REQUEST_NOTIFICATION_TITLE:
							pressAllowButton();
							break;
						case EMERGENCY_CALL_WARNING_TITLE:
						case SSL_WARNING_TITLE:
							pressAcceptButton();
							break;
						case ENHANCE_MITEL_APPLICATION_TITLE: 
							pressYesButton();
							break;
						case REQUEST_ACCESS_CONTACT_TITLE:
						case REQUEST_ACCESS_CALENDAR_TITLE:
						case REQUEST_ACCESS_MICROPHONE_TITLE:
						case VOICEMAIL_TITLE:
							pressOKButton();
							break;
						case PROVISIONING_TITLE:
							return;
						default:{
							Log.logger.info("No have popup in this list");
							return;
						}
							
					}
				}
			}
		}
		while(bShouldWaiting);
	}
	
	public void pressAllowButton () {
		Log.logger.info(String.format("%s: Press Allow popup", className));
		mobileSupport.clickOnXpath(PopupSelector.allow_button);
	}
	
	public void pressDontAllowButton () {
		Log.logger.info(String.format("%s: Press Don't Allow popup", className));
		mobileSupport.clickOnXpath(PopupSelector.dont_allow_button);
	}

	public void pressAcceptButton () {
		Log.logger.info(String.format("%s: Press Accept popup", className));
		mobileSupport.clickOnXpath(PopupSelector.accept_button);
	}
	
	public void pressRejectButton () {
		Log.logger.info(String.format("%s: Press Reject popup", className));
		mobileSupport.clickOnXpath(PopupSelector.reject_button);
	}
	
	public void pressYesButton () {
		Log.logger.info(String.format("%s: Press Yes popup", className));
		mobileSupport.clickOnXpath(PopupSelector.yes_button);
	}
	
	public void pressNoButton () {
		Log.logger.info(String.format("%s: Press No popup", className));
		mobileSupport.clickOnXpath(PopupSelector.no_button);
	}
	public void pressOKButton () {
		Log.logger.info(String.format("%s: Press OK popup", className));
		mobileSupport.clickOnXpath(PopupSelector.ok_button);
	}
	
	public void pressCancelButton () {
		Log.logger.info(String.format("%s: Press Cancel popup", className));
		mobileSupport.clickOnXpath(PopupSelector.cancel_button);
	}
	
	public void pressCallButton () {
		Log.logger.info(String.format("%s: Press Call button", className));
		mobileSupport.clickOnXpath(PopupSelector.call_button);
	}
}
