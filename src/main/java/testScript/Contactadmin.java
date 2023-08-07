package testScript;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import operations.Basic_Functions;
import operations.Testbase;
import webElement.Login_xpath;

public class Contactadmin extends Testbase {

	public static Basic_Functions fun = new Basic_Functions();

	@SuppressWarnings("deprecation")
	public void Login_page(ExtentTest test, AndroidDriver driver) {

		Login_xpath log_xp = new Login_xpath(driver);

		fun.Click(driver, log_xp.IMA_ContactAdmin);
		driver.switchTo().parentFrame();

	}
}
