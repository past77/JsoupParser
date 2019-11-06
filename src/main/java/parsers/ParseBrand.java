package parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class ParseBrand {


    public ArrayList<String> parseBrand(Document value) {
        ArrayList<String> brands = new ArrayList<>();
        {
            try {
                    Elements brandEl = value.select("p[data-test-id=BrandName]");
                    String[] brand = brandEl.toString().split("</p>");
                    String prefix = "<p data-test-id=\"BrandName\" class=\"ProductTileContent__Name-sc-1gv4rhx-1 kaTyNH\">";

                    for (String br : brand) {
                        String noPrefixStr = br.substring(br.indexOf(prefix) + prefix.length());
                        if (!noPrefixStr.contains("&amp;"))
                            brands.add(noPrefixStr);
                        else {
                            noPrefixStr = noPrefixStr.replace("&amp;", "&");
                            brands.add(noPrefixStr);
                        }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return brands;
    }

}
