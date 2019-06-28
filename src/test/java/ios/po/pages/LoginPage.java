package ios.po.pages;

import ios.common.IOSSupport;
import ios.po.selectors.DashboardSelector;
import ios.po.selectors.LoginSelector;
import ios.po.selectors.PopupSelector;

import org.openqa.selenium.By;
import org.testng.Assert;

import common.MobileSupport;
import core.Log;
import core.ReadExcel;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;


/**
 * @author Quynh Lai
 * 
 */
public class LoginPage {
	private static String className = LoginPage.class.getName();
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	IOSSupport iOSSupport;
	PopupPage popupPage;
	
	//Options of type of service
	public static final String MICLOUD_CONNECT = "MiCloud Connect (Cloud)";
	public static final String MIVOICE_CONNECT = "MiVoice Connect (Premise)";
	public static final String MICLOUD_CONNECT_DEVELOPMENT = "MiCloud Connect Development (Cloud)";
	public static final String SKY = "Sky(Cloud)";
	
	
	//Options of region
	public static final String ALPHA = "Alpha";
	public static final String UNITED_STATES = "United States";
	public static final String UNITED_KINGDOM = "United Kingdom";
	public static final String AUSTRALIA = "Australia";
	public static final String OTHER = "Other";
	public static final String UTIT = "UTIT";
	public static final String SIT = "SIT";
	public static final String PREMISE = "Premise";
	
