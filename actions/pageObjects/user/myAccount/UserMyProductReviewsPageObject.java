package pageObjects.user.myAccount;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserMyProductReviewsPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserMyProductReviewsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
