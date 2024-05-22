package nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
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

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dongauto" + getRandomNumber() + "@gmail.com";
		password = "javaSe3";
		company = "D-SDET";
		gender = "Male";
		day = "13";
		month = "October";
		year = "1997";

		userRegisterPage = (UserRegisterPageObject) userHomePage.clickHeaderLinkByLinkText("Register");

		userHomePage = userRegisterPage.registerNewUserAccountWithAllData(firstName, lastName, emailAddress, password, company, gender, day, month, year);

		userHomePage.clickHeaderLinkByLinkText("Log out");

		closeWebDriver();
	}

}
