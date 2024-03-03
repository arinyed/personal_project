package arinyed.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest {

	@Test
	public void fillForm() {

		// commenting the sendKeys to assert the toast TC
		// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arin");

		driver.hideKeyboard();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Brazil']"))
				.click();

		waiter(2000);

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		waiter(2000);

		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");

		Assert.assertEquals(toastMessage, "Please enter your name");
	}

}
