package kz.e16training.textparser.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model of Text.
 *
 */
public class Text {
    private String text;
    private List<Sentence> sentenceList = new ArrayList<>();
    private final static String WHITESPACE = " ";
    public static final String SPLITTER_OF_SENTENCES = "(?<=[A-Za-z0-9А-Яа-я](\\.|\\?|\\!|\\.\\.\\.))\\s+(?=[A-ZА-Я])";

    public Text(Book book) {
        this.text = removeDuplicateSpaces(book.getText());
        parseForSentences(text);
    }

    /*
    Get list of sentences from text
     */
    private void parseForSentences(String text) {
        for(String s : text.split(SPLITTER_OF_SENTENCES)) {
            this.sentenceList.add(new Sentence(s));
        }
    }

    /*
    Replace characters like tab, newline, & etc
     and their duplicates by whitespace
     */
    private String removeDuplicateSpaces(String text) {
        return text.replaceAll("\\s+", WHITESPACE);
    }

    /*
    Sort sentences by number of words
     */
    public void sort() {
        Collections.sort(sentenceList);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(1024);
        for (Sentence sentence : sentenceList) {
            result.append(sentence).append(WHITESPACE);
        }
        return result.toString();
    }
}
