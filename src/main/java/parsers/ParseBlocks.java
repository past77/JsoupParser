package parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;

public class ParseBlocks {
    private HashMap<String, Document> blocks = new HashMap<>();

    public HashMap<String, Document>  parseBlocks(Elements element) {
        {
            try {
                String[] block = element.toString().split("</a>");
                for (String bl : block) {
                    Document doc = Jsoup.parse(bl);
                    Elements element1 = doc.select("a[data-test-id=ProductTile]");
                    String el = element1.attr("id");
                    blocks.put(el, doc);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  blocks;
    }
}
