package testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.LoginPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class Login extends BaseTest {

	LoginPage login;

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid email and password")
	public void login(String email, String password, String expectedURL) {

		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Click on Login Button
		login.clickOnLoginButton();

		// Enter the valid email address
		login.enterEmail(email);

		// Enter the valid password
		login.enterPassword(password);

		// Click on the sign in button
		login.clickOnSignInButton();

		// Verify URL after login
		login.verifyURLAfterLogin(expectedURL);
	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid email and invalid password")
	public void loginWithValidEmailInvalidPass(String email, String password, String expectedErrorMessage) {

		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Click on Login Button
		login.clickOnLoginButton();

		// Enter the valid email address
		login.enterEmail(email);

		// Enter the invalid password
		login.enterPassword(password);

		// Click on the sign in button
		login.clickOnSignInButton();

		// Fetch error message
		login.get_ErrorMessageForIncorrectPassword();

		// Verify error message
		login.VerifyLoginIsNotSuccessfulAndVerifyError(expectedErrorMessage);

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with valid email and blank password")
	public void loginWithValidEmailBlankPass(String email, String expectedErrorMessage) {

		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Click on Login Button
		login.clickOnLoginButton();

		// Enter the valid email address
		login.enterEmail(email);

		// Click on the sign in button
		login.clickOnSignInButton();

		// Fetch error message
		login.get_ErrorMessageForBlankPassword();

		// Verify error message
		login.VerifyLoginIsNotSuccessfulAndVerifyError(expectedErrorMessage);

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with invalid email and valid password")
	public void loginWithInvalidEmailValidPass(String email, String password, String expectedErrorMessage) {

		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Click on Login Button
		login.clickOnLoginButton();

		// Enter the valid email address
		login.enterEmail(email);

		// Enter the invalid password
		login.enterPassword(password);

		// Click on the sign in button
		login.clickOnSignInButton();

		// Fetch error message
		login.get_ErrorMessageForIncorrectEmail();

		// Verify error message
		login.VerifyLoginIsNotSuccessfulAndVerifyError(expectedErrorMessage);

	}

	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with blank email and valid password")
	public void loginWithBlankEmailValidPass(String password, String expectedErrorMessage) {

		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Click on Login Button
		login.clickOnLoginButton();

		// Enter the invalid password
		login.enterPassword(password);

		// Click on the sign in button
		login.clickOnSignInButton();

		// Fetch error message
		login.get_ErrorMessageForBlankPassword();

		// Verify error message
		login.VerifyLoginIsNotSuccessfulAndVerifyError(expectedErrorMessage);

	}
	
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData", description = "verify login with invalid email format and valid password")
	public void loginWithInvEmailForValidPass(String email, String password, String expectedErrorMessage) {

		assertionMessage = new ThreadLocal<>();

		login = new LoginPage(driver);

		// Click on Login Button
		login.clickOnLoginButton();

		// Enter the valid email address
		login.enterEmail(email);

		// Enter the invalid password
		login.enterPassword(password);

		// Click on the sign in button
		login.clickOnSignInButton();

		// Fetch error message
		login.get_ErrorMessageForIncorrectEmailFormat();

		// Verify error message
		login.VerifyLoginIsNotSuccessfulAndVerifyError(expectedErrorMessage);


	}

}
