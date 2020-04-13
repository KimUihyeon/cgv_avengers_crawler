package com.kuh.crawler.selenium.base;

import com.kuh.crawler.common.model.CrawlerSelector;
import com.kuh.crawler.common.model.CrawlerSelectorChain;
import com.kuh.crawler.common.model.CrawlerSelectorType;
import com.kuh.crawler.config.MsgConfig;
import com.kuh.crawler.selenium.interfacies.ISeleniumCrawler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author kuh
 * @since 2020.04.13
 */
public class SeleniumCrawler implements ISeleniumCrawler {

    public WebDriver webDriver;

    public SeleniumCrawler() {
        this.webDriver = new SeleniumWebDriverFactory.Create().chromeDriver();
    }

    @Override
    public <R> List<R> run(String url, CrawlerSelectorChain selectors, Function<WebElement, R> individualFunction) {
        requiredValidation(selectors);
        this.webDriver.get(url);

        List<R> result = new ArrayList<>();
        for (CrawlerSelector selector : selectors) {
            List<WebElement> elements = this.webDriver.findElements(getBy(selector));
            for (WebElement element : elements) {
                R data = (R) individualFunction.apply(element);
                result.add(data);
            }
        }

        return result;
    }

    @Override
    public <R> R run(String url, CrawlerSelector selector, Function<WebElement, R> individualFunction) {
        CrawlerSelectorChain selectors = new CrawlerSelectorChain(selector.getSelectorType())
                .chain(selector.getSelectorName());

        return run(url, selectors, individualFunction).get(0);
    }

    @Override
    public void requiredValidation(CrawlerSelector selector) {
        if (selector == null || selector.getSelectorName().isEmpty()
                || selector.getSelectorType() == CrawlerSelectorType.NONE) {
            throw new IllegalArgumentException(MsgConfig.IS_SELECTOR_EMPTY_ERROR);
        }

    }

    @Override
    public void requiredValidation(CrawlerSelectorChain selectors) {
        if (selectors == null) {
            throw new IllegalArgumentException(MsgConfig.IS_SELECTOR_EMPTY_ERROR);
        }

        for (CrawlerSelector selector : selectors) {
            requiredValidation(selector);
        }
    }

    private By getBy(CrawlerSelector selector) {

        switch (selector.getSelectorType()) {
            case NONE: {
                throw new IllegalArgumentException(MsgConfig.IS_SELECTOR_EMPTY_ERROR);
            }
            case XPATH: {
                return By.xpath(selector.getSelectorName());
            }
            case ID: {
                return By.id(selector.getSelectorName());
            }
            case CALSS_NAME: {
                return By.className(selector.getSelectorName());
            }
        }

        throw new IllegalArgumentException(MsgConfig.IS_SELECTOR_EMPTY_ERROR);
    }
}
