package webElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import operations.Testbase;

public class Login_xpath extends Testbase {

	public Login_xpath(AndroidDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.view.ViewGroup[1]/android.widget.EditText")
	public WebElement user_name_Login;

	@FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.EditText")
	public WebElement pass_login;

	@FindBy(xpath = "//android.view.ViewGroup/android.widget.Button")
	public WebElement login_button;

	@FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.Button[1]")
	public WebElement location_allowwhenuse;

	@FindBy(id = "android:id/button1")
	public WebElement alert_ok;

	@FindBy(xpath = "//android.widget.TextView[@text='IMA NETWORK']")
	public WebElement user_page;

	@FindBy(id = "android:id/message")
	public WebElement validation_message;

	@FindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement IMA_landing_page;

	@FindBy(xpath = "//android.widget.TextView[@text='Contact MemberConnect Admin']")
	public WebElement IMA_ContactAdmin;

}
