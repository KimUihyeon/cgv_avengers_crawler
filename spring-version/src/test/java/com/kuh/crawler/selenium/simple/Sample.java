package com.kuh.crawler.selenium.simple;

import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorChain;
import com.kuh.crawler.common.model.CrawlerSelectorType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author kuh
 * @since 2020.04.14
 */
public class Sample {

    @Test
    public void cgv_sample() {
        // given
        String url = "http://www.cgv.co.kr/movies/";
        CrawlerSelectorChain selector = new CrawlerSelectorChain(CrawlerSelectorType.CALSS_NAME).chain("box-contents");

        // when
        SimpleSelenium selenium = new SimpleSelenium();
        List<String> results = selenium.getText(url, selector);


        // then

        results.forEach(s -> {
            String msg = url + "\n-------------------\n" + s + "\n-------------------";
            System.out.println(msg);
        });

        Assert.assertNotNull(results);
        Assert.assertTrue(results.size() > 0);
    }
}
