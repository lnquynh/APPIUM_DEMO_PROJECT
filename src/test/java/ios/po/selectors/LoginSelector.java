package ios.po.selectors;

/**
 * @author Quynh Lai
 * 
 */
public class LoginSelector {
	
	//The first screen
	public static String username_textbox = "//XCUIElementTypeTextField[@name='UserName']";
	public static String clear_text_button = "//XCUIElementTypeButton[@name='Clear text']";
	
	//Type of service
	public static String type_of_service = "//XCUIElementTypeTextField[@name='UserName']/following-sibling::XCUIElementTypeButton[1]";
	public static String mitel_connect_cloud = "//XCUIElementTypeButton[@name='Mitel Connect Cloud']";
	public static String mitel_on_site = "//XCUIElementTypeButton[@name='Mitel On-Site']";
	public static String mitel_connect_dev_cloud = "//XCUIElementTypeButton[@name='Mitel Connect Development Cloud']";
	public static String cancel_button = "//XCUIElementTypeButton[@name='Cancel']";
	
	public static String region_picker = "//XCUIElementTypeStaticText[@name='Select region']/following-sibling::XCUIElementTypeButton";
	//this xpath return lists of region or type of service options
	public static String region_option (String region) {
		return "//XCUIElementTypeSheet//XCUIElementTypeButton[@name='" + region + "']";
	}
	public static String type_of_service_option (String typeOfService) {
		return "//XCUIElementTypeSheet//XCUIElementTypeButton[@name='" + typeOfService + "']";
	}
	public static String server_address_textbox = "//XCUIElementTypeTextField[@name='serverAdress']";
	public static String next_button = "//XCUIElementTypeButton[contains(@name, 'Next')]";
	
	//The second screens
	public static String password_textbox = "//XCUIElementTypeSecureTextField[@name='Password']";
	public static String show_password = "//XCUIElementTypeButton[@name='showPasswordOff']";
	public static String mobile_textbox = "//XCUIElementTypeTextField[@name='PhoneNumber']";
	public static String back_button = "//XCUIElementTypeButton[@name='Back']";
	public static String sign_in_button = "//XCUIElementTypeButton[contains(@name, 'Sign')]";
	public static String send_logs_button = "//XCUIElementTypeButton[@name='btnSendLogs']";
	
	//Remote address popup
	public static String remote_address_textbox = "//XCUIElementTypeCollectionView/XCUIElementTypeOther[1]//XCUIElementTypeTextField";
	public static String next_button_of_remote_poup = "//XCUIElementTypeButton[@name='Next']";
	
	//Web view
	public static String forgot_password_link = "//XCUIElementTypeStaticText[@name='Forgot Password']";
	public static String webview_show_password_icon = "//XCUIElementTypeStaticText[contains(@name, 'Enter your password')]/following::*[1]";
	public static String webview_password_textbox = "//XCUIElementTypeStaticText[contains(@name, 'Enter your password')]/following::*[2]";
	
	//Mobile phone number screen
	public static String number_validation_popup = "//XCUIElementTypeStaticText[contains(@name, 'Number Validation')]/ancestor::*[contains(@name, 'Number Validation')]";
}