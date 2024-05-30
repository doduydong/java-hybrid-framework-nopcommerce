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
import pageObjects.user.common.UserComputersPageObject;
import pageObjects.user.common.UserHomePageObject;
import pageObjects.user.common.UserLoginPageObject;
import pageObjects.user.common.UserNotebooksPageObject;

public class User_04_Menu_01_Computers_Notebooks extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserComputersPageObject userComputersPage;
	private UserNotebooksPageObject userNotebooksPage;
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
	public void Computers_01_Notebooks_Sub_Menu() {
		userComputersPage = (UserComputersPageObject) userHomePage.clickHeaderMenuByLinkText("Computers");
		Assert.assertTrue(userComputersPage.isCategoriesPageTitleDisplayedByPageName("Computers"));

		userNotebooksPage = (UserNotebooksPageObject) userComputersPage.clickSubCategoriesByMenuAndLinkText("Computers", "Notebooks");
		Assert.assertTrue(userNotebooksPage.isCategoriesPageTitleDisplayedByPageName("Notebooks"));
	}

	@Test
	public void Computers_02_Notebooks_Sort_Products_By_Name() {
		userNotebooksPage.selectSortByDropdown("Name: A to Z");

		Assert.assertTrue(userNotebooksPage.isProductNamesSortedAscending());

		userNotebooksPage.selectSortByDropdown("Name: Z to A");

		Assert.assertTrue(userNotebooksPage.isProductNamesSortedDescending());
	}

	@Test
	public void Computers_03_Notebooks_Display_Products_Per_Page() {
		userNotebooksPage.clickSubCategoriesByMenuAndLinkText("Computers", "Notebooks");

		Assert.assertTrue(userNotebooksPage.isCategoriesPageTitleDisplayedByPageName("Notebooks"));

		userNotebooksPage.selectDisplayDropdown("3");

		Assert.assertTrue(userNotebooksPage.verifyNumberOfDisplayedItems(3));

		userNotebooksPage.selectDisplayDropdown("6");

		Assert.assertTrue(userNotebooksPage.verifyNumberOfDisplayedItems(6));

		userNotebooksPage.selectDisplayDropdown("9");

		Assert.assertTrue(userNotebooksPage.verifyNumberOfDisplayedItems(9));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeWebDriver();
	}

}
