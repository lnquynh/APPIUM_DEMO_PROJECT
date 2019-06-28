/**
 * 
 */
package ios.po.pages;

import common.MobileSupport;
import core.Log;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import ios.po.selectors.SettingsSelector;

/**
 * @author Quynh Lai
 *
 */
public class SettingsPage {
	private static String className = SettingsPage.class.getName();
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	
	public SettingsPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
	}
	
	public void navigateToVoIPSettings() {
		Log.logger.info(String.format("%s: Navigate to VoIP Setting screen", className)); 
		mobileSupport.clickOnXpath(SettingsSelector.voip_settings);
	}
	
	public void navigateToTroubleshooting() {
		Log.logger.info(String.format("%s: Navigate Troubleshooting screen", className));
		mobileSupport.clickOnXpath(SettingsSelector.troubleshooting);
	}
	
	public void navigateToExternalAssignment() {
		Log.logger.info(String.format("%s: Navigate to External Assignment screen", className));
		mobileSupport.clickOnXpath(SettingsSelector.external_asignment);
	}
	
	public void pressLogoutButton() {
		mobileSupport.clickOnXpath(SettingsSelector.logout_button);
	}
	


}
