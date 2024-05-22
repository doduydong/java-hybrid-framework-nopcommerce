package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserOrdersPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
