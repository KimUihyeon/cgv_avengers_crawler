package com.kuh.crawler.config;

/**
 * WebDriver System Setting Data
 *
 * @author kuh
 * @since 2020.04.13
 */
public class WebDriverProperty {

    public static final String WEB_DRIVER_CHROME_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_FIREFOX_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_SAFARI_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_IE_ID = "webdriver.chrome.driver";

    private static final String WEB_DRIVER_MAC = "D:/selenium/chromedriver_win32/chromedriver.exe";
    private static final String WEB_DRIVER_WINDOW = "D:/selenium/chromedriver_win32/chromedriver.exe";
    private static final String WEB_DRIVER_LINUX = "D:/selenium/chromedriver_win32/chromedriver.exe";

    public static final String getDriverPath() {
        String exceptionMessage = "지원하지 않는 OS 입니다.";
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            return WEB_DRIVER_WINDOW;
        } else if (os.contains("mac")) {
            return WEB_DRIVER_MAC;
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            throw new UnsupportedOperationException(exceptionMessage);
        } else if (os.contains("linux")) {
            return WEB_DRIVER_LINUX;
        } else {
            throw new UnsupportedOperationException(exceptionMessage);
        }
    }
}
