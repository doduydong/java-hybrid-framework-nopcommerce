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
import pageObjects.user.common.UserHomePageObject;
import pageObjects.user.common.UserLoginPageObject;
import pageObjects.user.common.UserSearchPageObject;

public class User_03_Search_02_Advance extends BaseTest {
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
	public void Advanced_Search_01_Without_Sub_Categories() {
		Assert.assertTrue(userHomePage.isFooterCustomerServiceLinkDisplayedByLinkText("Search"));

		userSearchPage = userHomePage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.sendKeysToSearchKeyword("Mac");

		userSearchPage.checkAdvancedSearchCheckbox();

		userSearchPage.selectCategoryDropdown("Computers");

		userSearchPage.clickSearchButton();

		Assert.assertEquals(userSearchPage.getNoResultMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Advanced_Search_02_With_Sub_Categories() {
		userSearchPage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.sendKeysToSearchKeyword("Mac");

		userSearchPage.checkAdvancedSearchCheckbox();

		userSearchPage.selectCategoryDropdown("Computers");

		userSearchPage.checkAutomaticallySearchSubCategoriesCheckbox();

		userSearchPage.clickSearchButton();

		Assert.assertTrue(userSearchPage.verifyAllDisplayedProductsContainsKeyName("Mac"));
	}

	@Test
	public void Advanced_Search_03_Incorrect_Manufacturer() {
		Assert.assertTrue(userHomePage.isFooterCustomerServiceLinkDisplayedByLinkText("Search"));

		userSearchPage = userHomePage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.sendKeysToSearchKeyword("Mac");

		userSearchPage.checkAdvancedSearchCheckbox();

		userSearchPage.selectManufacturerDropdown("HP");

		userSearchPage.clickSearchButton();

		Assert.assertEquals(userSearchPage.getNoResultMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Advanced_Search_04_Correct_Manufacturer() {
		Assert.assertTrue(userHomePage.isFooterCustomerServiceLinkDisplayedByLinkText("Search"));

		userSearchPage = userHomePage.clickFooterCustomerServiceLinkByLinkText("Search");

		Assert.assertTrue(userSearchPage.isSearchPageTitleDisplayed());

		userSearchPage.sendKeysToSearchKeyword("Mac");

		userSearchPage.checkAdvancedSearchCheckbox();

		userSearchPage.selectManufacturerDropdown("Apple");

		userSearchPage.clickSearchButton();

		Assert.assertTrue(userSearchPage.verifyAllDisplayedProductsContainsKeyName("Mac"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
