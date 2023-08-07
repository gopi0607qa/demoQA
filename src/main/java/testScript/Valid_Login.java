package testScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

import io.appium.java_client.android.AndroidDriver;
import operations.Basic_Functions;
import operations.Testbase;
import webElement.Login_xpath;

public class Valid_Login extends Testbase {

	public static Basic_Functions fun = new Basic_Functions();

	@SuppressWarnings("deprecation")
	public void Login_page(ExtentTest test, AndroidDriver driver, String user_name, String password)
			throws IOException {

		Login_xpath log_xp = new Login_xpath(driver);

		// Login Test for IMA

		fun.Sendkeys(driver, log_xp.user_name_Login, user_name);
		test.log(Status.INFO, "User name Entered",
				MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Sendkeys(driver, log_xp.pass_login, password);
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

		try {

			Assert.notEmpty(log_xp.user_page.getText(), "IMA NETWORK");
			test.log(Status.PASS, "Login Successful",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		} catch (Exception e) {
			test.log(Status.FAIL, "Login Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		}

	}

}

//		WebElement user_name_Login = driver
//				.findElement(By.xpath("//android.view.ViewGroup[1]/android.widget.EditText"));
//		user_name_Login.sendKeys("repiye7561@leafzie.com");
//
//		WebElement pass_login = driver.findElement(By.xpath("//android.view.ViewGroup[2]/android.widget.EditText"));
//		pass_login.sendKeys("pass@123");
//
//		WebElement login_button = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.Button"));
//		login_button.click();
//
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//
//		WebElement location_allowwhenuse = driver
//				.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.Button[1]"));
//
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//		location_allowwhenuse.click();
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//
//		WebElement play_store_alert = driver.findElement(By.id("android:id/button1"));
//		play_store_alert.click();
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//
//		try {
//			fun.explicit_Wait(driver, log_xp.user_page);
//			Assert.notEmpty(driver.findElement(By.xpath("//android.widget.TextView[@text='IMA NETWORK']")).getText(),
//					"IMA NETWORK");
//			test.log(Status.PASS, "Login Successful",
//					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
//
//		} catch (Exception e) {
//			test.log(Status.FAIL, "Login Failed",
//					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
//		}
////
//		WebElement user_page = driver.findElement(By.xpath("//android.widget.TextView[@text='IMA NETWORK']"));
