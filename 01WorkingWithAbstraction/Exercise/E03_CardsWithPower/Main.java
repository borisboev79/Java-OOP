package OOP.WorkingWithAbstraction_Exercise.E03_CardsWIthPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CardRanks cardRank = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuit = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card(cardSuit, cardRank);

        int power = card.getPower(cardSuit, cardRank);

        System.out.printf("Card name: %s of %s; Card power: %d%n", card.getCardRank(), card.getCardSuit(), power);
    }
}
