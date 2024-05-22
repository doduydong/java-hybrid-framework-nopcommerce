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
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserBackInStockSubscriptionsPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserDownloadableProductsPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserMyProductReviewsPageObject;
import pageObjects.user.UserOrdersPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserRewardPointsPageObject;

public class User_03_My_Account extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserAddressesPageObject userAddressesPage;
	private UserOrdersPageObject userOrdersPage;
	private UserDownloadableProductsPageObject userDownloadableProductsPage;
	private UserBackInStockSubscriptionsPageObject userBackInStockSubscriptionsPage;
	private UserRewardPointsPageObject userRewardPointsPage;
	private UserChangePasswordPageObject userChangePasswordPage;
	private UserMyProductReviewsPageObject userMyProductReviewsPage;
	private String firstName, lastName, emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dongauto" + getRandomNumber() + "@gmail.com";
		password = "javaSe3";

		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");
		userHomePage = userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, password);
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
		Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), firstName);

		Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(userCustomerInfoPage.getEmailTextboxValue(), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
