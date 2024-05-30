package pageObjects.user.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageUIs.user.common.UserNotebooksPageUI;
import pageUIs.user.common.UserSearchPageUI;
import patternObjects.UserPatternObjectsActions;

public class UserNotebooksPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserNotebooksPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectSortByDropdown(String optionText) {
		waitForElementClickable(driver, UserNotebooksPageUI.SORT_BY_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserNotebooksPageUI.SORT_BY_DROPDOWN, optionText);
		waitForElementVisible(driver, UserNotebooksPageUI.AJAX_LOADING);
		waitForElementInvisible(driver, UserNotebooksPageUI.AJAX_LOADING);
	}

	public boolean isProductNamesSortedAscending() {
		waitForAllElementsVisible(driver, UserNotebooksPageUI.PRODUCT_ITEM_NAME);
		List<WebElement> productNames = getListWebElement(driver, UserNotebooksPageUI.PRODUCT_ITEM_NAME);
		List<String> productNamesList = new ArrayList<>();
		for (WebElement name : productNames) {
			productNamesList.add(name.getText());
		}
		List<String> productNamesSorted = new ArrayList<>(productNamesList);
		Collections.sort(productNamesSorted);
		for (String name : productNamesSorted) {
			System.out.println(name);
		}
		return productNamesList.equals(productNamesSorted);
	}

	public boolean isProductNamesSortedDescending() {
		waitForAllElementsVisible(driver, UserNotebooksPageUI.PRODUCT_ITEM_NAME);
		List<WebElement> productNames = getListWebElement(driver, UserNotebooksPageUI.PRODUCT_ITEM_NAME);
		List<String> productNamesList = new ArrayList<>();
		for (WebElement name : productNames) {
			productNamesList.add(name.getText());
		}
		List<String> productNamesSorted = new ArrayList<>(productNamesList);
		Collections.sort(productNamesSorted, Collections.reverseOrder());
		for (String name : productNamesSorted) {
			System.out.println(name);
		}
		return productNamesList.equals(productNamesSorted);
	}

	public void selectDisplayDropdown(String optionText) {
		waitForElementClickable(driver, UserNotebooksPageUI.DISPLAY_BY_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserNotebooksPageUI.DISPLAY_BY_DROPDOWN, optionText);
		waitForElementVisible(driver, UserNotebooksPageUI.AJAX_LOADING);
		waitForElementInvisible(driver, UserNotebooksPageUI.AJAX_LOADING);
	}

	public boolean verifyNumberOfDisplayedItems(int number) {
		boolean verify = true;
		waitForAllElementsVisible(driver, UserSearchPageUI.PRODUCT_ITEM_NAME);
		List<WebElement> productItems = getListWebElement(driver, UserSearchPageUI.PRODUCT_ITEM_NAME);
		int numberOfItems = productItems.size();
		if (numberOfItems <= number) {
			return verify;
		} else {
			verify = false;
		}
		return verify;
	}

}
