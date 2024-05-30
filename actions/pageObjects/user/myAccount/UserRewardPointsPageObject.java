package pageObjects.user.myAccount;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserRewardPointsPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserRewardPointsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
