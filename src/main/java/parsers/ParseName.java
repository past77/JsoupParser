package parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParseName {
    public ArrayList<String> parseName(Document value) {
        ArrayList<String> names = new ArrayList<>();
        {
            try {
                Elements name = value.select("a[data-test-id=ProductTile]");
                String hrf = name.attr("href");
                String str = null;

                //String[] name2 = name.toString().split("</p>");
                String a =  hrf.substring(hrf.lastIndexOf("/") + 1);
                String[] b =  a.split("-");
                System.out.println(b[0]);
                for (String n : b) {
                    str += str.concat(n);
                }
//                    String noPrefixStr = namee.substring(namee.indexOf(prefix) + prefix.length());
//                    if (!noPrefixStr.contains("&amp;"))
//                        names.add(noPrefixStr);
//                    else {
//                        noPrefixStr = noPrefixStr.replace("&amp;", "&");
//                        names.add(noPrefixStr);
//                    }
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return names;
    }
}
