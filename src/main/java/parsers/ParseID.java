package parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ParseID {

    public ArrayList<String> parseID(String value) {
        ArrayList<String> id = new ArrayList<>();
        {
            try {
                id.add(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return id;
    }

}
