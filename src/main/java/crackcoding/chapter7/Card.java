package crackcoding.chapter7;

public class Card {
    private String suit;
    private int number;
    private char symbol;

    /**
     * Constructor
     * @param number  value to initialize a card
     */
    public Card(int number) {
        int suitNum = number / 13;
        if(suitNum == 0) suit = "Heart";
        if(suitNum == 1) suit = "Diamond";
        if(suitNum == 2) suit = "Spade";
        if(suitNum == 3) suit = "Club";
        this.number = number % 13;
        if(1 < this.number && this.number < 11)
            symbol = (char)(this.number + '0');
        if(this.number == 1) symbol = 'A';
        if(this.number == 11) symbol = 'J';
        if(this.number == 12) symbol = 'Q';
        if(this.number == 0) {
            symbol = 'K';
            this.number = 13;
        }
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return (number + ", " + suit);
    }
}


