package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.UserSearchPageObject;

public class UserPatternObjects extends BasePage {
	private WebDriver driver;

	public UserPatternObjects(WebDriver driver) {
		this.driver = driver;
	}

	private static final String HEADER_LINK_BY_LINKTEXT = "//div[@class='header-links']//a[text()='%s']";
	private static final String FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT = "//div[@class='footer']//div[@class='footer-block customer-service']//a[text()='%s']";
	private static final String MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT = "//strong[text()='My account']/parent::div/following-sibling::div//a[text()='%s']";
	private static final String MY_ACCOUNT_PAGE_TITLE_BY_PAGENAME = "//div[contains(@class,'account-page')]//h1[text()='My account - %s']";
	private static final String BAR_NOTIFICATION_SUCCESS = "//div[@class='bar-notification success']";
	private static final String BAR_NOTIFICATION_SUCCESS_CLOSE_ICON = BAR_NOTIFICATION_SUCCESS + "//span[@class='close']";

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

}
