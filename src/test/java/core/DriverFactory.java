package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	public static MobileDriver<MobileElement> getAndroidDriver(String deviceID) throws MalformedURLException {
		MobileDriver<MobileElement> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ReadExcel.getDeviceInfo(deviceID, "Device name"));
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ReadExcel.getConfigData("app_package_name"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ReadExcel.getConfigData("app_activity_launcher"));
		capabilities.setCapability(MobileCapabilityType.APP, ReadExcel.getConfigData("build_path"));
		
		String platform_version = ReadExcel.getDeviceInfo(deviceID, "Platform version");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
		if(platform_version.equals("4.4.4"))
		{
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		}else
		{
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		}
		
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 320);
		
		URL SeleniumGridURL = new URL(ReadExcel.getDeviceInfo(deviceID, "URL Appium"));
		driver =  new AndroidDriver<MobileElement>(SeleniumGridURL, capabilities);
		return driver;
		
	}
	
	public static MobileDriver<MobileElement> getIOSDriver(String deviceTestID) {
		String deviceID = ReadExcel.getDeviceTest(deviceTestID, "DeviceID");
		MobileDriver<MobileElement> driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ReadExcel.getDeviceInfo(deviceID, "Device name"));
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		//capabilities.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		//capabilities.setCapability(IOSMobileCapabilityType.SHOULD_USE_SINGLETON_TESTMANAGER, false);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		capabilities.setCapability(MobileCapabilityType.UDID, ReadExcel.getDeviceInfo(deviceID, "UDID"));
		capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, ReadExcel.getConfigData("bundleId"));
		
		try {
			URL SeleniumGridURL = new URL(ReadExcel.getDeviceTest(deviceTestID, "URL Appium"));
			driver =  new IOSDriver<MobileElement>(SeleniumGridURL, capabilities);
			
		}catch (Exception e) {
			
		}
		return driver;
	}
}

