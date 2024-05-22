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

}
