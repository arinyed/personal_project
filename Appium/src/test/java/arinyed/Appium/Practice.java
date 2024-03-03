package arinyed.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Practice extends BaseTest {

	@Test
	public void PracticeAssignment() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("App")).click();

		waiter(2000);

		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

		waiter(2000);

		driver.findElement(By.xpath("//android.widget.Button[@content-desc='OK Cancel dialog with a message']"))
				.click();

		waiter(2000);

		WebElement okButton = driver
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));

		WebElement dialog = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']"));

		Assert.assertEquals(dialog.getText(), "Lorem ipsum dolor sit aie consectetur adipiscing\n"
				+ "Plloaso mako nuto siwuf cakso dodtos anr koop.");

		okButton.click();

		waiter(1000);

		driver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();

		waiter(1000);

		WebElement radioButton = driver.findElement(
				By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Satellite']"));

		Assert.assertEquals(radioButton.getText(), "Satellite");

		radioButton.click();
		waiter(1000);

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		waiter(1000);

		driver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();

		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("daveB");

		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("kjhasd1909");

		waiter(1000);

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		waiter(1000);

	}

}
