package pageObjects.user.myAccount;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserOrdersPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserOrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
