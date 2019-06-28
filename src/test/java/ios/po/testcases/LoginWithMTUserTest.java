/**
 * 
 */
package ios.po.testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
public class LoginWithMTUserTest {
	MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	LoginPage loginPage;
	String username, password, mobileNumber, region;
	
	@BeforeClass
	@Parameters ({"deviceTestID1"})
	public void prepareLoginTest(String deviceTestID1) throws MalformedURLException {
		String userID = ReadExcel.getDeviceTest(deviceTestID1, "UserID");
		username = ReadExcel.getDataUser(userID, "Username");
		password = ReadExcel.getDataUser(userID, "Password");
		mobileNumber = ReadExcel.getDataUser(userID, "Mobile Number");
		region = ReadExcel.getDataUser(userID, "Region");
		driver = DriverFactory.getIOSDriver(deviceTestID1);
	}	
	
	@Test(priority = 0)
	public void VerifyLoginAndLogoutWithMTUser() throws InterruptedException, MalformedURLException
	{
		Log.startTestCase("VerifyLoginAndLogoutWithMTUser");
		loginPage = new LoginPage(driver);
		loginPage.loginWithCloud(username, password, mobileNumber, region);
		String expectedText = "This device has been successfully provisioned.";
		loginPage.verifyLoginResult(expectedText);
		
		PopupPage popupPage = new PopupPage(driver);
		popupPage.pressOKButton();
		popupPage.autoAgreeContentInPopup();
		
		DashboardPage dashboardPage = new DashboardPage(driver); 
		dashboardPage.waitForActive();
		dashboardPage.navigateToSetting();
		
		loginPage.logout();
		loginPage.verifyLogoutSuccessful();
	}
	
	@AfterMethod
	public void checkAfterEachTest(ITestResult result) {
		Log.logTestcaseResult(result);
		int resultStatus = result.getStatus();
		if (resultStatus == ITestResult.FAILURE) {
			driver.closeApp();
			driver.launchApp();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
