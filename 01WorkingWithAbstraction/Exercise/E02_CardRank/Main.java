package OOP.WorkingWithAbstraction_Exercise.E02_CardRank;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");


        Arrays.stream(CardRanks.values())
                .forEach(CardRanks -> System.out.printf("Ordinal value: %d; Name value: %s%n", CardRanks.ordinal(), CardRanks.name()));
    }
}
