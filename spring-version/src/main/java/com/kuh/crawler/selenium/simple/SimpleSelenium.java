package com.kuh.crawler.selenium.simple;

import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorChain;
import com.kuh.crawler.selenium.base.SeleniumCrawler;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author kuh
 * @since 2020.04.13
 */
public class SimpleSelenium {

    private SeleniumCrawler SeleniumCrawler;

    public SimpleSelenium() {
        this.SeleniumCrawler = new SeleniumCrawler();
    }

    public List<String> getText(String url, CrawlerSelectorChain selectors) {

        List<String> results = this.SeleniumCrawler.run(url, selectors, (el) -> el.getText());
        return results;
    }

    public String getText(String url, CrawlerSelector selector) {
        System.out.println(selector.toString());

        String result = this.SeleniumCrawler.run(url, selector, (el) -> el.getText());
        return result;
    }
}
