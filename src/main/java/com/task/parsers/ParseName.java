package com.task.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ParseName implements IParser{

    @Override
    public String parser(Document value) {
        String name = "";
        {
            try {
                Elements nameEl = value.select("div[data-test-id=ProductName]");
                name = nameEl.text();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
