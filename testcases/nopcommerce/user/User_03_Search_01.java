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
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserSearchPageObject;

public class User_03_Search_01 extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserSearchPageObject userSearchPage;
	private String emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = Common_01_User_Register.emailAddress;
		password = Common_01_User_Register.password;

		userLoginPage = (UserLoginPageObject) userHomePage.clickHeaderLinkByLinkText("Log in");
		userHomePage = userLoginPage.loginToSystem(emailAddress, password);
	}

	@Test
	public void Search_01_Empty_Data() {
		Assert.assertTrue(userHomePage.isFooterCustomerServiceLinkDisplayedByLinkText("Search"));

		userSearchPage = userHomePage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.clickSearchButton();

		Assert.assertEquals(userSearchPage.getSearchErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_02_Data_Not_Found() {
		Assert.assertTrue(userSearchPage.isFooterCustomerServiceLinkDisplayedByLinkText("Search"));

		userSearchPage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.sendKeysToSearchKeyword("Xiaomi");

		userSearchPage.clickSearchButton();

		Assert.assertEquals(userSearchPage.getNoResultMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_03_Relative_Name_Data() {
		Assert.assertTrue(userSearchPage.isFooterCustomerServiceLinkDisplayedByLinkText("Search"));

		userSearchPage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.sendKeysToSearchKeyword("Lenovo");

		userSearchPage.clickSearchButton();

		Assert.assertTrue(userSearchPage.verifyAllDisplayedProductsContainsKeyName("Lenovo"));
	}

	@Test
	public void Search_04_Absolute_Name_Data() {
		Assert.assertTrue(userSearchPage.isFooterCustomerServiceLinkDisplayedByLinkText("Search"));

		userSearchPage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.sendKeysToSearchKeyword("Lenovo Thinkpad X1 Carbon Laptop");

		userSearchPage.clickSearchButton();

		Assert.assertTrue(userSearchPage.verifyDisplayedProductByName("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
