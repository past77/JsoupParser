package parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParseColor {

    public ArrayList<String> parseColor(Document value) {
        ArrayList<String> colors = new ArrayList<>();
        {
            try {
                Elements color = value.select("ul[data-test-id=ColorContainer]");
                color = color.select("li[data-test-id=ColorBubble]");
                for (Element el : color){
                    String c = el.attr("color");
                    colors.add(c);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return colors;
    }
}
