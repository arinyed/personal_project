package arinyed.Appium;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void ScrollDemoTest() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// one way of scrolling
		// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"WebView\"));"));

		ScrollToEndAction();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
