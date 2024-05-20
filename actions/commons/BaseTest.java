package commons;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver initWebDriverAndNavigateToPage(String browserName, String pageUrl) {
		switch (browserName.toLowerCase()) {
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;
		case "safari":
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("'" + browserName.toUpperCase() + "' Browser is invalid.");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(pageUrl);
		return driver;
	}

	protected void closeWebDriver() {
		if (driver != null) {
			try {
				driver.manage().deleteAllCookies();
				driver.quit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				String osName = GlobalConstants.OS_NAME.toLowerCase();
				String browserInfo = driver.toString().toLowerCase();
				String browserDriver = null;
				String cmd = null;

				try {
					System.out.println("Browser info: " + browserInfo);

					if (browserInfo.contains("firefox")) {
						browserDriver = "geckodriver";
					} else if (browserInfo.contains("chrome")) {
						browserDriver = "chromedriver";
					} else if (browserInfo.contains("edge")) {
						browserDriver = "msedgedriver";
					} else {
						browserDriver = "safaridriver";
					}

					System.out.println("Browser driver: " + browserDriver);

					System.out.println("OS name: " + osName);

					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriver + "*\"";
					} else {
						cmd = "pkill " + browserDriver;
					}

					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				} catch (IOException | InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
