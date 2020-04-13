package com.kuh.crawler.common.interfacies;

import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorChain;

import java.util.List;
import java.util.function.Function;

/**
 * Crawler Interface
 *
 * @author kuh
 * @since 2020.04.13
 */
public interface ICrawler<T> {

    /**
     * Crawling run
     *
     * @param url                Crawling Url
     * @param selectors          Dom Element Selector Collection
     * @param individualFunction Crawling WebElement Cast function
     * @param <R>                Crawling result return Type
     * @return
     */
    <R> List<R> run(String url, CrawlerSelectorChain selectors, Function<T, R> individualFunction);


    /**
     * Crawler run
     *
     * @param url                Crawling Url
     * @param selector           Dom Element Selector
     * @param individualFunction Crawling WebElement Cast function
     * @param <R>                Crawling result return Type
     * @return
     */
    <R> R run(String url, CrawlerSelector selector, Function<T, R> individualFunction);

}
