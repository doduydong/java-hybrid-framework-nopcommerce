package pageObjects.user.myAccount;

import org.openqa.selenium.WebDriver;

import patternObjects.UserPatternObjectsActions;

public class UserDownloadableProductsPageObject extends UserPatternObjectsActions {
	private WebDriver driver;

	public UserDownloadableProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
