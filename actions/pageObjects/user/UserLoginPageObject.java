package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.UserPatternObjects;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserHomePageObject clickLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getEmailTextboxErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getLoginUnsuccessErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_UNSUCCESS_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_UNSUCCESS_ERROR_MESSAGE);
	}

}
