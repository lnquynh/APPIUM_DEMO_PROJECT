package ios.po.pages;

import common.MobileSupport;
import core.Log;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import ios.po.selectors.KeypadSelector;
import ios.po.selectors.PopupSelector;

/**
 * @author Quynh Lai
 * 
 */
public class KeypadPage {
	private static String className = CallControlPage.class.getName();
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	public static final int VOIP_OPTION = 1;
	public static final int CELLULAR_VOICE_OPTION = 2;
	public static final int PERSIONAL_DIAL_OPTION = 3;
	
	public KeypadPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
	}
	
	public void makeCall (String number) {
		Log.logger.info(String.format("%s: Making a call to %s", className, number));
		pressNumber(number);
		mobileSupport.clickOnXpath(KeypadSelector.call_button);
	}
	
	public void makeCellularCall (String number) {
		Log.logger.info(String.format("%s: Making a cellular call to %s", className, number));
		makeCall(number);
		mobileSupport.clickOnXpath(PopupSelector.call_button);
	}
	
	public void navigateToDashboardScreen() {		
		Log.logger.info(String.format("%s: Navigate to Dashboard screen", className));
		mobileSupport.clickOnXpath(KeypadSelector.down_arrow_button);
	}
	
	public void pressDirectoryIcon (String number) {
		mobileSupport.clickOnXpath(KeypadSelector.directory_icon);
	}
	
	public void chooseCallUsingOption(int option) {
		Log.logger.info(String.format("%s: Choosing call using option", className));
		mobileSupport.clickOnXpath(KeypadSelector.call_using_option);
		switch (option) {
		case 1: mobileSupport.clickOnXpath(KeypadSelector.voip_option);
			break;
		case 2: mobileSupport.clickOnXpath(KeypadSelector.cellular_voice_option);
			break;
		case 3: mobileSupport.clickOnXpath(KeypadSelector.persional_dial_option);
			break;
		}
	}
	
	public void pressNumber (String phoneNumber) {
		char[] numbers = phoneNumber.toCharArray();
		
		for (char number : numbers) {
			switch (number) {
			case '1': mobileSupport.clickOnXpath(KeypadSelector.number1);
			break;
			case '2': mobileSupport.clickOnXpath(KeypadSelector.number2);
			break;
			case '3': mobileSupport.clickOnXpath(KeypadSelector.number3);
			break;
			case '4': mobileSupport.clickOnXpath(KeypadSelector.number4);
			break;
			case '5': mobileSupport.clickOnXpath(KeypadSelector.number5);
			break;
			case '6': mobileSupport.clickOnXpath(KeypadSelector.number6);
			break;
			case '7': mobileSupport.clickOnXpath(KeypadSelector.number7);
			break;
			case '8': mobileSupport.clickOnXpath(KeypadSelector.number8);
			break;
			case '9': mobileSupport.clickOnXpath(KeypadSelector.number9);
			break;
			case '0': mobileSupport.clickOnXpath(KeypadSelector.number0);
			break;
			case '*': mobileSupport.clickOnXpath(KeypadSelector.star_button);
			break;
			case '#': mobileSupport.clickOnXpath(KeypadSelector.pound_button);
			break;
			}
		}
	}

}
