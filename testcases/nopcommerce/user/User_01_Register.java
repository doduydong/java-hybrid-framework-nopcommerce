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
import nopcommerce.data.UserData.UserDefaultInfo;
import pageObjects.user.common.UserHomePageObject;
import pageObjects.user.common.UserRegisterPageObject;

public class User_01_Register extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private String firstName, lastName, emailAddress, password;
	private String invalidEmail, invalidPass, incorrectPass;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = UserDefaultInfo.FIRSTNAME;
		lastName = UserDefaultInfo.LASTNAME;
		emailAddress = UserDefaultInfo.EMAIL_USERNAME + getRandomNumber() + UserDefaultInfo.EMAIL_DOMAIN;
		password = UserDefaultInfo.PASSWORD;

		invalidEmail = "dongauto" + getRandomNumber() + "@gmail@com";
		invalidPass = "javaS";
		incorrectPass = "se3Java";
	}

	@Test
	public void Register_01_Empty_Data() {
		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getFirstNameTextboxErrorMessage(), "First name is required.");

		Assert.assertEquals(userRegisterPage.getLastNameTextboxErrorMessage(), "Last name is required.");

		Assert.assertEquals(userRegisterPage.getEmailTextboxErrorMessage(), "Email is required.");

		Assert.assertEquals(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(invalidEmail);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getEmailTextboxErrorMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Register_03_Password_Less_Than_Six_Characters() {
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(invalidPass);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(invalidPass);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getPasswordTextboxErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters and not greater than 64 characters");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(incorrectPass);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getConfirmPasswordTextboxErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Valid_Mandatory_Data() {
		userRegisterPage.clickHeaderLinkByLinkText("Register");

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickContinueButton();

		userHomePage.clickHeaderLinkByLinkText("Log out");
	}

	@Test
	public void Register_06_Existing_Email() {
		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(emailAddress);

		userRegisterPage.sendKeysToPasswordTextbox(password);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
