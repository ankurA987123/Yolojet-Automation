package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class UploadDataPage extends BaseTest {

	WebElement uploadShipment;
	WebElement btn_UploadShipment;

	public UploadDataPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void chooseFileToUploadForShipment() {

		driver.findElement(By.xpath(loc.getProperty("uploadShipment")))
				.sendKeys("C:\\Users\\Apptad\\Desktop\\Yolojet\\MisUploadSampleFile (2) - Copy.xlsx");
	}

	public void clickOnShipmentUploadButton() {
		btn_UploadShipment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_UploadShipment"))));
		btn_UploadShipment.click();
	}

}
