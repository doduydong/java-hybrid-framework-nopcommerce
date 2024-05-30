package pageObjects.user.myAccount;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserBackInStockSubscriptionsPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserBackInStockSubscriptionsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
