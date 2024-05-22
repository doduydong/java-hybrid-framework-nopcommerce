package commons;

import org.openqa.selenium.WebDriver;

public class UserPatternObjects extends BasePage {
	private WebDriver driver;

	public UserPatternObjects(WebDriver driver) {
		this.driver = driver;
	}

	private static final String HEADER_LINK_BY_LINKTEXT = "//div[@class='header-links']//a[text()='%s']";

	public boolean isHeaderLinkDisplayedByLinkText(String linkText) {
		waitForElementVisible(driver, HEADER_LINK_BY_LINKTEXT, linkText);
		return isElementDisplayed(driver, HEADER_LINK_BY_LINKTEXT, linkText);
	}

	public UserPatternObjects clickHeaderLinkByLinkText(String linkText) {
		waitForElementClickable(driver, HEADER_LINK_BY_LINKTEXT, linkText);
		clickElement(driver, HEADER_LINK_BY_LINKTEXT, linkText);
		switch (linkText) {
		case "Register":
			return PageGeneratorManager.getUserRegisterPage(driver);
		case "Log in":
			return PageGeneratorManager.getUserLoginPage(driver);
		case "Log out":
			return PageGeneratorManager.getUserHomePage(driver);
		default:
			throw new RuntimeException("'" + linkText.toUpperCase() + "' Header link is invalid.");
		}
	}

}
