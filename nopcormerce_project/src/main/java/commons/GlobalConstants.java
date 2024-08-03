package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_NOPCOMMERCE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_NOCOMMERCE_URL ="https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final long LONG_TIMEOUT = 30;
	
	public static final String PROJECT_PATH =System.getProperty("user.dir");
	//
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE= PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG= PROJECT_PATH + File.separator + "browserLog";
	
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "extendV2"+File.separator;

}
