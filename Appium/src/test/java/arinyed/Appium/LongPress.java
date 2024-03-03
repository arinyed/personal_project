package arinyed.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {

	@Test
	public void LongPressGesture() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
		
		longPressAction(element);

		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		
		Assert.assertEquals(menuText, "Sample menu");
		
		
		
	}

}
