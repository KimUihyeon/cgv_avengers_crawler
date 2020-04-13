package com.kuh.crawler.selenium.simple;

import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorType;

import java.time.LocalDateTime;

/**
 * @author kuh
 * @since 2020.04.14
 */
public class SimpleSeleniumThead {

    private SimpleSelenium simpleSelenium;

    public SimpleSeleniumThead() {
        this.simpleSelenium = new SimpleSelenium();
    }

    public void start(String url, CrawlerSelector selector, int timeOut) {


        Thread thread = new Thread(() -> {

            try {
                while (true) {
                    LocalDateTime date = LocalDateTime.now();
                    String data = simpleSelenium.getText(url, selector);

                    String result = "크롤링 -> " + date + " " +
                            "\n------------------------- " +
                            "\n" + data;

                    System.out.println(result);

                    Thread.sleep(timeOut);
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}
