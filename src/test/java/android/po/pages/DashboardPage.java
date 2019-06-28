package android.po.pages;


import org.openqa.selenium.TimeoutException;

import android.po.selectors.DashboardSelector;
import common.MobileSupport;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

/*
 * Author Phuong Doan
 */
public class DashboardPage {

	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	public static final int CHM_STATE_OFFLINE = 0;
	public static final int CHM_STATE_AVAILABLE = 1;
	public static final int CHM_STATE_IN_A_MEETING = 2;
	public static final int CHM_STATE_OUT_OF_OFICE = 3;
	public static final int CHM_STATE_ON_VACATION = 4;
	public static final int CHM_STATE_DO_NOT_DISTURB = 5;
	public static final int CHM_STATE_CUSTOM = 6;

	public DashboardPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
	}
	
	public void updateState(int state) throws Exception {
		switch (state) {
		case CHM_STATE_AVAILABLE:
			mobileSupport.clickOnXpath(DashboardSelector.available_state_button);
			break;
		case CHM_STATE_IN_A_MEETING:
			mobileSupport.clickOnXpath(DashboardSelector.metting_state_button);
			break;

		case CHM_STATE_OUT_OF_OFICE:
			mobileSupport.clickOnXpath(DashboardSelector.out_of_office_state_button);
			break;

		case CHM_STATE_ON_VACATION:
			mobileSupport.clickOnXpath(DashboardSelector.on_vacation_state_button);
			break;

		case CHM_STATE_DO_NOT_DISTURB:
			mobileSupport.clickOnXpath(DashboardSelector.do_not_disturb_state_button);
			break;
		case CHM_STATE_CUSTOM:
			mobileSupport.clickOnXpath(DashboardSelector.custom_state_button);
			break;
		}
	}
	
	public String getStateTextBy(int state, String message) {
		switch (state) {
		case CHM_STATE_OFFLINE:
			return "Offline";
		case CHM_STATE_AVAILABLE:
			return "Available";
		case CHM_STATE_IN_A_MEETING:
			return "In a meeting";
		case CHM_STATE_OUT_OF_OFICE:
			return "Out of office";
		case CHM_STATE_ON_VACATION:
			return "On vacation";
		case CHM_STATE_DO_NOT_DISTURB:
			return "Do not disturb";
		case CHM_STATE_CUSTOM:
			return message;
		}

		return "";
	}

	public String getCurrentState() {
		return mobileSupport.getTextByXpath(DashboardSelector.user_state);
	}
	
	
	public void swipeToKeyPad() throws InterruptedException {
		mobileSupport.clickOnXpath(DashboardSelector.swipe_button);
	}
	
	public void waitForActive() throws InterruptedException {
		mobileSupport.waitForElementToAppear(DashboardSelector.user_state);
		mobileSupport.waitForElementToDisappear(DashboardSelector.user_state_offline_text);
	//	clickVoiceMailPopUp();
		
	}
	
	
	public void clickVoiceMailPopUp() {
		try{
		
			mobileSupport.shortWaitForElementToAppear(DashboardSelector.pop_up_voicemail);
			mobileSupport.clickOnXpath(DashboardSelector.dialog_ok_button);
		}catch(TimeoutException e) {}
		
	}
	
	public void clickONUserState() {
		mobileSupport.clickOnXpath(DashboardSelector.user_state);
	}
	
	
	public void clickRecentTab() {
		mobileSupport.clickOnXpath(DashboardSelector.recent_tab_button);
	}
	
	public void clickMessageTab() {
		mobileSupport.clickOnXpath(DashboardSelector.message_tab_button);
	}
	
	public void clickContactsTab() {
		mobileSupport.clickOnXpath(DashboardSelector.contacts_tab_button);
	}
	
	public void clickSettingButton() {
		mobileSupport.clickOnXpath(DashboardSelector.setting_button);
	}
	
	public void verifyDNRIcon() throws Exception {
		Thread.sleep(3500);
		mobileSupport.failIfElementNotDisplay(DashboardSelector.DNR_ICON);
		
	}
	
	public void clickSearchButton() {
		mobileSupport.clickOnXpath(DashboardSelector.search_button);
	}
	//ACtion on MT system
	public void clickVoiceMailTab() {
		mobileSupport.clickOnXpath(DashboardSelector.voicemail_tab);
	}
}


