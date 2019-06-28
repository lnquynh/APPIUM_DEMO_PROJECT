package ios.po.selectors;

/**
 * @author Quynh Lai
 * 
 */
public class CallControlSelector {
	//Elements of basic call Screen
	public static String user_name_text = "//XCUIElementTypeStaticText[@name='userName']";
	public static String phone_number = "//XCUIElementTypeStaticText[@name='phoneNumber']";
	public static String call_duration = "//XCUIElementTypeStaticText[@name='duration']";
	public static String handover_button = "//XCUIElementTypeButton[@name='Handover default']";
	public static String add_call_button = "//XCUIElementTypeButton[@name='Add caller default']";
	public static String video_button = "//XCUIElementTypeButton[@name='Video default']";
	public static String transfer_call_button = "//XCUIElementTypeButton[@name='Transfer default']";
	public static String hold_call_button = "//XCUIElementTypeButton[@name='Hold default']";
	public static String speaker_button = "//XCUIElementTypeButton[@name='Speaker default']";
	public static String keypad_button = "//XCUIElementTypeButton[@name='Keypad default']";
	public static String mute_call_button = "//XCUIElementTypeButton[@name='Mute default']";
	public static String end_button = "//XCUIElementTypeButton[@name='End call']";
	public static String merge_call_button = "//XCUIElementTypeButton[@name='Merge default']";
	public static String move_button = "";
	public static String hold_and_accept_call_button = "";
	public static String end_and_accept_call_button = "";
	
	//Incoming Call Screen
	public static String accept_button = "//XCUIElementTypeButton[@name='Accept']";
	public static String decline_button = "//XCUIElementTypeButton[@name='Decline']";
	
	//Simultaneous call screen
	public static String swap_call_button = "//XCUIElementTypeButton[@name='Swap Call']";
	public static String first_call_status = "//XCUIElementTypeStaticText[@name='statusCallIndex[0]']";
	public static String second_call_status = "//XCUIElementTypeStaticText[@name='statusCallIndex[1]']";
	
	//Transfer call screen
	public static String directory_icon = "//XCUIElementTypeButton[@name='blueDirectory']";
	public static String blind_transfer_button = "//XCUIElementTypeButton[@name='Blind Transfer']";
	public static String consult_transfer_button = "//XCUIElementTypeButton[@name='Consult Transfer']";
	public static String clear_button= "//XCUIElementTypeButton[@name='BtnBackspace']";
	public static String complete_transfer_button = "//XCUIElementTypeButton[@name='Consult Transfer 1']";
	public static String recent_transfer_user(String phoneNumber) {
		return "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@name='" + phoneNumber + "']";
	}
	
	public static String blind_transfer_option = "//XCUIElementTypeStaticText[@name='Transfer Options']/following::XCUIElementTypeButton[@name='Blind Transfer']";
	public static String consult_transfer_option = "//XCUIElementTypeStaticText[@name='Transfer Options']/following::XCUIElementTypeButton[@name='Consult & Transfer']";
	
	public static String number0 = "//XCUIElementTypeButton[@name='Btn0']";
	public static String number1 = "//XCUIElementTypeButton[@name='Btn1']";
	public static String number2 = "//XCUIElementTypeButton[@name='Btn2']";
	public static String number3 = "//XCUIElementTypeButton[@name='Btn3']";
	public static String number4 = "//XCUIElementTypeButton[@name='Btn4']";
	public static String number5 = "//XCUIElementTypeButton[@name='Btn5']";
	public static String number6 = "//XCUIElementTypeButton[@name='Btn6']";
	public static String number7 = "//XCUIElementTypeButton[@name='Btn7']";
	public static String number8 = "//XCUIElementTypeButton[@name='Btn8']";
	public static String number9 = "//XCUIElementTypeButton[@name='Btn9']";
	public static String star_button = "//XCUIElementTypeButton[@name='BtnStar']";
	public static String pound_button = "//XCUIElementTypeButton[@name='BtnPound']";
}
