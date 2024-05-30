package pageObjects.user.myAccount;

import org.openqa.selenium.WebDriver;

import pageUIs.user.myAccount.UserChangePasswordPageUI;
import patternObjects.UserPatternObjectsActions;

public class UserChangePasswordPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendKeysToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
	}

	public void sendKeysToNewPasswordTextbox(String password) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, password);
	}

	public void sendKeysToConfirmNewPasswordTextbox(String password) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, password);
	}

	public void clickChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getOldPasswordTextboxErrorMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserChangePasswordPageUI.OLD_PASSWORD_ERROR_MESSAGE);
	}

	public String getNewPasswordTextboxErrorMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserChangePasswordPageUI.NEW_PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmNewPasswordTextboxErrorMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_ERROR_MESSAGE);
	}

	public String getChangePasswordErrorMessage() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_ERROR_MESSAGE);
	}

}
