package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;
import pageUIs.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isGenderRadioButtonByLabelSelected(String gender) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON_BY_LABEL, gender);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON_BY_LABEL, gender);
	}

	public boolean isNewsletterCheckboxChecked() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}

	public String getDayDropdownValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		return getSelectedOptionTextInDefaultDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getMonthDropdownValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectedOptionTextInDefaultDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getYearDropdownValue() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectedOptionTextInDefaultDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendKeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToCompanyTextbox(String company) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		sendKeysToElement(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, company);
	}

	public void checkGenderRadioButtonByLabel(String gender) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON_BY_LABEL, gender);
		checkDefaultCheckboxOrRadioButton(driver, UserCustomerInfoPageUI.GENDER_RADIO_BUTTON_BY_LABEL, gender);
	}

	public void uncheckNewsletterCheckbox() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		uncheckDefaultCheckbox(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}

	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		selectOptionInDefaultDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN, year);
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
	}

}
