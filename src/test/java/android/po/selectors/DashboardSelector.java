package android.po.selectors;


public class DashboardSelector {
	
	public static String swipe_button = "//android.widget.LinearLayout[@resource-id='com.shoretel.connect:id/swipe_up_do_dial_view']";
	public static String user_state_offline_text = "//android.widget.TextView[@resource-id='com.shoretel.connect:id/user_state' AND @text='Offine']";
	public static String user_state = "//android.widget.TextView[@resource-id='com.shoretel.connect:id/user_state']";
	public static String recent_tab_button = "//android.widget.TextView[@resource-id='com.shoretel.connect:id/bottom_item_title' and @text='Recent']";	
	public static String events_tab_button = "//android.widget.TextView[@resource-id='com.shoretel.connect:id/bottom_item_title' and @text='Events']";	
	public static String contacts_tab_button = "//android.widget.TextView[@resource-id='com.shoretel.connect:id/bottom_item_title' and @text='Contacts']";	
	public static String message_tab_button = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]";
	public static String available_state_button = "//android.widget.TextView[@text='Available']";
	public static String metting_state_button = "//android.widget.TextView[@text='In a meeting']";
	public static String out_of_office_state_button ="//android.widget.TextView[@text='Out of office']";
	public static String on_vacation_state_button = "//android.widget.TextView[@text='On vacation']";
	public static String do_not_disturb_state_button ="//android.widget.TextView[@text='Do not disturb']";
	public static String custom_state_button = "//android.widget.TextView[contains(@text,'Custom')]";
	public static String dialog_title = "//android.widget.LinearLayout[@resource-id='android:id/parentPanel']";
	public static String voicemail_dialog_title = "//android.widget.TextView[@resource-id='android:id/alertTitle' and @text='Voicemail']";
	public static String dialog_ok_button = "//android.widget.Button[@resource-id='android:id/button1' and @text='OK']";
	public static String setting_button= "//android.widget.RelativeLayout[@resource-id='com.shoretel.connect:id/img_setting']";
	public static String search_button = "//android.widget.RelativeLayout[@resource-id='com.shoretel.connect:id/img_search']";
	public static String DNR_ICON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.FrameLayout[2]";
	//Element in MT system
	public static String voicemail_tab = "//android.widget.TextView[@resource-id='com.shoretel.connect:id/bottom_item_title' and @text='Voicemail']";
	
	//Pop up voice mail
	public static String pop_up_voicemail = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout";
	

	
}

