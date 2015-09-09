package kz.e16training.textparser.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Model of PartOfSentence.
 *
 */
public class PartOfSentence {
    private List<Symbol> symbolList = new ArrayList<>();

    public PartOfSentence(String charList) {
        parseForSymbols(charList);
    }

    /*
    Get list of symbols from part of sentence
     */
    private void parseForSymbols(String charList) {
        for (char ch : charList.toCharArray()) {
            symbolList.add(new Symbol(ch));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Symbol symb : symbolList) {
            result.append(symb.toString());
        }
        return result.toString();
    }
}
