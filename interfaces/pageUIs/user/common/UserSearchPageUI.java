package pageUIs.user.common;

public class UserSearchPageUI {

	public static final String SEARCH_PAGE_TITLE = "//div[@class='page-title']/h1[text()='Search']";
	public static final String SEARCH_BUTTON = "//button[contains(@class,'search-button')]";
	public static final String SEARCH_ERROR_MESSAGE = "//div[@class='warning']";
	public static final String KEYWORD_TEXTBOX = "//input[@class='search-text']";
	public static final String NO_RESULT_MESSAGE = "//div[@class='no-result']";
	public static final String PRODUCT_ITEM = "//div[@class='product-item']";
	public static final String PRODUCT_ITEM_NAME = PRODUCT_ITEM + "//h2[@class='product-title']/a";
	public static final String ADVANCED_SEARCH_CHECKBOX = "//label[text()='Advanced search']/preceding-sibling::input[@type='checkbox']";
	public static final String CATEGORY_DROPDOWN = "//label[text()='Category:']/following-sibling::select";
	public static final String AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX = "//label[text()='Automatically search sub categories']/preceding-sibling::input[@type='checkbox']";
	public static final String MANUFACTURER_DROPDOWN = "//label[text()='Manufacturer:']/following-sibling::select";

}
