package com.kuh.crawler;

import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorType;
import com.kuh.crawler.selenium.simple.SimpleSelenium;
import com.kuh.crawler.selenium.simple.SimpleSeleniumThead;

/**
 * @author kuh
 * @since 2020.04.13
 */
public class CrawlerApplication {

    public static void main(String[] arg) {
        System.out.println("test");


        String url = "http://www.juso.go.kr/openIndexPage.do";
        CrawlerSelector selector = new CrawlerSelector(CrawlerSelectorType.ID, "clear");

        SimpleSeleniumThead seleniumThead = new SimpleSeleniumThead();
        seleniumThead.start(url, selector, 1000 * 10);
    }
}
