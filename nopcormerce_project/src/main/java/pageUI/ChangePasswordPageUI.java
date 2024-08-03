package pageUI;

public class ChangePasswordPageUI {
	public static final String CHANGE_PASSWORD_BUTTON ="//div[@class='buttons']//button[text()='Change password']";
	public static final String LOG_OUT_LINK = "//div[contains(@class,'header-links')]//a[text()='Log out']";
    public static final String MESSAGE_CHANGE_PASSWORD_SUCCESSFULL="//p[contains(text(),'Password was changed')]";
    public static final String CLICK_CLOSE_ICON = "//div[contains(@class,'bar-notification success')]//span[@title='Close']";
    public static final String INPUT_OLD_PASSWORD ="//input[@id='OldPassword']";
    public static final String INPUT_NEW_PASSWORD ="//input[@id='NewPassword']";
    public static final String INPUT_CONFIRM_PASSWORD ="//input[@id='ConfirmNewPassword']";
}
