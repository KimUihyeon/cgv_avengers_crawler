package com.kuh.crawler.common.model;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kuh
 * @since 2020.04.13
 */

@RequiredArgsConstructor
public class CrawlerSelectorChain extends ArrayList<CrawlerSelector> {
    private final CrawlerSelectorType selectorType;

}
