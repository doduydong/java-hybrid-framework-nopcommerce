package pageUIs.user.myAccount;

public class UserCustomerInfoPageUI {

	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";

	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String GENDER_RADIO_BUTTON_BY_LABEL = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String NEWSLETTER_CHECKBOX = "//input[@id='Newsletter']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";

	public static final String SAVE_BUTTON = "//button[@id='save-info-button']";

}
