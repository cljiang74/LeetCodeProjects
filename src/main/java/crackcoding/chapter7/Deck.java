package crackcoding.chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deckCards = new ArrayList<>();
    private static final int MAX_CARDS = 52;

    /**
     * constructor
     */
    public Deck() {
        for(int i=0; i<MAX_CARDS; i++) {
            Card newCard = new Card(i);
            deckCards.add(newCard);
        }
        Collections.shuffle(deckCards);
    }

    /**
     * If there is a Ace make sure to add to the tail of the list of cards
     * @param cards
     * @return
     */
    public boolean blackJackOrNot(List<Card> cards) {
        int sum = 0;
        for(Card c: cards) {
            int num;
            if(c.getNumber() == 0 || c.getNumber() > 10)
                num = 10;
            else if(c.getNumber() == 1) {
                if(sum + 11 > 21)
                    num = 1;
                else
                    num = 11;
            }
            else
                num = c.getNumber();
            sum += num;
            if(sum > 21)
                return false;
        }
        if(sum == 21) return true;
        return false;
    }

    /**
     * Print out cards
     */
    public void printCards() {
        for(Card c: deckCards)
            System.out.println(c);
    }
}