	public LoginPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
		this.popupPage = new PopupPage(driver);
		this.iOSSupport = new IOSSupport(driver);
	}
	
	public void loginWithPremiseByRemoteWifi (String username, String password, String mobileNumber, String remoteAddress) {
		Log.logger.info(String.format("%s: Login %s with %s address by remote wifi", className, username, remoteAddress));
		popupPage.autoAgreeContentInPopup();
		mobileSupport.sendKeyToXpath(LoginSelector.username_textbox, username);
		chooseTypeOfService(MIVOICE_CONNECT);
		mobileSupport.sendKeyToXpath(LoginSelector.server_address_textbox, remoteAddress);
		iOSSupport.hideKeyboard();
		mobileSupport.clickOnXpath(LoginSelector.next_button);
		
		mobileSupport.sendKeyToXpath(LoginSelector.password_textbox, password);
		
		mobileSupport.sendKeyToXpath(LoginSelector.mobile_textbox, mobileNumber);
		mobileSupport.clickOnXpath(LoginSelector.sign_in_button);
		acceptNumberValidationPopup();
		popupPage.autoAgreeContentInPopup();
	}
	
	public void loginWithCloud (String username, String password, String mobileNumber, String region) {
		Log.logger.info(String.format("%s: Login %s with %s region", className, username, region));
		popupPage.autoAgreeContentInPopup();
		mobileSupport.sendKeyToXpath(LoginSelector.username_textbox, username);
		
		String typeOfservice = setTypeOfService(region);
		chooseTypeOfService(typeOfservice);
		chooseRegion(region);
		mobileSupport.clickOnXpath(LoginSelector.next_button);

		if (region.equals(UNITED_KINGDOM) || region.equals(AUSTRALIA)) {
			mobileSupport.sendKeyToXpath(LoginSelector.password_textbox, password);
		}else {
			mobileSupport.sendKeyToXpath(LoginSelector.webview_password_textbox, password);
			mobileSupport.clickOnXpath(LoginSelector.next_button);
		}
		
		mobileSupport.sendKeyToXpath(LoginSelector.mobile_textbox, mobileNumber);
		mobileSupport.clickOnXpath(LoginSelector.sign_in_button);
		acceptNumberValidationPopup();
		popupPage.autoAgreeContentInPopup();
	}
	
	public void chooseTypeOfService (String typeOfService) {
		mobileSupport.clickOnXpath(LoginSelector.type_of_service);
		mobileSupport.clickOnXpath(LoginSelector.type_of_service_option(typeOfService));
	}
	
	public String setTypeOfService (String region) {		
		switch(region) {
			case SIT:
			case UTIT:
				return MICLOUD_CONNECT_DEVELOPMENT;
			case ALPHA: 
			case UNITED_KINGDOM:
			case UNITED_STATES:
			case AUSTRALIA:
				return MICLOUD_CONNECT;
			case PREMISE:
				return MIVOICE_CONNECT;
			case SKY:
				return SKY;
			default: return OTHER;
		}
	}
	
	public void chooseRegion (String region) {
		mobileSupport.clickOnXpath(LoginSelector.region_picker);
		mobileSupport.clickOnXpath(LoginSelector.region_option(region));
	}
	
	public void acceptNumberValidationPopup () {
		if (mobileSupport.waitAndCheckXpathDisplay(LoginSelector.number_validation_popup, 5)) {
			String type = driver.findElement(By.xpath(LoginSelector.number_validation_popup)).getTagName();
			if (type.equals("XCUIElementTypeAlert")) popupPage.pressOKButton();
			else if (type.equals("XCUIElementTypeSheet")) popupPage.pressYesButton();
		}
	}
	
	public void verifyLoginResult (String expectedText) {
		Log.logger.info(String.format("%s: Verify Login Result.", className));
		String actualText = mobileSupport.getTextByXpath(PopupSelector.provision_popup_content);
		Log.logger.info(String.format("%s: Actual result is '%s'", className, actualText));
		Log.logger.info(String.format("%s: Expected result is '%s'", className, expectedText));
		Assert.assertEquals(actualText, expectedText);
	}
	
	public void logout () {
		Log.logger.info(String.format("%s: Logout", className));
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.pressLogoutButton();
		popupPage.pressYesButton();
	}
	
	public void verifyLogoutSuccessful () {
		Assert.assertTrue(mobileSupport.waitAndCheckXpathDisplay(LoginSelector.username_textbox, 10));
	}
	
	public boolean checkLoginStatus () {
		return mobileSupport.checkElementDisplay(DashboardSelector.user_name);
	}
	
	/** Checking that if app not login yet, will login corresponding to each system that user belong with
	 *  else it will ignoring that method
	 */
	public void checkLoginOnDevice(String deviceTestID) {
		boolean checkLogin = mobileSupport.checkElementDisplay(DashboardSelector.user_name);
		String userID = ReadExcel.getDeviceTest(deviceTestID, "UserID");
		if (!checkLogin) {
			Log.logger.info(String.format("%s: App has not login yet", className));
			loginWithAnyUsers(userID);
			popupPage.pressOKButton();
			popupPage.autoAgreeContentInPopup();
		}else {
			String extension = ReadExcel.getDataUser(userID, "Extension");
			String curentUsername =  mobileSupport.getTextByXpath(DashboardSelector.user_name);
			if (curentUsername.contains(extension)) return;
			else {
				DashboardPage dashboardPage = new DashboardPage(driver); 
				dashboardPage.navigateToSetting();	
				logout();
				loginWithAnyUsers(userID);
				popupPage.pressOKButton();
				popupPage.autoAgreeContentInPopup();
			}
		}
	}
	
	public void loginWithAnyUsers(String userID) {
		String username = ReadExcel.getDataUser(userID, "Username");
		String password = ReadExcel.getDataUser(userID, "Password");
		String mobileNumber = ReadExcel.getDataUser(userID, "Mobile Number");
		String region = ReadExcel.getDataUser(userID, "Region");
		if (region.equals(PREMISE)) {
			String systemID = ReadExcel.getDataUser(userID, "ID_System");
			String remoteAddress = ReadExcel.getSystemInfo(systemID, "Remote Address"); 
			loginWithPremiseByRemoteWifi(username, password, mobileNumber, remoteAddress);
		}
		else {
			loginWithCloud(username, password, mobileNumber, region);
		}
	}
	
	public boolean isLoginPage() {
		if (mobileSupport.checkElementDisplay(LoginSelector.username_textbox)||mobileSupport.checkElementDisplay(PopupSelector.emergency_call_warning_title))
			return true;
		else return false;
	}
}
