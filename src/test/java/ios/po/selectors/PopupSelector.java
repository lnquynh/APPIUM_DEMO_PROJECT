/**
 * 
 */
package ios.po.selectors;

/**
 * @author Quynh Lai
 *
 */
public class PopupSelector {
	public static String allow_button = "//XCUIElementTypeButton[@name='Allow']";
	public static String dont_allow_button = "/XCUIElementTypeButton[@name='Don’t Allow']";
	public static String reject_button = "//XCUIElementTypeButton[@name='Reject']";
	public static String accept_button = "//XCUIElementTypeButton[@name='Accept']";
	public static String yes_button = "//XCUIElementTypeButton[@name='Yes']";
	public static String no_button = "//XCUIElementTypeButton[@name='No']";
	public static String ok_button = "//XCUIElementTypeButton[@name='OK']";
	public static String call_button = "//XCUIElementTypeButton[@name='Call']";
	public static String cancel_button = "";
	public static  String popup_aleart_class = "//XCUIElementTypeAlert";
	
	//Pop up title on login screen
	public static String send_notification_title = "//XCUIElementTypeStaticText[@name='“Mitel Connect” Would Like to Send You Notifications']";
	public static String emergency_call_warning_title = "//XCUIElementTypeStaticText[@name='Emergency Call Warning']";
	public static String ssl_certificate_title = "//XCUIElementTypeStaticText[@name='SSL Certificate']";
	public static String enhance_application_title = "//XCUIElementTypeStaticText[@name='Enhance Mitel Application Performance?']";
	public static String number_validation_title = "//XCUIElementTypeStaticText[@name='International Number Validation']";
	public static String provision_popup_title = "//XCUIElementTypeStaticText[@name='Provisioning']";
	public static String provision_popup_content = "//XCUIElementTypeStaticText[@name='Provisioning']/following-sibling::XCUIElementTypeStaticText";
	
}
