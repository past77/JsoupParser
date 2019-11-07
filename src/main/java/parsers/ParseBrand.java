package parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseBrand implements IParse{

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
