package com.kuh.crawler.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author kuh
 * @since 2020.04.13
 */


@Data
@Builder
@AllArgsConstructor
public class CrawlerSelector {

    private CrawlerSelectorType selectorType;
    private String selectorName;

    @Override
    public String toString() {
        return "CrawlerSelector{" +
                "selectorType=" + selectorType +
                ", selectorName='" + selectorName + '\'' +
                '}';
    }
}
