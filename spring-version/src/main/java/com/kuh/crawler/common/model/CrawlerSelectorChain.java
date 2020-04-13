package com.kuh.crawler.common.model;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuh
 * @since 2020.04.13
 */

public class CrawlerSelectorChain extends ArrayList<CrawlerSelector> {

    private CrawlerSelectorType selectorType;

    public CrawlerSelectorChain(CrawlerSelectorType selectorType) {
        this.selectorType = selectorType;
    }

    public CrawlerSelectorType getSelectorType() {
        return this.selectorType;
    }

    public CrawlerSelectorChain chain(String selectorName) {
        CrawlerSelector selector = new CrawlerSelector(this.selectorType, selectorName);
        this.add(selector);
        return this;
    }

}
