
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import parsers.*;


public class Main {

    private static HashMap<String, Document> blocks = new HashMap<>();
    private static HashMap<String, ArrayList<String>> json = new HashMap<>();
    private static ArrayList<HashMap<String, ArrayList<String>>> main = new ArrayList<>();
    private static WebDriver driver;
    private static ParseBlocks pbl  = new ParseBlocks();
    private static ParsePrice pp = new ParsePrice();
    private static ParseBrand pbr = new ParseBrand();
    private static ParseColor pc = new ParseColor();
    private static ParseID pid = new ParseID();
    private static ParseName pn = new ParseName();

        public static WebDriver ByPage() {

            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN).build().perform();

            return driver;
        }

    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.aboutyou.de/maenner/bekleidung");

        Elements block = null;
        for (int i = -1; i <= 10; i++) {
            driver = ByPage();
            Document page = Jsoup.parse((driver.getPageSource()));
            block = page.select("a[data-test-id=ProductTile]");
            blocks = pbl.parseBlocks(block);
        }
        for (Map.Entry<String, Document> entry : blocks.entrySet()) {
            String key = entry.getKey();
            Document value = entry.getValue();

            json.put("brand: ", pbr.parseBrand(value));
            json.put("price: ", pp.parsePrice(value));
            //json.put
            json.put("colors: ", pc.parseColor(value));
            json.put("ID: ", pid.parseID(key));
    pn.parseName(value);

            main.add(json);
        }


    driver.close();
    }
}

