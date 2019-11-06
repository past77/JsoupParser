package parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class ParsePrice {

    public ArrayList<String> parsePrice(Document value) {
        ArrayList<String> pricelst = new ArrayList<>();
        {
            //FormattedSalePrice
            Elements price = value.select("span[data-test-id=ProductPriceFormattedBasePrice], span[data-test-id=StrikeFormattedBasePrice]");
            String[] prices = price.toString().split("</span>");
            String prefix = "<span data-test-id=\"ProductPriceFormattedBasePrice\" class=\"Price-sc-137x7zs-0 PriceBox__StyledPrice-x3voc9-0 dGRuIw\">";

            for (String p : prices) {
                String noPrefixStr = p.substring(p.indexOf(prefix) + prefix.length());
                pricelst.add(noPrefixStr);
            }
        }
        return pricelst;
        }
    }
