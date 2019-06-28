package ios.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import common.MobileSupport;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author Quynh Lai
 * 
 */
public class IOSSupport {
	public static final int MEDIUM_DEVICE = 677; 
	public static final int LARGE_DEVICE = 677; 
	private MobileDriver<MobileElement> driver;
	MobileSupport mobileSupport;
	private IOSTouchAction iosTouchAction;
	
	public IOSSupport(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		this.mobileSupport = new MobileSupport(driver);
		iosTouchAction = new IOSTouchAction(driver);
	}
	
	public void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();
	
		Double scrollHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = scrollHeightStart.intValue();
		
		Double scrollHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();
	
		iosTouchAction.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
	}
	
	public void scrollDownToXpath(String xpath) {
		boolean x = mobileSupport.checkElementDisplay(xpath);
		int countScroll = 0;
		while(x!=true) {
			scrollDown();
			countScroll += 1;
			if (countScroll < 3) {
				x = mobileSupport.checkElementDisplay(xpath);
			}else x = true;
		};
	}
	
	public void hideKeyboard() {
        MobileElement element = driver.findElement(By.xpath("//XCUIElementTypeKeyboard"));
        Point keyboardPoint = element.getLocation();
        iosTouchAction.tap(PointOption.point(keyboardPoint.getX() + 2, keyboardPoint.getY() - 2)).release().perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	public void cleatTextByXpath(String xpath) {
		MobileElement element = driver.findElement(By.xpath(xpath));
	    int x = element.getSize().width - 20;
	    int y = element.getLocation().getY() + (element.getSize().height/3);
	    iosTouchAction.tap(PointOption.point(x,y)).release().perform();
	    if (!element.getText().isEmpty()) element.clear();
	}
	
	public void swipeRightWithXpath(String xpath) {
		MobileElement element = driver.findElement(By.xpath(xpath));
		
	    int xStart = element.getSize().width;
	    int xEnd = 3*(element.getSize().width/4);
	    int y = element.getLocation().getY() + (element.getSize().height)/2;
		
		iosTouchAction.press(PointOption.point(xStart, y))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(xEnd, y))
		.release().perform();
	}
	
	public void tapAtPoint(int x, int y) {
		iosTouchAction.tap(PointOption.point(x,y))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();
	}
	
	public int getScreenHeight() {
		Dimension dimension = driver.manage().window().getSize();
		return dimension.getHeight();
	}
	
	public int getScreenWight() {
		Dimension dimension = driver.manage().window().getSize();
		return dimension.getWidth();
	}
	
	public int sizeOfDevice() {
		int screenHeight = getScreenHeight();

		if (screenHeight <= MEDIUM_DEVICE) return MEDIUM_DEVICE;
		else return LARGE_DEVICE;
	}
}
