package operations;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import webElement.Login_xpath;

public class Testbase {

	public static AndroidDriver driver;
	public static Basic_Functions fun = new Basic_Functions();

	@SuppressWarnings("deprecation")
	public static void initialization(ExtentTest test) throws IOException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("platformVersion", "11.0");

		capabilities.setCapability("udid", "emulator-5554");

		capabilities.setCapability("deviceName", "Android SDK built for x86");

		capabilities.setCapability("appPackage", "com.datanetiix.imamc");

		capabilities.setCapability("appActivity", "com.tns.NativeScriptActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver(url, capabilities);

		Login_xpath log_xp = new Login_xpath(driver);

		try {

			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

			if (log_xp.IMA_landing_page.isDisplayed()) {
				test.log(Status.INFO, "IMA Application started",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
				System.out.println("Started");
			}

		} catch (IOException e) {

			test.log(Status.FAIL, "IMA Failed to Launch ",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			e.printStackTrace();
		}
	}
}
