package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserRewardPointsPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserRewardPointsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
