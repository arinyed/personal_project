package arinyed.Appium;

import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {

	@Test
	public void WifiSettingsName() throws MalformedURLException {

		// run server automated

		// Automation
		// xpath, id, accessibilityId, classname, androidUiAutomator

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Arin's Wifi");
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

	}

}
