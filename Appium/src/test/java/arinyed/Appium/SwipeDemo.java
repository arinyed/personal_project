package arinyed.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest {

	@Test
	public void SwipeDemoTest() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();

		WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));

		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),
				"true");

		swipeAction(firstImage, "left");

		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),
				"false");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
