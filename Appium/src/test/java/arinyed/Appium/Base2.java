package arinyed.Appium;

import java.io.File;

import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base2 {
	
	
	@Test
	public static void startAppiumServer() throws Exception {
		
		AppiumDriverLocalService service;
		
		
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
		.usingDriverExecutable(new File("/usr/local/bin/node")).withIPAddress("127.0.0.1").usingPort(4723));
		
		
		service.start();
		if (service.isRunning()) {
		System.out.println(service);
		// Load the Desired Capabilities
		} else {
		System.out.println("Server startup failed");
		System.exit(0);
		}
		}

}
