package base;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader frprop;
	public static FileReader frloc;
	public static SoftAssert softAssert;
	public static WebDriverWait wait;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReporter;
	public static ThreadLocal<String> assertionMessage;

	@BeforeSuite
	public void setupReport() {
		// Initialize ExtentSparkReporter
		sparkReporter = new ExtentSparkReporter("extent-report.html");
		// Initialize ExtentReports
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		// Additional configurations if needed
		sparkReporter.config().setDocumentTitle("Test Report");
		sparkReporter.config().setReportName("Selenium Test Report");
	}

	@BeforeMethod
	public void setup() throws IOException {

		if (driver == null) {

			frprop = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
			prop.load(frprop);

			frloc = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\locators.properties");
			loc.load(frloc);

			// softAssert = new SoftAssert();

			assertionMessage = new ThreadLocal<>();

		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("lambda")) {
			//WebDriverManager.edgedriver().setup();
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("128");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "ankur.kumar");
			ltOptions.put("accessKey", "XYy66JV7mVWDJSavg6UibWRR3H2O3YdqyHwZ61dD7w4O5flVLM");
			ltOptions.put("project", "Untitled");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);

		        try
		        {
		            driver = new RemoteWebDriver(new URL("https://" + "ankur.kumar" + ":" + "XYy66JV7mVWDJSavg6UibWRR3H2O3YdqyHwZ61dD7w4O5flVLM" + "@hub.lambdatest.com/wd/hub"), browserOptions);
		        }
		        catch (MalformedURLException e)
		        {
		            System.out.println("Invalid grid URL");
		        }
		//	driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("testURL"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	}

	public static String getAssertionMessage() {
		return assertionMessage.get();
	}

	public static void scrollPageDown() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public static void switchToNewTab() {
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
	//	driver.close();

	}

	@AfterSuite
	public void tearDownReport() {
		// Flush the report
		extentReports.flush();
	}

	// Method to log any caught exception into Extent Reports
	public static void logExceptionToReport(Exception e) {
		extentTest.log(Status.FAIL, "Exception occurred: " + e.getMessage());
		for (StackTraceElement element : e.getStackTrace()) {
			extentTest.log(Status.FAIL, element.toString());
		}
	}

}
