package com.task.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseBrand implements IParser{

    @Override
    public String parser(Document value) {
        String brands = "";
        {
            Elements brandEl = value.select("p[data-test-id=BrandName]");
            brands = brandEl.text();
        }
        return brands;
    }

}
