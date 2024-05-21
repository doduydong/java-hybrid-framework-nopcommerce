package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickRegisterHeaderLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_HEADER_LINK);
		clickElement(driver, UserHomePageUI.REGISTER_HEADER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public void clickLogoutHeaderLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGOUT_HEADER_LINK);
		clickElement(driver, UserHomePageUI.LOGOUT_HEADER_LINK);
	}

	public UserLoginPageObject clickLoginHeaderLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_HEADER_LINK);
		clickElement(driver, UserHomePageUI.LOGIN_HEADER_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountHeaderLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_HEADER_LINK);
	}

	public boolean isLogoutHeaderLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_HEADER_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_HEADER_LINK);
	}

}
