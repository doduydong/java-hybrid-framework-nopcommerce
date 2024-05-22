package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserAddressesPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
