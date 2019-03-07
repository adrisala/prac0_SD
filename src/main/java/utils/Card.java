package utils;

public class Card {
    private char rank, suit;

    public Card(char rank, char suit){
        this.rank = rank;
        this.suit = suit;
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }
}
