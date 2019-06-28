/**
 * 
 */
package ios.po.testcases;

import java.net.MalformedURLException;
import java.util.Arrays;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.MobileSupport;
import core.DriverFactory;
import core.Log;
import core.ReadExcel;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import ios.po.pages.DashboardPage;
import ios.po.pages.LoginPage;
import ios.po.pages.PopupPage;

/**
 * @author Quynh Lai
 *
 */
public class LoginTest {
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@DataProvider(name = "Authentication", parallel=true)
	public static Object[][] credentials2() {
		String[] AllUserID = {"51", "44", "41", "10", "31"};
		int length = AllUserID.length;
		Object[][] dataUser = new Object[length][5];
		
		for(int i = 0; i < length; i++) {
			String userID = AllUserID[i];
			dataUser[i][0] = ReadExcel.getDataUser(userID, "Username");
			dataUser[i][1] = ReadExcel.getDataUser(userID, "Password");
			dataUser[i][2] = ReadExcel.getDataUser(userID, "Mobile Number");
			
			String region = ReadExcel.getDataUser(userID, "Region");
			dataUser[i][3] = region;
			
			if (region.equals("Premise")) {
				String systemID = ReadExcel.getDataUser(userID, "ID_System");
				dataUser[i][4] = ReadExcel.getSystemInfo(systemID, "Remote Address");
			}else {
				dataUser[i][4] = "";
			}
		}
		
		System.out.println(Arrays.deepToString(dataUser));
		return dataUser;
	}
	
	@BeforeClass
	@Parameters ({"deviceTestID"})
	public void prepareLogin (String deviceTestID) {
		driver = DriverFactory.getIOSDriver(deviceTestID);
	}
	
	@BeforeMethod
	public void prepareMethod () {
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		if (!loginPage.isLoginPage()) {
			if (dashboardPage.isDashboardPage()) {
				dashboardPage.navigateToSetting();
				loginPage.logout();
			}else driver.launchApp();
		};
	}
	
	@Test (dataProvider = "Authentication")
	public void VerifyLoginAllSystem(String username, String password, String mobileNumber, String region, String remoteAddress) throws MalformedURLException {
		Log.startTestCase("Login user on " + region + " region.");
		loginPage = new LoginPage(driver);
		if (region.equals(LoginPage.PREMISE)) {
			loginPage.loginWithPremiseByRemoteWifi(username, password, mobileNumber, remoteAddress);
		}else {
			loginPage.loginWithCloud(username, password, mobileNumber, region);
		}
		String expectedText = "This device has been successfully provisioned.";
		loginPage.verifyLoginResult(expectedText);
		
		PopupPage popupPage = new PopupPage(driver);
		popupPage.pressOKButton();
		popupPage.autoAgreeContentInPopup();
		
		dashboardPage.waitForActive();
		dashboardPage.navigateToSetting();
		loginPage.logout();
		loginPage.verifyLogoutSuccessful();
	}
	
	@AfterMethod
	public void checkAfterMethod (ITestResult result) {
		Log.logTestcaseResult(result);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
