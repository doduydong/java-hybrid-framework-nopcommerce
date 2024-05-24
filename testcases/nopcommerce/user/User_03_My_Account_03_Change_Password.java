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
import nopcommerce.common.Common_01_User_Register;
import nopcommerce.data.UserData.UserNewInfo;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;

public class User_03_My_Account_03_Change_Password extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserChangePasswordPageObject userChangePasswordPage;
	private String dEmailAddress, dPassword, nPassword;
	private String invalidPass, incorrectPass;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		dEmailAddress = Common_01_User_Register.emailAddress;
		dPassword = Common_01_User_Register.password;
		nPassword = UserNewInfo.PASSWORD;
		invalidPass = "javaS";
		incorrectPass = "se3Java";

		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");
		userHomePage = userLoginPage.loginToSystem(dEmailAddress, dPassword);
		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");
	}

	@Test
	public void Change_Password_01_Empty_Data() {
		userChangePasswordPage = (UserChangePasswordPageObject) userCustomerInfoPage.clickMyAccountSidebarLinkByLinkText("Change password");

		Assert.assertTrue(userChangePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		userChangePasswordPage.clickChangePasswordButton();

		Assert.assertEquals(userChangePasswordPage.getOldPasswordTextboxErrorMessage(), "Old password is required.");

		Assert.assertEquals(userChangePasswordPage.getConfirmNewPasswordTextboxErrorMessage(), "Password is required.");
	}

	@Test
	public void Change_Password_02_Incorrect_Old_Password() {
		userChangePasswordPage = (UserChangePasswordPageObject) userCustomerInfoPage.clickMyAccountSidebarLinkByLinkText("Change password");

		Assert.assertTrue(userChangePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		userChangePasswordPage.sendKeysToOldPasswordTextbox(incorrectPass);

		userChangePasswordPage.sendKeysToNewPasswordTextbox(nPassword);

		userChangePasswordPage.sendKeysToConfirmNewPasswordTextbox(nPassword);

		userChangePasswordPage.clickChangePasswordButton();

		Assert.assertEquals(userChangePasswordPage.getChangePasswordErrorMessage(), "Old password doesn't match");
	}

	@Test
	public void Change_Password_03_By_Old_Password() {
		userChangePasswordPage = (UserChangePasswordPageObject) userCustomerInfoPage.clickMyAccountSidebarLinkByLinkText("Change password");

		Assert.assertTrue(userChangePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		userChangePasswordPage.sendKeysToOldPasswordTextbox(dPassword);

		userChangePasswordPage.sendKeysToNewPasswordTextbox(dPassword);

		userChangePasswordPage.sendKeysToConfirmNewPasswordTextbox(dPassword);

		userChangePasswordPage.clickChangePasswordButton();

		Assert.assertEquals(userChangePasswordPage.getChangePasswordErrorMessage(), "You entered the password that is the same as one of the last passwords you used. Please create a new password.");
	}

	@Test
	public void Change_Password_04_New_Password_Less_Than_Six_Characters() {
		userChangePasswordPage = (UserChangePasswordPageObject) userCustomerInfoPage.clickMyAccountSidebarLinkByLinkText("Change password");

		Assert.assertTrue(userChangePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		userChangePasswordPage.sendKeysToOldPasswordTextbox(dPassword);

		userChangePasswordPage.sendKeysToNewPasswordTextbox(invalidPass);

		userChangePasswordPage.sendKeysToConfirmNewPasswordTextbox(invalidPass);

		userChangePasswordPage.clickChangePasswordButton();

		Assert.assertEquals(userChangePasswordPage.getNewPasswordTextboxErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters and not greater than 64 characters");
	}

	@Test
	public void Change_Password_05_Incorrect_Confirm_New_Password() {
		userChangePasswordPage = (UserChangePasswordPageObject) userCustomerInfoPage.clickMyAccountSidebarLinkByLinkText("Change password");

		Assert.assertTrue(userChangePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		userChangePasswordPage.sendKeysToOldPasswordTextbox(dPassword);

		userChangePasswordPage.sendKeysToNewPasswordTextbox(nPassword);

		userChangePasswordPage.sendKeysToConfirmNewPasswordTextbox(incorrectPass);

		userChangePasswordPage.clickChangePasswordButton();

		Assert.assertEquals(userChangePasswordPage.getConfirmNewPasswordTextboxErrorMessage(), "The new password and confirmation password do not match.");
	}

	@Test
	public void Change_Password_06_Valid_Data() {
		userChangePasswordPage = (UserChangePasswordPageObject) userCustomerInfoPage.clickMyAccountSidebarLinkByLinkText("Change password");

		Assert.assertTrue(userChangePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		userChangePasswordPage.sendKeysToOldPasswordTextbox(dPassword);

		userChangePasswordPage.sendKeysToNewPasswordTextbox(nPassword);

		userChangePasswordPage.sendKeysToConfirmNewPasswordTextbox(nPassword);

		userChangePasswordPage.clickChangePasswordButton();

		Assert.assertEquals(userChangePasswordPage.getBarNotificationSuccessMessage(), "Password was changed");
	}

	@Test
	public void Change_Password_07_Login_By_Old_Password() {
		userHomePage = (UserHomePageObject) userChangePasswordPage.clickHeaderLinkByLinkText("Log out");

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Register"));

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Log in"));

		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.loginToSystem(dEmailAddress, dPassword);

		Assert.assertEquals(userLoginPage.getLoginUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Change_Password_08_Login_By_New_Password() {
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		userHomePage = userLoginPage.loginToSystem(dEmailAddress, nPassword);

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("My account"));

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Log out"));

		userHomePage.clickHeaderLinkByLinkText("Log out");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
