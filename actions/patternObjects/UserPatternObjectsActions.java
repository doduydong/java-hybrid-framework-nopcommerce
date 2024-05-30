package patternObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.user.common.UserSearchPageObject;

public class UserPatternObjectsActions extends BasePage {
	private WebDriver driver;

	public UserPatternObjectsActions(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isHeaderLinkDisplayedByLinkText(String linkText) {
		waitForElementVisible(driver, UserPatternObjectsUIs.HEADER_LINK_BY_LINKTEXT, linkText);
		return isElementDisplayed(driver, UserPatternObjectsUIs.HEADER_LINK_BY_LINKTEXT, linkText);
	}

	public UserPatternObjectsActions clickHeaderLinkByLinkText(String linkText) {
		waitForElementClickable(driver, UserPatternObjectsUIs.HEADER_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, UserPatternObjectsUIs.HEADER_LINK_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Register":
			return PageGeneratorManager.getUserRegisterPage(driver);
		case "Log in":
			return PageGeneratorManager.getUserLoginPage(driver);
		case "Log out":
			return PageGeneratorManager.getUserHomePage(driver);
		case "My account":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Header link is invalid.");
		}
	}

	public boolean isFooterCustomerServiceLinkDisplayedByLinkText(String linkText) {
		waitForElementVisible(driver, UserPatternObjectsUIs.FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
		return isElementDisplayed(driver, UserPatternObjectsUIs.FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
	}

	public UserSearchPageObject clickFooterCustomerServiceLinkByLinkText(String linkText) {
		waitForElementClickable(driver, UserPatternObjectsUIs.FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, UserPatternObjectsUIs.FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Search":
			return PageGeneratorManager.getUserSearchPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Header link is invalid.");
		}
	}

	public boolean isMyAccountSidebarLinkDisplayedByLinkText(String linkText) {
		waitForElementVisible(driver, UserPatternObjectsUIs.MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
		return isElementDisplayed(driver, UserPatternObjectsUIs.MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
	}

	public UserPatternObjectsActions clickMyAccountSidebarLinkByLinkText(String linkText) {
		waitForElementClickable(driver, UserPatternObjectsUIs.MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, UserPatternObjectsUIs.MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPage(driver);
		case "Orders":
			return PageGeneratorManager.getUserOrdersPage(driver);
		case "Downloadable products":
			return PageGeneratorManager.getUserDownloadableProductsPage(driver);
		case "Back in stock subscriptions":
			return PageGeneratorManager.getUserBackInStockSubscriptionsPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointsPage(driver);
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewsPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' My account sidebar link is invalid.");
		}
	}

	public boolean isMyAccountPageTitleDisplayedByPageName(String pageName) {
		waitForElementVisible(driver, UserPatternObjectsUIs.MY_ACCOUNT_PAGE_TITLE_BY_PAGENAME, pageName);
		return isElementDisplayed(driver, UserPatternObjectsUIs.MY_ACCOUNT_PAGE_TITLE_BY_PAGENAME, pageName);
	}

	public String getBarNotificationSuccessMessage() {
		waitForElementVisible(driver, UserPatternObjectsUIs.BAR_NOTIFICATION_SUCCESS);
		String message = getElementText(driver, UserPatternObjectsUIs.BAR_NOTIFICATION_SUCCESS);
		waitForElementClickable(driver, UserPatternObjectsUIs.BAR_NOTIFICATION_SUCCESS_CLOSE_ICON);
		clickElement(driver, UserPatternObjectsUIs.BAR_NOTIFICATION_SUCCESS_CLOSE_ICON);
		waitForElementInvisible(driver, UserPatternObjectsUIs.BAR_NOTIFICATION_SUCCESS);
		return message;
	}

	public UserPatternObjectsActions clickHeaderMenuByLinkText(String linkText) {
		waitForElementClickable(driver, UserPatternObjectsUIs.HEADER_MENU_BY_LINKTEXT, linkText);
		clickElement(driver, UserPatternObjectsUIs.HEADER_MENU_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Computers":
			return PageGeneratorManager.getUserComputersPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Header menu link is invalid.");
		}
	}

	public boolean isCategoriesPageTitleDisplayedByPageName(String pageName) {
		waitForElementVisible(driver, UserPatternObjectsUIs.CATEGORY_PAGE_TITLE_BY_PAGENAME, pageName);
		return isElementDisplayed(driver, UserPatternObjectsUIs.CATEGORY_PAGE_TITLE_BY_PAGENAME, pageName);
	}

	public UserPatternObjectsActions clickSubCategoriesByMenuAndLinkText(String menuName, String linkText) {
		waitForElementClickable(driver, UserPatternObjectsUIs.SUB_CATEGORIES_BY_MENU_AND_LINKTEXT, menuName, linkText);
		clickElement(driver, UserPatternObjectsUIs.SUB_CATEGORIES_BY_MENU_AND_LINKTEXT, menuName, linkText);
		switch (linkText) {
		case "Notebooks":
			return PageGeneratorManager.getUserNotebooksPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Sub category link is invalid.");
		}
	}

}
