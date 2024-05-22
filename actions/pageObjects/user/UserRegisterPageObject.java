package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.UserPatternObjects;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendKeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void sendKeysToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void sendKeysToCompanyTextbox(String company) {
		waitForElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, company);
	}

	public void checkGenderRadioButtonByLabel(String gender) {
		waitForElementClickable(driver, UserRegisterPageUI.GENDER_RADIO_BUTTON_BY_LABEL, gender);
		checkDefaultCheckboxOrRadioButton(driver, UserRegisterPageUI.GENDER_RADIO_BUTTON_BY_LABEL, gender);
	}

	public void checkNewsletterCheckbox() {
		waitForElementClickable(driver, UserRegisterPageUI.NEWSLETTER_CHECKBOX);
		checkDefaultCheckboxOrRadioButton(driver, UserRegisterPageUI.NEWSLETTER_CHECKBOX);
	}

	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
	}

	public String getFirstNameTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}

	public String getLastNameTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}

	public String getEmailTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getPasswordTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordTextboxErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public UserHomePageObject clickContinueButton() {
		waitForElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		clickElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getExistingEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public UserHomePageObject registerNewUserAccountWithMandatoryData(String firstName, String lastName, String emailAddress, String password) {
		sendKeysToFirstNameTextbox(firstName);
		sendKeysToLastNameTextbox(lastName);
		sendKeysToEmailTextbox(emailAddress);
		sendKeysToPasswordTextbox(password);
		sendKeysToConfirmPasswordTextbox(password);
		clickRegisterButton();
		return clickContinueButton();
	}

	public UserHomePageObject registerNewUserAccountWithAllData(String firstName, String lastName, String emailAddress, String password, String company, String gender, String day, String month, String year) {
		checkGenderRadioButtonByLabel(gender);
		sendKeysToFirstNameTextbox(firstName);
		sendKeysToLastNameTextbox(lastName);
		selectDayDropdown(day);
		selectMonthDropdown(month);
		selectYearDropdown(year);
		sendKeysToEmailTextbox(emailAddress);
		sendKeysToCompanyTextbox(company);
		checkNewsletterCheckbox();
		sendKeysToPasswordTextbox(password);
		sendKeysToConfirmPasswordTextbox(password);
		clickRegisterButton();
		return clickContinueButton();
	}

}
