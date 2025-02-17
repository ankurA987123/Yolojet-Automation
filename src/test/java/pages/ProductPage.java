package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ProductPage extends BaseTest {

	WebElement lnk_B2BMPSBuilkShipping;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnB2BMPSShippingMenu() {

		lnk_B2BMPSBuilkShipping = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("lnk_B2BMPSBuilkShipping"))));
		lnk_B2BMPSBuilkShipping.click();
	}
	
	

}
