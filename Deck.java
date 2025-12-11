import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7",
                           "8", "9", "10", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    public ArrayList<ArrayList<Card>> dealHands(int numHands, int cardsPerHand) {
        ArrayList<ArrayList<Card>> hands = new ArrayList<>();
        for (int i = 0; i < numHands; i++) {
            ArrayList<Card> hand = new ArrayList<>();
            for (int j = 0; j < cardsPerHand; j++) {
                hand.add(drawCard());
            }
            hands.add(hand);
        }
        return hands;
    }
}
