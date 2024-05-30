package pageObjects.user.common;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserComputersPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
