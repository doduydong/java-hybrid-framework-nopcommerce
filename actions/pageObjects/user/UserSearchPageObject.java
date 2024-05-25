package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.UserPatternObjects;
import pageUIs.user.UserSearchPageUI;

public class UserSearchPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isSearchPageTitleDisplayed() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_PAGE_TITLE);
		return isElementDisplayed(driver, UserSearchPageUI.SEARCH_PAGE_TITLE);
	}

	public void clickSearchButton() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getSearchErrorMessage() {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.SEARCH_ERROR_MESSAGE);
	}

	public void sendKeysToSearchKeyword(String keysToSend) {
		waitForElementVisible(driver, UserSearchPageUI.KEYWORD_TEXTBOX);
		sendKeysToElement(driver, UserSearchPageUI.KEYWORD_TEXTBOX, keysToSend);
	}

	public String getNoResultMessage() {
		waitForElementVisible(driver, UserSearchPageUI.NO_RESULT_MESSAGE);
		return getElementText(driver, UserSearchPageUI.NO_RESULT_MESSAGE);
	}

	public boolean verifyAllDisplayedProductsContainsKeyName(String keyName) {
		boolean verify = true;
		waitForAllElementsVisible(driver, UserSearchPageUI.PRODUCT_ITEM_NAME);
		List<WebElement> productItems = getListWebElement(driver, UserSearchPageUI.PRODUCT_ITEM_NAME);
		for (WebElement item : productItems) {
			if (item.getText().contains(keyName)) {
				return verify;
			} else {
				verify = false;
			}
		}
		return verify;
	}

	public boolean verifyDisplayedProductByName(String productName) {
		waitForAllElementsVisible(driver, UserSearchPageUI.PRODUCT_ITEM_NAME);
		List<WebElement> productItems = getListWebElement(driver, UserSearchPageUI.PRODUCT_ITEM_NAME);
		if (productItems.size() == 1) {
			return productItems.get(0).getText().equals(productName);
		} else {
			return false;
		}
	}

}
