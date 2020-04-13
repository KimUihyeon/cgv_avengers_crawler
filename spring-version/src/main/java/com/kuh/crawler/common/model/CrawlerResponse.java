package com.kuh.crawler.common.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author kuh
 * @since 2020.04.13
 */

@Getter
@Builder
public class CrawlerResponse<T> {

    private int delay;
    private T data;

}
