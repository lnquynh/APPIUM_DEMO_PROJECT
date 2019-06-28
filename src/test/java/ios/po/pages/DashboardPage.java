package ios.po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import common.MobileSupport;
import core.Log;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import ios.po.selectors.DashboardSelector;

/**
 * @author Quynh Lai
 * 
 *
 */

public class DashboardPage {
	private static String className = DashboardPage.class.getName();
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	
	public DashboardPage(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
	}
    
    public void waitForActive() {
    	try {
    		mobileSupport.waitForElementToDisappear(DashboardSelector.offline_state);
    		Log.logger.info(String.format("%s: User regristered successfully.", className));
    	}catch (TimeoutException timeout) {
    		throw new TimeoutException("User regristered failed! Please check your connection.");
    	}
    }
    
	public void navigateToSetting () {
		Log.logger.info(String.format("%s: Navigate to Setting screen", className));
		driver.findElement(By.xpath(DashboardSelector.settings_button)).click();
	}
	
	public void pressSearchButton () {
		Log.logger.info(String.format("%s: Press search button", className));
		mobileSupport.clickOnXpath(DashboardSelector.search_button);
	}
    
    //Navigation bar
	public void navigateToMessages () {
		Log.logger.info(String.format("%s: Navigate to Messages screen", className));
		mobileSupport.clickOnXpath(DashboardSelector.messages_tab);
	}
	
	public void navigateToRecent () {
		Log.logger.info(String.format("%s: Navigate to Recent screen", className));
		mobileSupport.clickOnXpath(DashboardSelector.recent_tab);
	}
	
	public void navigateToKeypad () {
		Log.logger.info(String.format("%s: Navigate to Keypad screen", className));
		mobileSupport.clickOnXpath(DashboardSelector.keypad_button);
	}
	
	public void navigateToEvents () {
		Log.logger.info(String.format("%s: Navigate to Events screen", className));
		mobileSupport.clickOnXpath(DashboardSelector.events_tab);
	}
	
	public void navigateToContacts () {
		Log.logger.info(String.format("%s: Navigate to Contacts screen", className));
		mobileSupport.clickOnXpath(DashboardSelector.contacts_tab);
	}
	
	public void navigateToDashboard () {
		Log.logger.info(String.format("%s: Navigate to Dashboard screen", className));
		mobileSupport.clickOnXpath(DashboardSelector.messages_tab);
	}
	
	public boolean isDashboardPage () {
		return mobileSupport.checkElementDisplay(DashboardSelector.keypad_button);
	}
	
	public void pressItemOnActivity (String userName) {
		Log.logger.info(String.format("%s: Press the call log of %s on Activity", className, userName));
		mobileSupport.clickOnXpath(DashboardSelector.user_call_log(userName));
	}
}
