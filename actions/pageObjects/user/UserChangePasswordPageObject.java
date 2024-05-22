package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserChangePasswordPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
