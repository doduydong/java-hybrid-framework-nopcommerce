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
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserBackInStockSubscriptionsPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserDownloadableProductsPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyProductReviewsPageObject;
import pageObjects.user.UserOrdersPageObject;
import pageObjects.user.UserRewardPointsPageObject;

public class User_03_My_Account_01_Sidebar_Navigation extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserAddressesPageObject userAddressesPage;
	private UserOrdersPageObject userOrdersPage;
	private UserDownloadableProductsPageObject userDownloadableProductsPage;
	private UserBackInStockSubscriptionsPageObject userBackInStockSubscriptionsPage;
	private UserRewardPointsPageObject userRewardPointsPage;
	private UserChangePasswordPageObject userChangePasswordPage;
	private UserMyProductReviewsPageObject userMyProductReviewsPage;
	private String firstName, lastName, emailAddress, password, company, gender, day, month, year;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = Common_01_User_Register.firstName;
		lastName = Common_01_User_Register.lastName;
		emailAddress = Common_01_User_Register.emailAddress;
		password = Common_01_User_Register.password;
		company = Common_01_User_Register.company;
		gender = Common_01_User_Register.gender;
		day = Common_01_User_Register.day;
		month = Common_01_User_Register.month;
		year = Common_01_User_Register.year;

		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");
		userHomePage = userLoginPage.loginToSystem(emailAddress, password);
	}

	@Test
	public void My_Account_01_Switch_Page_By_Sidebar_Links() {
		userHomePage.isHeaderLinkDisplayedByLinkText("My account");

		userCustomerInfoPage = (UserCustomerInfoPageObject) userHomePage.clickHeaderLinkByLinkText("My account");

		Assert.assertTrue(userCustomerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));

		userAddressesPage = (UserAddressesPageObject) userCustomerInfoPage.clickMyAccountSidebarLinkByLinkText("Addresses");

		Assert.assertTrue(userAddressesPage.isMyAccountPageTitleDisplayedByPageName("Addresses"));

		userOrdersPage = (UserOrdersPageObject) userAddressesPage.clickMyAccountSidebarLinkByLinkText("Orders");

		Assert.assertTrue(userOrdersPage.isMyAccountPageTitleDisplayedByPageName("Orders"));

		userDownloadableProductsPage = (UserDownloadableProductsPageObject) userOrdersPage.clickMyAccountSidebarLinkByLinkText("Downloadable products");

		Assert.assertTrue(userDownloadableProductsPage.isMyAccountPageTitleDisplayedByPageName("Downloadable products"));

		userBackInStockSubscriptionsPage = (UserBackInStockSubscriptionsPageObject) userDownloadableProductsPage.clickMyAccountSidebarLinkByLinkText("Back in stock subscriptions");

		Assert.assertTrue(userBackInStockSubscriptionsPage.isMyAccountPageTitleDisplayedByPageName("Back in stock subscriptions"));

		userRewardPointsPage = (UserRewardPointsPageObject) userBackInStockSubscriptionsPage.clickMyAccountSidebarLinkByLinkText("Reward points");

		Assert.assertTrue(userRewardPointsPage.isMyAccountPageTitleDisplayedByPageName("Reward points"));

		userChangePasswordPage = (UserChangePasswordPageObject) userRewardPointsPage.clickMyAccountSidebarLinkByLinkText("Change password");

		Assert.assertTrue(userChangePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		userMyProductReviewsPage = (UserMyProductReviewsPageObject) userChangePasswordPage.clickMyAccountSidebarLinkByLinkText("My product reviews");

		Assert.assertTrue(userMyProductReviewsPage.isMyAccountPageTitleDisplayedByPageName("My product reviews"));

		userCustomerInfoPage = (UserCustomerInfoPageObject) userMyProductReviewsPage.clickMyAccountSidebarLinkByLinkText("Customer info");

		Assert.assertTrue(userCustomerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));
	}

	@Test
	public void My_Account_02_Verify_User_Info() {
		Assert.assertTrue(userCustomerInfoPage.isGenderRadioButtonByLabelSelected(gender));

		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);

		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(userCustomerInfoPage.getDayDropdownValue(), day);

		Assert.assertEquals(userCustomerInfoPage.getMonthDropdownValue(), month);

		Assert.assertEquals(userCustomerInfoPage.getYearDropdownValue(), year);

		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);

		Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(), company);

		Assert.assertTrue(userCustomerInfoPage.isNewsletterCheckboxChecked());

		userHomePage = (UserHomePageObject) userCustomerInfoPage.clickHeaderLinkByLinkText("Log out");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
