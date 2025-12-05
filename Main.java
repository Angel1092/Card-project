import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Card> deck = createDeck();

        Collections.shuffle(deck);

        ArrayList<ArrayList<Card>> hands = dealHands(deck, 5, 5);
