package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class LoginPage extends BaseTest {

	WebElement btn_Login;
	WebElement txt_Email;
	WebElement txt_Password;
	WebElement btn_SignIn;
	WebElement ErrMessage_IncorrectPassword;
	WebElement ErrMessage_BlankPassword;
	WebElement ErrMessage_IncorrectEmail;
	WebElement ErrMessage_BlankEmail;
	WebElement ErrMessage_IncorrectEmailFormat;

	String actualErrorMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginButton() {
		btn_Login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_Login"))));
		btn_Login.click();
	}

	public void enterEmail(String email) {
		txt_Email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("txt_Email"))));
		txt_Email.sendKeys(email);

	}

	public void enterPassword(String password) {
		txt_Password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("txt_Password"))));
		txt_Password.sendKeys(password);

	}

	public void clickOnSignInButton() {
		btn_SignIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("btn_SignIn"))));
		btn_SignIn.click();
		;

	}

	public void verifyURLAfterLogin(String expectedURL) {
		try {
			// wait for the URL change
			wait.until(ExpectedConditions.urlToBe(expectedURL));
		} catch (Exception e) {
			System.out.println("URL is incorrect");
		}

		try {

			String actualURL = driver.getCurrentUrl();

			// Verify the URL
			softAssert.assertEquals(actualURL, expectedURL);
			softAssert.assertAll();

		} catch (AssertionError ae) {
			assertionMessage.set(ae.getMessage());
			throw ae;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	public void get_ErrorMessageForIncorrectPassword() {
		ErrMessage_IncorrectPassword = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(loc.getProperty("ErrMessage_IncorrectPassword"))));
		actualErrorMessage = ErrMessage_IncorrectPassword.getText();

	}

	public void VerifyLoginIsNotSuccessfulAndVerifyError(String expectedErrorMessage) {

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}

	}

	public void get_ErrorMessageForBlankPassword() {
		ErrMessage_BlankPassword = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ErrMessage_BlankPassword"))));
		actualErrorMessage = ErrMessage_BlankPassword.getText();

	}

	public void get_ErrorMessageForIncorrectEmail() {
		ErrMessage_IncorrectEmail = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("ErrMessage_IncorrectEmail"))));
		actualErrorMessage = ErrMessage_IncorrectEmail.getText();

	}

	public void get_ErrorMessageForIncorrectEmailFormat() {
		ErrMessage_IncorrectEmailFormat = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(loc.getProperty("ErrMessage_IncorrectEmailFormat"))));
		actualErrorMessage = ErrMessage_IncorrectEmailFormat.getText();

	}

}
