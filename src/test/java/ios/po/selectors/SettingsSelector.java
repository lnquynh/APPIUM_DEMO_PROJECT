/**
 * 
 */
package ios.po.selectors;

/**
 * @author Quynh Lai
 *
 */
public class SettingsSelector {
	
	public static String back_button = "//XCUIElementTypeButton[@name='Stop']";
	public static String do_not_ring_button  = "//XCUIElementTypeSwitch[@name='Do not ring this device']";
	public static String data_calling_button = "//XCUIElementTypeSwitch[@name='Data (VoIP) Calling']";
	public static String voip_settings = "//XCUIElementTypeStaticText[@name='VoIP Settings']";
	public static String external_asignment = "//XCUIElementTypeStaticText[@name='External Assignment']";
	public static String troubleshooting = "//XCUIElementTypeStaticText[@name='Troubleshooting']";
	public static String logout_button = "//XCUIElementTypeButton[@name='Logout']";		
	
	
	//Voip Setting screen
	public static String over_wifi_button = "//XCUIElementTypeSwitch[@name='Over Wi-Fi']";
	public static String over_cell_data_button = "//XCUIElementTypeSwitch[@name='Over Cell Data']";
	public static String automatic_handover_button = "//XCUIElementTypeSwitch[contains(@text,'Automatic Handover')]";
	
	//Troubleshooting screen
	public static String connection_status = "//XCUIElementTypeStaticText[@name='Connection Status']";
	public static String configuration = "//XCUIElementTypeStaticText[@name='Configuration']";
	public static String logging = "//XCUIElementTypeStaticText[@name='Logging']";
	public static String sip_logging_button = "//XCUIElementTypeSwitch";
	public static String clear_logs_button = "//XCUIElementTypeButton[@name='Clear Logs']";
	public static String upload_logs_button = "//XCUIElementTypeButton[@name='Upload Logs']";
	public static String send_logs_button = "//XCUIElementTypeButton[@name='Send Logs via Email']";
}
