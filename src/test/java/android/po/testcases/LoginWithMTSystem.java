package android.po.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import android.po.pages.DashboardPage;
import android.po.pages.LoginPage;
import core.DriverFactory;
import core.ReadExcel;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public class LoginWithMTSystem {
	MobileDriver<MobileElement> driver;
	
	@Test
	public void LoginWithMTSystemTC() throws Exception {
		ReadExcel re = new ReadExcel("LoginWithMTTC");
		String userID = re.getVar("UserID");
		String deviceID = re.getVar("DeviceID");
		String username = ReadExcel.getDataUser(userID, "Username");
		String password = ReadExcel.getDataUser(userID, "Password");
		String mobilenumber = ReadExcel.getDataUser(userID, "Mobile Number");
		
		MobileDriver<MobileElement> driver = DriverFactory.getAndroidDriver(deviceID);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.click_permission();
		loginPage.sendKeyUserName(username);
		loginPage.updateState(LoginPage.MITEL_CONNECT_DEVELOPMENT_CLOUD_SERVICE,LoginPage.SIT_SYSTEM_REGION,"", password, mobilenumber, "");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.waitForActive();
		dashboardPage.clickVoiceMailPopUp();
		driver.quit();	
	
	}
	

}

