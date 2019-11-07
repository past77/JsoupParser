package parsers;

import org.jsoup.nodes.Document;

/**
 * Inerface for parsers that return String
 */
public interface IParse {
    String parser(Document value);
}
