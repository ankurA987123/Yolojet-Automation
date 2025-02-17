package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class AllShipments extends BaseTest {

	WebElement txt_WaybillNo;
	WebElement btn_SearchAllShipment;
	WebElement lbl_AWBNumber;

	public AllShipments(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterWaybillNo(String waybillNo) {

		txt_WaybillNo = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("txt_WaybillNo"))));
		txt_WaybillNo.sendKeys(waybillNo);
	}

	public void clickOnSearchButton() {

		btn_SearchAllShipment = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_SearchAllShipment"))));
		btn_SearchAllShipment.click();
	}
	
	public void verifyUploadedShipment() {
		lbl_AWBNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("lbl_AWBNumber"))));
		//lbl_AWBNumber.sendKeys(null);
		
	}

}
