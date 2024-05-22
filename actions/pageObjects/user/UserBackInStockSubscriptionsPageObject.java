package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserBackInStockSubscriptionsPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserBackInStockSubscriptionsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
