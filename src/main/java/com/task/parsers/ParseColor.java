package com.task.parsers;

import com.task.CountReq;
import com.task.FinalsWords;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ParseColor {
    public static int i;

    public ArrayList<HashMap<String, Object>>  parseColor(Document value) {

        ArrayList<HashMap<String, Object>> variant = new ArrayList<>();
        HashMap<String, Object> part;
        int id;
        String[] ids;
        String name, link;
        Document docInner;
        Element el;
        ParseName pName = new ParseName();

            try {
                Elements nameEl = value.select("a[data-test-id=ProductTile]");
                String hrf = nameEl.attr("href");
                Document doc = Jsoup.connect(FinalsWords.HREF + hrf).get();
                CountReq.countReguests();
                Elements linkEl = doc.select("div[data-test-id=ThumbnailsList]");
                Elements colorEl = doc.select("span[data-test-id=ColorVariantColorInfo]");
                Iterator<Element> e = colorEl.iterator();
                linkEl = linkEl.select("a");
                for (Element ellink : linkEl )
                {
                    part = new HashMap<>();
                    el = e.next();
                    link = ellink.attr("href");
                    docInner = Jsoup.connect(FinalsWords.HREF + link).get();
                    CountReq.countReguests();
                    name = pName.parser(docInner);
                    part.put("name", name);
                    part.put("color", el.text());
                    ids = link.split("-");id = Integer.parseInt(ids[ids.length-1]);
                    part.put("id", id);
                    variant.add(part);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        return variant;
    }
}
