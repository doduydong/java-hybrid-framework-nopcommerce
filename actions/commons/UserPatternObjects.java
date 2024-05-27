package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.UserSearchPageObject;

public class UserPatternObjects extends BasePage {
	private WebDriver driver;

	public UserPatternObjects(WebDriver driver) {
		this.driver = driver;
	}

	public static final String HEADER_LINK_BY_LINKTEXT = "//div[@class='header-links']//a[text()='%s']";
	public static final String FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT = "//div[@class='footer']//div[@class='footer-block customer-service']//a[text()='%s']";
	public static final String MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT = "//strong[text()='My account']/parent::div/following-sibling::div//a[text()='%s']";
	public static final String MY_ACCOUNT_PAGE_TITLE_BY_PAGENAME = "//div[contains(@class,'account-page')]//h1[text()='My account - %s']";
	public static final String BAR_NOTIFICATION_SUCCESS = "//div[@class='bar-notification success']";
	public static final String BAR_NOTIFICATION_SUCCESS_CLOSE_ICON = BAR_NOTIFICATION_SUCCESS + "//span[@class='close']";
	public static final String HEADER_MENU_BY_LINKTEXT = "//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String SUB_CATEGORIES_BY_MENU_AND_LINKTEXT = "//a[contains(text(),'%s')]/following-sibling::ul[@class='sublist']//a[contains(text(),'%s')]";
	public static final String CATEGORY_PAGE_TITLE_BY_PAGENAME = "//div[contains(@class,'category-page')]//h1[text()='%s']";

	public boolean isHeaderLinkDisplayedByLinkText(String linkText) {
		waitForElementVisible(driver, HEADER_LINK_BY_LINKTEXT, linkText);
		return isElementDisplayed(driver, HEADER_LINK_BY_LINKTEXT, linkText);
	}

	public UserPatternObjects clickHeaderLinkByLinkText(String linkText) {
		waitForElementClickable(driver, HEADER_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, HEADER_LINK_BY_LINKTEXT, linkText);
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
		waitForElementVisible(driver, FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
		return isElementDisplayed(driver, FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
	}

	public UserSearchPageObject clickFooterCustomerServiceLinkByLinkText(String linkText) {
		waitForElementClickable(driver, FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Search":
			return PageGeneratorManager.getUserSearchPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Header link is invalid.");
		}
	}

	public boolean isMyAccountSidebarLinkDisplayedByLinkText(String linkText) {
		waitForElementVisible(driver, MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
		return isElementDisplayed(driver, MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
	}

	public UserPatternObjects clickMyAccountSidebarLinkByLinkText(String linkText) {
		waitForElementClickable(driver, MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT, linkText);
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
		waitForElementVisible(driver, MY_ACCOUNT_PAGE_TITLE_BY_PAGENAME, pageName);
		return isElementDisplayed(driver, MY_ACCOUNT_PAGE_TITLE_BY_PAGENAME, pageName);
	}

	public String getBarNotificationSuccessMessage() {
		waitForElementVisible(driver, BAR_NOTIFICATION_SUCCESS);
		String message = getElementText(driver, BAR_NOTIFICATION_SUCCESS);
		waitForElementClickable(driver, BAR_NOTIFICATION_SUCCESS_CLOSE_ICON);
		clickElement(driver, BAR_NOTIFICATION_SUCCESS_CLOSE_ICON);
		waitForElementInvisible(driver, BAR_NOTIFICATION_SUCCESS);
		return message;
	}

	public UserPatternObjects clickHeaderMenuByLinkText(String linkText) {
		waitForElementClickable(driver, HEADER_MENU_BY_LINKTEXT, linkText);
		clickElement(driver, HEADER_MENU_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Computers":
			return PageGeneratorManager.getUserComputersPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Header menu link is invalid.");
		}
	}

	public boolean isCategoriesPageTitleDisplayedByPageName(String pageName) {
		waitForElementVisible(driver, CATEGORY_PAGE_TITLE_BY_PAGENAME, pageName);
		return isElementDisplayed(driver, CATEGORY_PAGE_TITLE_BY_PAGENAME, pageName);
	}

	public UserPatternObjects clickSubCategoriesByMenuAndLinkText(String menuName, String linkText) {
		waitForElementClickable(driver, SUB_CATEGORIES_BY_MENU_AND_LINKTEXT, menuName, linkText);
		clickElement(driver, SUB_CATEGORIES_BY_MENU_AND_LINKTEXT, menuName, linkText);
		switch (linkText) {
		case "Notebooks":
			return PageGeneratorManager.getUserNotebooksPage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Sub category link is invalid.");
		}
	}

}
