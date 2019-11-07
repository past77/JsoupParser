package parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ParseName implements IParse{

    @Override
    public String parser(Document value) {
        String name = "";
        {
            try {
                Elements nameEl = value.select("a[data-test-id=ProductTile]");
                String hrf = nameEl.attr("href");
                String str = "";

                String a =  hrf.substring(hrf.lastIndexOf("/") + 1);
                String[] b =  a.split("-");
                for (String n : b) {
                    str += n + " ";
                }
                str = str.trim();
                int index= str.lastIndexOf(" ");
                name = str.substring(0, index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
