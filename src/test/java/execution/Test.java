package execution;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import operations.Basic_Functions;
import operations.Testbase;
import testScript.Invalid_Login;
import testScript.Message;
import testScript.Valid_Login;
import util.ReadExcel;

public class Test extends Testbase {

	public static Basic_Functions fun = new Basic_Functions();
	public static AndroidDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	public Valid_Login valid_login = new Valid_Login();
	public Invalid_Login invalid_login = new Invalid_Login();
	public Message msg = new Message();

	@BeforeSuite
	public void beforesuite() {
		System.out.println("This is before suite");
	}

	@BeforeClass
	public void beforeclass() throws IOException {
		System.out.println("This is before class");

		report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\src\\test\\resources\\extentreport\\ExtentReport.html");

		report.setSystemInfo("User Name", "GopiNath");
		report.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName().toString());
		report.setSystemInfo("Operating System", System.getProperty("os.name").toString());
		report.setSystemInfo("Environment", "Staging");

		final File CONF = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config\\extent-config.xml");
		spark.loadXMLConfig(CONF);

		report.attachReporter(spark);

	}

	@DataProvider(name = "Valid_login")
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"LoginvalidData");
	}

	@DataProvider(name = "Invalid_login")
	public Object[][] readExcel2() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"LoginInvalidData");
	}

	@BeforeMethod

	public void beforemethod() throws IOException, InterruptedException {
		System.out.println("Before Method");
		test = report.createTest("IMA Application Intialization");
		initialization(test);

	}

	@org.testng.annotations.Test(priority = 1, dataProvider = "Valid_login", enabled = true)
	public void Valid_Login_Test(String user_name, String password) throws IOException {
		System.out.println("Valid Test");
		test = report.createTest("IMA Login Test with valid data");
		AndroidDriver driver = Testbase.driver;
		valid_login.Login_page(test, driver, user_name, password);
	}

	@org.testng.annotations.Test(priority = 2, dataProvider = "Invalid_login", enabled = true)
	public void Invalid_Login_Test(String user_name, String password) throws IOException {
		System.out.println("Invalid Test");
		test = report.createTest("IMA Login Test with invalid data");
		AndroidDriver driver = Testbase.driver;
		invalid_login.Login_page(test, driver, user_name, password);
	}

	@org.testng.annotations.Test(enabled = true)
	public void Message_test() throws IOException, InterruptedException {
		System.out.println("Message Test");
		test = report.createTest("IMA new message Test");
		AndroidDriver driver = Testbase.driver;
		try {
			msg.Message_menu(test, driver);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@AfterMethod
	public void aftermethod() {
		AndroidDriver driver = Testbase.driver;
		driver.resetApp();
		driver.quit();
		System.out.println("This is after method");

	}

	@AfterClass
	public void afterclass() {
		System.out.println("This is after class");
		report.flush();

	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("This is after suite");

	}
}

//		WebElement msg_db_icon = driver.findElement(By.xpath("//android.view.ViewGroup[4]/android.widget.ImageView"));
//		msg_db_icon.click();
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//
//		WebElement kavi_msg_detail = driver.findElement(By.xpath("//android.widget.TextView[@text='kavimani']"));
//		kavi_msg_detail.click();
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

// driver.quit();
