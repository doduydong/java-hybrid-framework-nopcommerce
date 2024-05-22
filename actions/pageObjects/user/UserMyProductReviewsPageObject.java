package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserMyProductReviewsPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserMyProductReviewsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
