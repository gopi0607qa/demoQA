package operations;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Basic_Functions extends Testbase {
	public static AndroidDriver driver;

	public void explicit_Wait(AndroidDriver driver, WebElement xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(xpath));

	}

	public void explicit_Wait_Click(AndroidDriver driver, WebElement xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(xpath));

	}

	public void Click(AndroidDriver driver, WebElement xpath) {
		try {
			explicit_Wait_Click(driver, xpath);
			xpath.click();
		} catch (Exception e) {
			explicit_Wait_Click(driver, xpath);
			xpath.click();
			e.printStackTrace();
		}
	}

	public void Sendkeys(AndroidDriver driver, WebElement xpath, String value) {
		try {
//			explicit_Wait_Click(driver, xpath);
//			Scroll(driver, xpath);
//			xpath.click();
//			xpath.clear();
			xpath.sendKeys(value);
		} catch (Exception e) {
//			explicit_Wait_Click(driver, xpath);
//			xpath.click();
//			xpath.clear();
//			xpath.sendKeys(value);
			e.printStackTrace();
		}
	}

	public void Scroll(AndroidDriver driver, WebElement xpath) {
		try {
			JavascriptExecutor js = driver;
			explicit_Wait(driver, xpath);
			js.executeScript("arguments[0].scrollIntoView();", xpath);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String capturescreenshot(AndroidDriver driver) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date = new Date();
		File Dest = new File(System.getProperty("user.dir") + "/src/test/resource/output/Screenshot/"
				+ dateFormat.format(date) + "Screenshot" + System.currentTimeMillis() + ".png");

		Screenshot screenshot = new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", Dest);
		String errflpath = Dest.getAbsolutePath();

		return errflpath;

	}

}

//public WebElement fluentWait(AndroidDriver driver, final WebElement xpath) {
//Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver).withTimeout(Duration.ofSeconds(60))
//		.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
//
//WebElement elementWaitedFor = wait.until(new Function<AndroidDriver, WebElement>() {
//	@Override
//	public WebElement apply(AndroidDriver driver) {
//		return xpath;
//	}
//});
//return elementWaitedFor;
//}
