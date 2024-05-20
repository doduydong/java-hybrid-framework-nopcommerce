package commons;

import java.io.File;

public class GlobalConstants {

	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";

	public static final String OS_NAME = System.getProperty("os.name");

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String SEPARATOR_CHAR = File.separator;
	public static final String UPLOAD_FILES_PATH = PROJECT_PATH + SEPARATOR_CHAR + "uploadFiles" + SEPARATOR_CHAR;

	public static final int LONG_TIMEOUT = 30;
	public static final int SHORT_TIMEOUT = 5;
	public static final int ONE_SEC = 1;

}
