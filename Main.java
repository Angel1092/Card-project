import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to the High Card Game!");

        while (playAgain) {

            int numPlayers = 0;

            // ----- GET NUMBER OF PLAYERS (NUMERIC INPUT WITH EXCEPTION HANDLING) -----
            while (true) {
                try {
                    System.out.print("Enter number of players (2-5): ");
                    numPlayers = Integer.parseInt(scanner.nextLine());

                    if (numPlayers >= 2 && numPlayers <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 2 and 5.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            // ----- GET PLAYER NAMES (STRING INPUT) -----
            ArrayList<String> playerNames = new ArrayList<>();

            for (int i = 0; i < numPlayers; i++) {
                System.out.print("Enter name for Player " + (i + 1) + ": ");
                String name = scanner.nextLine();
                playerNames.add(name);
            }

            // ----- CREATE & SHUFFLE DECK -----
            Deck deck = new Deck();
            deck.shuffle();

            int highestScore = 0;
            String winner = "";

            // ----- DEAL CARDS -----
            for (int i = 0; i < numPlayers; i++) {

                int total = 0;
                ArrayList<Card> hand = new ArrayList<>();

                for (int j = 0; j < 5; j++) {
                    Card card = deck.drawCard();
                    hand.add(card);
                    total += card.getValue();
                }

                System.out.println("\n" + playerNames.get(i) + "'s hand: " + hand);
                System.out.println("Total value: " + total);

                if (total > highestScore) {
                    highestScore = total;
                    winner = playerNames.get(i);
                }
            }

            System.out.println("\n🏆 Winner is: " + winner + " with " + highestScore + " points!");

            // ----- PLAY AGAIN? (STRING INPUT) -----
            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.nextLine();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
