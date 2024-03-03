package arinyed.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseTest {

	@Test
	public void fillForm() {

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arin");

		driver.hideKeyboard();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"))"));

		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Brazil']"))
				.click();

		waiter(2000);

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		waiter(2000);

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));

		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();

			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		waiter(2000);

	}

}
