package testScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import operations.Basic_Functions;
import operations.Testbase;
import webElement.Login_xpath;
import webElement.Message_xpath;

public class Message extends Testbase {

	public static Basic_Functions fun = new Basic_Functions();

	@SuppressWarnings("deprecation")
	public void Message_menu(ExtentTest test, AndroidDriver driver) throws IOException, InterruptedException {

		Message_xpath msg_xp = new Message_xpath(driver);
		Login_xpath log_xp = new Login_xpath(driver);

		// Login Test for IMA

		fun.Sendkeys(driver, log_xp.user_name_Login, "gopinath@datanetiix.com");
		test.log(Status.INFO, "User name Entered",
				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Sendkeys(driver, log_xp.pass_login, "Pass@123");
		test.log(Status.INFO, "Password Entered",
				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Click(driver, log_xp.login_button);
		test.log(Status.INFO, "Log in button clicked",
				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//		fun.Click(driver, log_xp.location_allowwhenuse);
//		test.log(Status.INFO, "Location Permission - Allow while usin App is sclicked",
//				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//		fun.Click(driver, log_xp.alert_ok);
//		test.log(Status.INFO, "Playstore alert handled",
//				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		System.out.println("User dashboard");

		test.log(Status.INFO, "Login Successful",
				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Click(driver, msg_xp.msg_db_icon);

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		fun.Click(driver, msg_xp.gopinath_msg_detail);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		String message = "If you have a Reporting Class say which Listens to the TestNG Listner and have ExtentReport code implemented in it you can get the TestCase Steps using Reporter Object please see below.";
		fun.Sendkeys(driver, msg_xp.msg_text_field, message);
		fun.Click(driver, msg_xp.snd_msg_button);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		if (msg_xp.last_msg.isDisplayed()) {
			String after_msg = msg_xp.last_msg.getText();
//			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//			fun.explicit_Wait(driver, msg_xp.last_msg);
//			Assert.notEmpty(msg_xp.last_msg.getText(),
//					"The Android SDK includes an Android device emulator — a virtual device that runs on your computer. The Android Emulator lets you develop and test Android apps without using a physical device.");
//			System.out.println(msg_xp.last_msg.getText());
			test.log(Status.PASS, "Message sent successfully" + "    " + after_msg,
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			System.out.println(after_msg);
//			System.out.println(msg_xp.last_msg.getText());

		} else {

			test.log(Status.FAIL, "Message sent Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}
		//// 00000000-0000-038f-ffff-ffff00000138
		// android.widget.ScrollView/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]

	}
}
