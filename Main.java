import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();       // this will create a deck
        deck.shuffle();               // this will shuffle it

        ArrayList<ArrayList<Card>> hands = deck.dealHands(5, 5); // deal 5 hands, 5 cards each

        // Will print each hand
        for (int i = 0; i < hands.size(); i++) {
            System.out.println("Player " + (i + 1) + ": " + hands.get(i));
        }
    }
}
