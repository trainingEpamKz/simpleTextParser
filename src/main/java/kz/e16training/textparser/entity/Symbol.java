package kz.e16training.textparser.entity;

/**
 * Model of Symbol.
 *
 */
public class Symbol {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
