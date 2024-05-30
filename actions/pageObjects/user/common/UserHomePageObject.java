package pageObjects.user.common;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserHomePageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
