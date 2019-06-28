package ios.po.selectors;

/**
 * @author Quynh Lai
 * 
 */
public class DashboardSelector {
	//Header bar
	public static String user_name = "//XCUIElementTypeStaticText[@name='userName']";
	public static String search_button = "//XCUIElementTypeButton[@name='Search']";
	public static String settings_button = "//XCUIElementTypeButton[@name='Settings']/preceding::XCUIElementTypeButton[1]";
	public static String offline_state = "//XCUIElementTypeImage[@name='State Offline']";
	
	//Selector on activity
	public static String view_all_activity = "//XCUIElementTypeStaticText[@name='Activity']/following::XCUIElementTypeButton[@name='View all']";
	public static String user_call_log (String userName) {
		return "//XCUIElementTypeStaticText[@name='"+ userName + "']/parent::*";
	}
			
	//Navigation Bar
		public static String messages_tab = "//XCUIElementTypeButton[contains(@name,'Messages') or @name='Voicemail']";
		public static String recent_tab = "//XCUIElementTypeButton[contains(@name,'Recent')]";
		public static String keypad_button = "//XCUIElementTypeButton[@name='Dialer Dash']";
		public static String events_tab = "//XCUIElementTypeButton[contains(@name,'Events')]";
		public static String contacts_tab = "//XCUIElementTypeButton[contains(@name,'Contacts')]";
		public static String dashboard_tab = "//XCUIElementTypeButton[@name='Item']";
		
}
