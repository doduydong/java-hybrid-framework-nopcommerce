package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.UserPatternObjects;

public class UserDownloadableProductsPageObject extends UserPatternObjects {
	private WebDriver driver;

	public UserDownloadableProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
