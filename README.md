# JsoupParser

Java project which extract data from HTML page and write it into JSON file.

## How to run:
```
git clone https://github.com/past77/JsoupParser.git parserJSoup && cd parserJSoup

java -jar Parser-1.0-SNAPSHOT-jar-with-dependencies.jar *(if you will run on Windows)*

mvn package
java -jar Target/Parser-1.0-SNAPSHOT-jar-with-dependencies.jar *(if you will run on Mac or Linux)*

Or also you can open this project in IntelliJ Idea and run;

*Pay attention! You must have installed Mozila Firefox browser*
```

# Input

HTML page from website "https://www.aboutyou.de/maenner/bekleidung"

# Output

• Amount of triggered HTTP requests <br>

• Amount of extracted products  <br>

• JSON file products.json <br>
