package com.kuh.crawler.selenium.interfacies;

import com.kuh.crawler.common.interfacies.ICrawler;
import com.kuh.crawler.common.interfacies.ICrawlerValidation;
import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorChain;
import org.openqa.selenium.WebElement;

/**
 * @author kuh
 * @since 2020.04.13
 */

public interface ISeleniumCrawler extends ICrawler<WebElement>, ICrawlerValidation {

}
