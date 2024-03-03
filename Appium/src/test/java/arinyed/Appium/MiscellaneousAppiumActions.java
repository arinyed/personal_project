package arinyed.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BaseTest {

	@Test
	public void WifiSettingsName() throws MalformedURLException {

		// run server automated

		// Automation
		// xpath, id, accessibilityId, classname, androidUiAutomator

		// adb shell dumpsys window | grep -E 'mCurrentFocus' - MAC
		// adb shell dumpsys window | find "mCurrentFocus" - Windows

		Activity activity = new Activity("io.appium.android.apis",
				"io.appium.android.apis.preference.PreferenceDependencies");
		

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();

		driver.findElement(By.id("android:id/checkbox")).click();

		DeviceRotation landscape = new DeviceRotation(0, 0, 90);

		driver.rotate(landscape);

		options.setCapability("orientation", "LANDSCAPE");

		driver.findElement(By.xpath(
				"//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))
				.click();

		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();

		Assert.assertEquals(alertTitle, "WiFi settings");

		driver.setClipboardText("Arin's WiFi");

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]"))
				.sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
