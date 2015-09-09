package kz.e16training.textparser.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Model of Sentence.
 *
 */
public class Sentence implements Comparable<Sentence> {
    private static final String SPLITTER_OF_PART = "(?<!^)\\b";
    private static final String PUNCTUATION_MARK = "[\\p{Punct}\\s]+";
    private List<PartOfSentence> partOfSentenceList = new ArrayList<>();
    
    public Sentence(String sentence) {
        parseForPartsOfSentence(sentence);
    }

    /*
    Get part of sentence from sentence
     */
    private void parseForPartsOfSentence(String sentence) {
        for (String str : sentence.split(SPLITTER_OF_PART)) {
            if (str.matches(PUNCTUATION_MARK) || str.isEmpty()) {
                partOfSentenceList.add(new PartOfSentence(str));
            } else {
                partOfSentenceList.add(new Word(str));
            }
        }
    }

    public int getNumberOfWords() {
        return partOfSentenceList.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PartOfSentence part : partOfSentenceList) {
            result.append(part.toString());
        }
        return result.toString();
    }

    @Override
    public int compareTo(Sentence other) {
        return this.getNumberOfWords() - other.getNumberOfWords();
    }
}
