package webElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import operations.Testbase;

public class Message_xpath extends Testbase {

	public Message_xpath(AndroidDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.widget.ImageView")
	public WebElement msg_db_icon;

	@FindBy(xpath = "//android.widget.TextView[@text='kavimani']")
	public WebElement gopinath_msg_detail;

	@FindBy(xpath = "//android.view.ViewGroup/android.widget.EditText")
	public WebElement msg_text_field;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	public WebElement snd_msg_button;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.ListView/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement last_msg;

}
