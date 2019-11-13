package com.task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.task.parsers.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import static com.sun.javafx.PlatformUtil.*;


public class Main {

    private static HashMap<String, Document> blocks = new HashMap<>();
    private static HashMap<String, Object> product;
    private static ArrayList<HashMap<String, Object>> products = new ArrayList<>();
    private static WebDriver driver;
    private static ParseBlocks pbl  = new ParseBlocks();
    private static ParsePrice pp = new ParsePrice();
    private static ParseBrand pbr = new ParseBrand();
    private static ParseColor pc = new ParseColor();
    private static ParseID pid = new ParseID();
    private static ParseName pn = new ParseName();
    private static  String jsonString;

    /**
     * For scrolling HTML page in order to extract all block that is hidden with JavaScript
     */

    public static WebDriver ByPage() {

        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();

        return driver;
    }

    /**
     * Create JSON String and format it in JSON file with spaces and new lines
     */

    public static void toJSON(){
            Gson gson = new Gson();
            jsonString = gson.toJson(products);

            try (FileWriter file = new FileWriter("products.json")) {

                JsonParser parser = new JsonParser();
                Gson gsonFormatted = new GsonBuilder().setPrettyPrinting().create();

                JsonElement el = parser.parse(jsonString);
                file.write(gsonFormatted.toJson(el));
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args)  {
        if (isWindows()) {
            System.setProperty(FinalsWords.WEBDRIVER, "src/main/resources/geckodriver.exe");
        } else if (isMac()) {
            System.setProperty(FinalsWords.WEBDRIVER, "src/main/resources/geckodriver");
        } else if (isUnix()) {
            System.setProperty(FinalsWords.WEBDRIVER, "src/main/resources/geckodriver_lin");
        }
        driver = new FirefoxDriver();
        driver.get(FinalsWords.HREF + "/maenner/bekleidung");
        CountReq.countReguests();

        Elements block;
        for (int i = -1; i <= 20; i++) {
            driver = ByPage();
            Document page = Jsoup.parse((driver.getPageSource()));
            block = page.select("a[data-test-id=ProductTile]");
            blocks = pbl.parseBlocks(block);
        }
        for (Map.Entry<String, Document> entry : blocks.entrySet()) {
            product = new HashMap<>();
            String key = entry.getKey();
            Document value = entry.getValue();

            product.put("brand", pbr.parser(value));
            product.put("price", pp.parser(value));
            product.put("variants", pc.parseColor(value));
            product.put("id", pid.parseID(key));

            products.add(product);
        }
        toJSON();
        System.out.println("Amount of extracted products: " + blocks.size());
        System.out.println("Amount of triggered requests: " + CountReq.getCountRequests());
        driver.close();
    }
}

