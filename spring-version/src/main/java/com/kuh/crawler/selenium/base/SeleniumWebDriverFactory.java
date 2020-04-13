package com.kuh.crawler.selenium.base;

import com.kuh.crawler.config.WebDriverProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author kuh
 * @since 2020.04.13
 */
public class SeleniumWebDriverFactory {


    public static class Create {

        public WebDriver chromeDriver() {

            System.setProperty(WebDriverProperty.WEB_DRIVER_CHROME_ID,
                    WebDriverProperty.getDriverPath());

            ChromeDriver driver = new ChromeDriver();
//            driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
            driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
            return driver;
            //return new ChromeDriver();
        }

        public WebDriver fireFoxDriver(){

            System.setProperty(WebDriverProperty.WEB_DRIVER_FIREFOX_ID,
                    WebDriverProperty.getDriverPath());

            return new FirefoxDriver();
        }

        public WebDriver safariDriver(){

            System.setProperty(WebDriverProperty.WEB_DRIVER_SAFARI_ID,
                    WebDriverProperty.getDriverPath());

            return new SafariDriver();
        }

        public WebDriver ieDriver(){

            System.setProperty(WebDriverProperty.WEB_DRIVER_IE_ID,
                    WebDriverProperty.getDriverPath());


            return new InternetExplorerDriver();
        }

    }
}
