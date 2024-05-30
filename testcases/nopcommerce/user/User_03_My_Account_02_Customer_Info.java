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
import pageObjects.user.common.UserHomePageObject;
import pageObjects.user.common.UserLoginPageObject;
import pageObjects.user.myAccount.UserCustomerInfoPageObject;

public class User_03_My_Account_02_Customer_Info extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private String dFirstName, dLastName, dEmailAddress, dPassword, dCompany, dGender, dDay, dMonth, dYear;
	private String nFirstName, nLastName, nEmailAddress, nCompany, nGender, nDay, nMonth, nYear;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		dFirstName = Common_01_User_Register.firstName;
		dLastName = Common_01_User_Register.lastName;
		dEmailAddress = Common_01_User_Register.emailAddress;
		dPassword = Common_01_User_Register.password;
		dCompany = Common_01_User_Register.company;
		dGender = Common_01_User_Register.gender;
		dDay = Common_01_User_Register.day;
		dMonth = Common_01_User_Register.month;
		dYear = Common_01_User_Register.year;

		nFirstName = UserNewInfo.FIRSTNAME;
		nLastName = UserNewInfo.LASTNAME;
		nEmailAddress = UserNewInfo.EMAIL_USERNAME + getRandomNumber() + UserNewInfo.EMAIL_DOMAIN;
		nCompany = UserNewInfo.COMPANY;
		nGender = UserNewInfo.GENDER;
		nDay = UserNewInfo.DOB_DAY;
		nMonth = UserNewInfo.DOB_MONTH;
		nYear = UserNewInfo.DOB_YEAR;

		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");
		userHomePage = userLoginPage.loginToSystem(dEmailAddress, dPassword);
	}

	@Test
	public void Customer_Info_01_Verify_Info() {
		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		Assert.assertTrue(userCustomerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));

		Assert.assertTrue(userCustomerInfoPage.isGenderRadioButtonByLabelSelected(dGender));

		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), dFirstName);

		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), dLastName);

		Assert.assertEquals(userCustomerInfoPage.getDayDropdownValue(), dDay);

		Assert.assertEquals(userCustomerInfoPage.getMonthDropdownValue(), dMonth);

		Assert.assertEquals(userCustomerInfoPage.getYearDropdownValue(), dYear);

		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), dEmailAddress);

		Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(), dCompany);

		Assert.assertTrue(userCustomerInfoPage.isNewsletterCheckboxChecked());
	}

	@Test
	public void Customer_Info_02_Update_New_Info() {
		userCustomerInfoPage.checkGenderRadioButtonByLabel(nGender);

		userCustomerInfoPage.sendKeysToFirstNameTextbox(nFirstName);

		userCustomerInfoPage.sendKeysToLastNameTextbox(nLastName);

		userCustomerInfoPage.selectDayDropdown(nDay);

		userCustomerInfoPage.selectMonthDropdown(nMonth);

		userCustomerInfoPage.selectYearDropdown(nYear);

		userCustomerInfoPage.sendKeysToEmailTextbox(nEmailAddress);

		userCustomerInfoPage.sendKeysToCompanyTextbox(nCompany);

		userCustomerInfoPage.uncheckNewsletterCheckbox();

		userCustomerInfoPage.clickSaveButton();

		Assert.assertEquals(userCustomerInfoPage.getBarNotificationSuccessMessage(), "The customer info has been updated successfully.");

		Assert.assertTrue(userCustomerInfoPage.isGenderRadioButtonByLabelSelected(nGender));

		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), nFirstName);

		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), nLastName);

		Assert.assertEquals(userCustomerInfoPage.getDayDropdownValue(), nDay);

		Assert.assertEquals(userCustomerInfoPage.getMonthDropdownValue(), nMonth);

		Assert.assertEquals(userCustomerInfoPage.getYearDropdownValue(), nYear);

		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), nEmailAddress);

		Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(), nCompany);

		Assert.assertFalse(userCustomerInfoPage.isNewsletterCheckboxChecked());

		userHomePage = (UserHomePageObject) userCustomerInfoPage.clickHeaderLinkByLinkText("Log out");

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Register"));

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Log in"));
	}

	@Test
	public void Customer_Info_03_Login_By_Old_Email() {
		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");

		userLoginPage.loginToSystem(dEmailAddress, dPassword);

		Assert.assertEquals(userLoginPage.getLoginUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Customer_Info_04_Login_By_New_Email() {
		userLoginPage.clickHeaderLinkByLinkText("Log in");

		userHomePage = userLoginPage.loginToSystem(nEmailAddress, dPassword);

		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		Assert.assertTrue(userCustomerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));

		Assert.assertTrue(userCustomerInfoPage.isGenderRadioButtonByLabelSelected(nGender));

		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), nFirstName);

		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), nLastName);

		Assert.assertEquals(userCustomerInfoPage.getDayDropdownValue(), nDay);

		Assert.assertEquals(userCustomerInfoPage.getMonthDropdownValue(), nMonth);

		Assert.assertEquals(userCustomerInfoPage.getYearDropdownValue(), nYear);

		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), nEmailAddress);

		Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(), nCompany);

		Assert.assertFalse(userCustomerInfoPage.isNewsletterCheckboxChecked());

		userHomePage = (UserHomePageObject) userCustomerInfoPage.clickHeaderLinkByLinkText("Log out");

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Register"));

		Assert.assertTrue(userHomePage.isHeaderLinkDisplayedByLinkText("Log in"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
