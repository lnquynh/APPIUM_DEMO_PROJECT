package android.po.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;

import android.po.selectors.LoginSelector;
import common.MobileSupport;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class LoginPage {
	public static final int MITEL_CONNECT_DEVELOPMENT_CLOUD_SERVICE = 1;
	public static final int MICLOUD_CONNECT_CLOUD_SERVICE = 2;
	public static final int MIVOICE_CONNECT_PREMISE_SERVICE = 3;
	public static final int SKY_CLOUD_SERVICE = 4;
	public static final int SIT_SYSTEM_REGION= 5;
	public static final int UTIT_SYSTEM_REGION = 6;
	public static final int OTHER_SYSTEM_REGION = 7;
	public static final int UNITED_STATES_REGION = 8;
	public static final int UNITED_KINGDOM_REGION = 9;
	public static final int AUSTRALIA_REGION = 10;
	public static final int ALPHA_REGION = 11;

	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	
	public LoginPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
	}
	
	
	public void sendKeyUserName(String username) {
		mobileSupport.sendKeyToXpath(LoginSelector.username_textbox, username);
	}
	
	public void trycatch() {
		try {
			mobileSupport.clickOnXpath(LoginSelector.accept_button);
		} catch (TimeoutException e) {}
	}
	
	public void click_permission() {
		mobileSupport.clickOnXpath(LoginSelector.permission);
		mobileSupport.clickOnXpath(LoginSelector.permission);
		mobileSupport.clickOnXpath(LoginSelector.permission);
		mobileSupport.clickOnXpath(LoginSelector.permission);
		mobileSupport.clickOnXpath(LoginSelector.accept_button);
		mobileSupport.clickOnXpath(LoginSelector.yes_button);	

	}
	
	public void loginOnPortal(String password) {
		//mobileSupport.clickOnXpath(LoginSelector.next_portal_button);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mobileSupport.checkElementDisplay(LoginSelector.Sign_in_to_Mitel_text);
		mobileSupport.sendKeyToXpath(LoginSelector.password_portal, password);
		mobileSupport.clickOnXpath(LoginSelector.next_portal_button);
	}
	
	public void updateState(int picker, int region , String address, String password, String mobilenumber, String remoteAddress) throws Exception {

		mobileSupport.clickOnXpath(LoginSelector.service_picker_box);
		switch (picker) {
		case MITEL_CONNECT_DEVELOPMENT_CLOUD_SERVICE:
			mobileSupport.clickOnXpath(LoginSelector.mitel_connect_development_cloud_text);
			mobileSupport.clickOnXpath(LoginSelector.region_picker_box);
			{
			switch(region) {
				case SIT_SYSTEM_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.SIT_System);
					mobileSupport.clickOnXpath(LoginSelector.next_button_in_login_screen);
					loginOnPortal(password);
					Thread.sleep(10000);
					mobileSupport.sendKeyToXpath(LoginSelector.mobile_textbox, mobilenumber);
					mobileSupport.clickOnXpath(LoginSelector.sign_in_button);
					try {
						mobileSupport.clickOnXpath(LoginSelector.yes_button);
						mobileSupport.clickOnXpath(LoginSelector.accept_button);
					} catch (TimeoutException e) {}
					mobileSupport.clickOnXpath(LoginSelector.OK_button);
					break;
					}
				case UTIT_SYSTEM_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.UTIT_System);
					loginOnPortal(password);
					break;
					
					}
				case OTHER_SYSTEM_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.OTHER_system);
					break;
					}
				}
			}
			break;
		case MICLOUD_CONNECT_CLOUD_SERVICE:
			mobileSupport.clickOnXpath(LoginSelector.mitel_connect_cloud);
			mobileSupport.clickOnXpath(LoginSelector.region_picker_box);
			{
				switch(region){
				case UNITED_STATES_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.UNITED_STATES_system);
					mobileSupport.clickOnXpath(LoginSelector.next_portal_button);
					loginOnPortal(password);
					break;
					}
				case UNITED_KINGDOM_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.UNITED_KINGDOM_system);
					mobileSupport.clickOnXpath(LoginSelector.next_button_in_login_screen);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					mobileSupport.sendKeyToXpath(LoginSelector.password_textbox, password);
					mobileSupport.sendKeyToXpath(LoginSelector.mobile_textbox, mobilenumber);
					mobileSupport.clickOnXpath(LoginSelector.sign_in_button);
					mobileSupport.clickOnXpath(LoginSelector.yes_button);
					mobileSupport.clickOnXpath(LoginSelector.accept_button);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					mobileSupport.clickOnXpath(LoginSelector.OK_button);
					break;
					}
				case AUSTRALIA_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.AUSTRALIA_system);
					mobileSupport.clickOnXpath(LoginSelector.next_button_in_login_screen);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					mobileSupport.sendKeyToXpath(LoginSelector.password_textbox, password);
					mobileSupport.sendKeyToXpath(LoginSelector.mobile_textbox, mobilenumber);
					mobileSupport.clickOnXpath(LoginSelector.sign_in_button);
					mobileSupport.clickOnXpath(LoginSelector.yes_button);
					mobileSupport.clickOnXpath(LoginSelector.accept_button);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					mobileSupport.clickOnXpath(LoginSelector.accept_button);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					mobileSupport.clickOnXpath(LoginSelector.OK_button);
					break;
					}
				case ALPHA_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.ALPHA_system);
					mobileSupport.clickOnXpath(LoginSelector.next_button_in_login_screen);
					loginOnPortal(password);
					Thread.sleep(10000);
					mobileSupport.sendKeyToXpath(LoginSelector.mobile_textbox, mobilenumber);
					mobileSupport.clickOnXpath(LoginSelector.sign_in_button);
					try {
						mobileSupport.clickOnXpath(LoginSelector.yes_button);
//						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						mobileSupport.clickOnXpath(LoginSelector.accept_button);
					} catch (TimeoutException e) {}
					mobileSupport.clickOnXpath(LoginSelector.OK_button);
					break;
					}
				case OTHER_SYSTEM_REGION:{
					mobileSupport.clickOnXpath(LoginSelector.OTHER_system);
					break;
					}
				}
			}
			
			break;

		case MIVOICE_CONNECT_PREMISE_SERVICE:
			mobileSupport.clickOnXpath(LoginSelector.mivoice_connect_primse);
			mobileSupport.sendKeyToXpath(LoginSelector.address_textbox, remoteAddress);
			mobileSupport.clickOnXpath(LoginSelector.next_button);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			mobileSupport.sendKeyToXpath(LoginSelector.password_textbox, password);
			mobileSupport.sendKeyToXpath(LoginSelector.mobile_textbox, mobilenumber);
			mobileSupport.clickOnXpath(LoginSelector.sign_in_button);
			mobileSupport.clickOnXpath(LoginSelector.yes_button);
			mobileSupport.clickOnXpath(LoginSelector.accept_button);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			mobileSupport.clickOnXpath(LoginSelector.OK_button);
			break;

		case SKY_CLOUD_SERVICE:
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
}
