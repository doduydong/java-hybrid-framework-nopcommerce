package pageObjects.user.myAccount;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserAddressesPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
