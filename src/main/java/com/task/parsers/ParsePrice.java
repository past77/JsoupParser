package com.task.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParsePrice implements IParser{

    @Override
    public String parser(Document value) {
        String price;
        {
            Elements priceEl = value.select("span[data-test-id=ProductPriceFormattedBasePrice]," +
                    " span[data-test-id=FormattedSalePrice]");
            price = priceEl.text();
        }
        return price;
        }
    }
