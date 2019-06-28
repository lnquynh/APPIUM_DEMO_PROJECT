package ios.po.selectors;

/**
 * @author Quynh Lai
 * 
 */
public class KeypadSelector {
	
	public static String number0 = "//XCUIElementTypeButton[@name='Num0']";
	public static String number1 = "//XCUIElementTypeButton[@name='Num1']";
	public static String number2 = "//XCUIElementTypeButton[@name='Num2']";
	public static String number3 = "//XCUIElementTypeButton[@name='Num3']";
	public static String number4 = "//XCUIElementTypeButton[@name='Num4']";
	public static String number5 = "//XCUIElementTypeButton[@name='Num5']";
	public static String number6 = "//XCUIElementTypeButton[@name='Num6']";
	public static String number7 = "//XCUIElementTypeButton[@name='Num7']";
	public static String number8 = "//XCUIElementTypeButton[@name='Num8']";
	public static String number9 = "//XCUIElementTypeButton[@name='Num9']";
	public static String star_button = "//XCUIElementTypeButton[@name='Star Dialpad']";
	public static String pound_button = "//XCUIElementTypeButton[@name='Pound']";
	
	public static String call_button  = "//XCUIElementTypeButton[@name='Call number']";
	public static String down_arrow_button = "//XCUIElementTypeButton[@name='Down Arrow']";
	public static String back_space_button = "//XCUIElementTypeButton[@name='Backspace']";
	
	//Call Using Option
	public static String call_using_option = "//XCUIElementTypeButton[@name='More call options']";
	public static String voip_option = "//XCUIElementTypeStaticText[@name='VoIP']";
	public static String cellular_voice_option = "//XCUIElementTypeStaticText[@name='Cellular Voice']";
	public static String persional_dial_option = "//XCUIElementTypeStaticText[@name='Personal Dial']";
	
	//Selector only show on keypad when add call
	public static String directory_icon = "//XCUIElementTypeButton[@name='Contact Dialpad']";
}
