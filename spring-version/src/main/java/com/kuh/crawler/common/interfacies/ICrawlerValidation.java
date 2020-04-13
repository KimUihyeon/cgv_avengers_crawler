package com.kuh.crawler.common.interfacies;

import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorChain;

/**
 * Crawler Require data validation Interface
 *
 * @author kuh
 * @since 2020.04.13
 */

public interface ICrawlerValidation {

    /**
     * selector empty validation
     *
     * @param selector
     */
    void requiredValidation(CrawlerSelector selector);

    /**
     * selectors empty validation
     *
     * @param selectors
     */
    void requiredValidation(CrawlerSelectorChain selectors);
}
