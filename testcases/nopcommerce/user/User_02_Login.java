package nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class User_02_Login extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private String firstName, lastName, emailAddress, password;
	private String invalidEmail, notFoundEmail, incorrectPass;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dongauto" + getRandomNumber() + "@gmail.com";
		password = "javaSe3";

		invalidEmail = "dongauto@gmail@com";
		notFoundEmail = "dongat@gmail.com";
		incorrectPass = "se3Java";

		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");
		userHomePage = userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, password);
		userHomePage.clickHeaderLinkByLinkText("Log out");
	}

	@Test
	public void Login_01_Empty_Data() {
		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.clickLoginButton();

		Assert.assertEquals(userLoginPage.getEmailTextboxErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.sendKeysToEmailTextbox(invalidEmail);

		userLoginPage.sendKeysToPasswordTextbox(password);

		userLoginPage.clickLoginButton();

		Assert.assertEquals(userLoginPage.getEmailTextboxErrorMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Login_03_Not_Found_Email() {
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.sendKeysToEmailTextbox(notFoundEmail);

		userLoginPage.sendKeysToPasswordTextbox(password);

		userLoginPage.clickLoginButton();

		Assert.assertEquals(userLoginPage.getLoginUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Without_Password() {
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.sendKeysToEmailTextbox(emailAddress);

		userLoginPage.clickLoginButton();

		Assert.assertEquals(userLoginPage.getLoginUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.sendKeysToEmailTextbox(emailAddress);

		userLoginPage.sendKeysToPasswordTextbox(incorrectPass);

		userLoginPage.clickLoginButton();

		Assert.assertEquals(userLoginPage.getLoginUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Data() {
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.sendKeysToEmailTextbox(emailAddress);

		userLoginPage.sendKeysToPasswordTextbox(password);

		userHomePage = userLoginPage.clickLoginButton();

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("My account"));

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Log out"));

		userHomePage.clickHeaderLinkByLinkText("Log out");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
