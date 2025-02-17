package testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.AllShipments;
import pages.DashboardMenuPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.UploadDataPage;
import utilities.ReadXLData;

public class ShipmentUpload extends BaseTest {
	
	LoginPage login;
	ProductPage product; 
	UploadDataPage shipmentUpload;
	DashboardMenuPage dashboardMenu;
	AllShipments shipment;
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify shipment upload")
	public void uploadShipments(String email, String password, String waybillNo) throws IOException {
		
		assertionMessage = new ThreadLocal<>();
		
		login = new LoginPage(driver); 
		product = new ProductPage(driver);
		shipmentUpload = new UploadDataPage(driver);
		dashboardMenu = new DashboardMenuPage(driver);
		shipment = new AllShipments(driver);
		
		
		//Login with valid credentials
		login.clickOnLoginButton();
		
		login.enterEmail(email);
		
		login.enterPassword(password);
		
		login.clickOnSignInButton();
		
		//Click on B2B and MPS Bulk shipping
		product.clickOnB2BMPSShippingMenu();
		
		//Click on Upload Data menu
		dashboardMenu.clickOnUploadDataMenu();
		
		//Click on Upload Data sub-menu
		dashboardMenu.clickOnUploadDataSubMenu();
		
		//Upload shipment file
		shipmentUpload.chooseFileToUploadForShipment();
		
		//Click on the Upload button
		shipmentUpload.clickOnShipmentUploadButton();
		
		//Click on Shipment menu
		dashboardMenu.clickOnShipmentMenu();
		
		//Click on All Shipment sub-menu
		dashboardMenu.clickOnShipmentSubMenu();
		
		//Search the uploaded record
		shipment.enterWaybillNo(waybillNo);
		
		//Click on search button
		shipment.clickOnSearchButton();
		
		//Verify the shipment record
		shipment.verifyUploadedShipment();
	}

}
