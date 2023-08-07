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

public class Invalid_Login extends Testbase {

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

		try {
			String validation_message = log_xp.validation_message.getText();
			test.log(Status.PASS,
					"Validation message : " + validation_message + " ; " + "Username : " + user_name + " ; "
							+ "Password : " + password,
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			fun.Click(driver, log_xp.alert_ok);
			test.log(Status.INFO, "Validation alert handled",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			System.out.println();

		} catch (Exception e) {
			test.log(Status.FAIL,
					"Username : " + user_name + " ; " + " Password : " + password + " ; " + e.getLocalizedMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			e.printStackTrace();
		}

	}
}
