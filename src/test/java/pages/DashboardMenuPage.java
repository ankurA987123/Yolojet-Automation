package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class DashboardMenuPage extends BaseTest {

	WebElement menu_UploadData;
	WebElement subMenu_UploadData;
	WebElement menu_Shipment;
	WebElement subMenu_AllShipment;

	public DashboardMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnUploadDataMenu() {
		menu_UploadData = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("menu_UploadData"))));
		menu_UploadData.click();
	}

	public void clickOnUploadDataSubMenu() {
		subMenu_UploadData = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("subMenu_UploadData"))));
		subMenu_UploadData.click();
	}

	public void clickOnShipmentMenu() {
		menu_Shipment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("subMenu_UploadData"))));
		menu_Shipment.click();
	}

	public void clickOnShipmentSubMenu() {
		subMenu_AllShipment = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("subMenu_UploadData"))));
		subMenu_AllShipment.click();
	}

}
