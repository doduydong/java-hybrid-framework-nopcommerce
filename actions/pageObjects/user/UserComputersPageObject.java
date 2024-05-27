package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserComputersPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
