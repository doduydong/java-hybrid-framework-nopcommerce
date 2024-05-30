package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.common.UserComputersPageObject;
import pageObjects.user.common.UserHomePageObject;
import pageObjects.user.common.UserLoginPageObject;
import pageObjects.user.common.UserNotebooksPageObject;
import pageObjects.user.common.UserRegisterPageObject;
import pageObjects.user.common.UserSearchPageObject;
import pageObjects.user.myAccount.UserAddressesPageObject;
import pageObjects.user.myAccount.UserBackInStockSubscriptionsPageObject;
import pageObjects.user.myAccount.UserChangePasswordPageObject;
import pageObjects.user.myAccount.UserCustomerInfoPageObject;
import pageObjects.user.myAccount.UserDownloadableProductsPageObject;
import pageObjects.user.myAccount.UserMyProductReviewsPageObject;
import pageObjects.user.myAccount.UserOrdersPageObject;
import pageObjects.user.myAccount.UserRewardPointsPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}

	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}

	public static UserDownloadableProductsPageObject getUserDownloadableProductsPage(WebDriver driver) {
		return new UserDownloadableProductsPageObject(driver);
	}

	public static UserBackInStockSubscriptionsPageObject getUserBackInStockSubscriptionsPage(WebDriver driver) {
		return new UserBackInStockSubscriptionsPageObject(driver);
	}

	public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}

	public static UserComputersPageObject getUserComputersPage(WebDriver driver) {
		return new UserComputersPageObject(driver);
	}

	public static UserNotebooksPageObject getUserNotebooksPage(WebDriver driver) {
		return new UserNotebooksPageObject(driver);
	}

}
