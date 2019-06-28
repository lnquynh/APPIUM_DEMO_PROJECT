package ios.po.testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ios.po.pages.CallControlPage;
import ios.po.pages.DashboardPage;
import ios.po.pages.KeypadPage;
import ios.po.pages.LoginPage;
import common.MobileSupport;
import core.DriverFactory;
import core.Log;
import core.ReadExcel;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Quynh Lai
 * 
 */

public class AudioCallTest {
	
	MobileDriver<MobileElement> driver1, driver2;
	MobileSupport mobileSupport;
	DashboardPage dashboardPage1, dashboardPage2;
	KeypadPage keypadPage1;
	CallControlPage callControlPage1, callControlPage2;
	String fullName1, fullName2, extension2;
	
	@BeforeClass
	@Parameters ({"deviceTestID1", "deviceTestID2"})
	public void prepareTestClass(String deviceTestID1, String deviceTestID2) throws MalformedURLException {
		
		String userID1 = ReadExcel.getDeviceTest(deviceTestID1, "UserID");
		fullName1 = ReadExcel.getDataUser(userID1, "Full Name");
	
		String userID2 = ReadExcel.getDeviceTest(deviceTestID2, "UserID");
		fullName2 = ReadExcel.getDataUser(userID2, "Full Name");
		extension2 = ReadExcel.getDataUser(userID2, "Extension");
		
		driver1 = DriverFactory.getIOSDriver(deviceTestID1);
		driver2 = DriverFactory.getIOSDriver(deviceTestID2);
		
		LoginPage loginPage1 = new LoginPage(driver1);
		loginPage1.checkLoginOnDevice(deviceTestID1);
		
		LoginPage loginPage2 = new LoginPage(driver2);
		loginPage2.checkLoginOnDevice(deviceTestID2);
	}
	
	@BeforeMethod
	public void prepareTestcase() {
		dashboardPage1 = new DashboardPage(driver1);
		if (!dashboardPage1.isDashboardPage()) driver1.launchApp();
		dashboardPage1.waitForActive();
		
		dashboardPage2 = new DashboardPage(driver2);
		if (!dashboardPage2.isDashboardPage()) driver2.launchApp();
		dashboardPage2.waitForActive();
	}
	
	@Test 
	public void VerifyMakeCallByDialPad() throws InterruptedException, MalformedURLException
	{	
		Log.startTestCase("VerifyMakeCallByDialPad");
		dashboardPage1.navigateToKeypad();
		
		keypadPage1 = new KeypadPage(driver1);
		keypadPage1.makeCall(extension2);
		
		callControlPage2 = new CallControlPage(driver2);
		callControlPage2.waitForIncomingCall();
		callControlPage2.acceptIncomingCall();
		
		callControlPage1 = new CallControlPage(driver1);
		callControlPage1.verifyCallEstablishSuccessful(fullName2);
		callControlPage2.verifyCallEstablishSuccessful(fullName1);
		
		callControlPage1.pressSpeakerButton();
		callControlPage1.pressMuteButton();
		callControlPage1.pressHoldButton();
		callControlPage1.pressHoldButton();
		callControlPage1.pressSpeakerButton();
		callControlPage1.pressMuteButton();
		
		Thread.sleep(15000);
		callControlPage2.endCall();
		Thread.sleep(2000);
	}
	
	@Test 
	public void VerifyMakeCallFromActivity() throws InterruptedException, MalformedURLException
	{	
		Log.startTestCase("VerifyMakeCallFromActivity");
		dashboardPage1.navigateToKeypad();
		
		keypadPage1 = new KeypadPage(driver1);
		keypadPage1.makeCall(extension2);
		
		callControlPage2 = new CallControlPage(driver2);
		callControlPage2.waitForIncomingCall();
		
		callControlPage1 = new CallControlPage(driver1);
		callControlPage1.endCall();
		
		keypadPage1.navigateToDashboardScreen();
		
		dashboardPage1.pressItemOnActivity(fullName2);
		
		callControlPage2 = new CallControlPage(driver2);
		callControlPage2.waitForIncomingCall();
		callControlPage2.acceptIncomingCall();
		
		callControlPage1.verifyCallEstablishSuccessful(fullName2);
		callControlPage2.verifyCallEstablishSuccessful(fullName1);
		
		Thread.sleep(15000);
		callControlPage1.endCall();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void checkAfterEachTest(ITestResult result) {
		Log.logTestcaseResult(result);
	}
	
	@AfterClass
	public void tearDown() {
		driver1.quit();
		driver2.quit();
	}
}
