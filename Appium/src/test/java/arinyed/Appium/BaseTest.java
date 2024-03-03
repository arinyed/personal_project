package arinyed.Appium;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	public UiAutomator2Options options;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		options = new UiAutomator2Options();

		options.setDeviceName("Arin emulator");

		options.setChromedriverExecutable("/Users/arinyedgarian/documents/chromedriver 11");

		//options.setApp(
		//		"/Users/arinyedgarian/eclipse-workspace/eclipse-workplace3/Appium/src/test/java/resources/ApiDemos-debug.apk");
		
		options.setApp(
				"/Users/arinyedgarian/eclipse-workspace/eclipse-workplace3/Appium/src/test/java/resources/General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void longPressAction(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));

	}

	public void ScrollToEndAction() {

		boolean canScrollMore;
		do {

			// scroll by coordinates
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));

		} while (canScrollMore);
	}

	public void swipeAction(WebElement element, String direction) {

		// Swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", "left", "percent", 0.75));

	}

	public void waiter(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

		service.stop();

	}

}
