package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class TakeScreenshot extends BaseTest {

	public static void takeScreenshot(String testCaseName) throws IOException {

		String timestamp = new SimpleDateFormat("yyyyMMddHmmss").format(new Date());
		String fileName = String.format("%s_%s.png", testCaseName, timestamp);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshot, new File(".//screenshot/" + fileName));
		
	}
}
