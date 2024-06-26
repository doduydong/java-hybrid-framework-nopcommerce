package pageUIs.user.common;

public class UserRegisterPageUI {

	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";

	public static final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@class='field-validation-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";

	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String CONTINUE_BUTTON = "//a[contains(@class,'register-continue-button')]";

	public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//div[contains(@class,'validation-summary-errors')]";

	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String GENDER_RADIO_BUTTON_BY_LABEL = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String NEWSLETTER_CHECKBOX = "//input[@id='Newsletter']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";

}
