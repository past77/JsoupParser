package com.task.parsers;

import org.jsoup.nodes.Document;

/**
 * Inerface for com.task.consts.parsers that return String
 */
public interface IParser {
    String parser(Document value);
}
