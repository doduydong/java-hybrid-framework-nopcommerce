package nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import nopcommerce.data.UserData.UserDefaultInfo;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;

public class Common_01_User_Register extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	public static String firstName, lastName, emailAddress, password, company, gender, day, month, year;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = initWebDriverAndNavigateToPage(browserName, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = UserDefaultInfo.FIRSTNAME;
		lastName = UserDefaultInfo.LASTNAME;
		emailAddress = UserDefaultInfo.EMAIL_USERNAME + getRandomNumber() + UserDefaultInfo.EMAIL_DOMAIN;
		password = UserDefaultInfo.PASSWORD;
		company = UserDefaultInfo.COMPANY;
		gender = UserDefaultInfo.GENDER;
		day = UserDefaultInfo.DOB_DAY;
		month = UserDefaultInfo.DOB_MONTH;
		year = UserDefaultInfo.DOB_YEAR;

		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		userHomePage = userRegisterPage.registerNewUserAccountWithAllData(firstName, lastName, emailAddress, password, company, gender, day, month, year);

		userHomePage.clickHeaderLinkByLinkText("Log out");

		closeWebDriver();
	}

}
