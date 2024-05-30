package patternObjects;

public class UserPatternObjectsUIs {

	public static final String HEADER_LINK_BY_LINKTEXT = "//div[@class='header-links']//a[text()='%s']";
	public static final String FOOTER_CUSTOMER_SERVICE_LINK_BY_LINKTEXT = "//div[@class='footer']//div[@class='footer-block customer-service']//a[text()='%s']";
	public static final String MY_ACCOUNT_SIDEBAR_LINK_BY_LINKTEXT = "//strong[text()='My account']/parent::div/following-sibling::div//a[text()='%s']";
	public static final String MY_ACCOUNT_PAGE_TITLE_BY_PAGENAME = "//div[contains(@class,'account-page')]//h1[text()='My account - %s']";
	public static final String BAR_NOTIFICATION_SUCCESS = "//div[@class='bar-notification success']";
	public static final String BAR_NOTIFICATION_SUCCESS_CLOSE_ICON = BAR_NOTIFICATION_SUCCESS + "//span[@class='close']";
	public static final String HEADER_MENU_BY_LINKTEXT = "//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String SUB_CATEGORIES_BY_MENU_AND_LINKTEXT = "//a[contains(text(),'%s')]/following-sibling::ul[@class='sublist']//a[contains(text(),'%s')]";
	public static final String CATEGORY_PAGE_TITLE_BY_PAGENAME = "//div[contains(@class,'category-page')]//h1[text()='%s']";

}
