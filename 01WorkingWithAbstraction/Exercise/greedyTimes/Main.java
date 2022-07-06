package greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] treasuresInVault = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < treasuresInVault.length; i += 2) {
            String treasureType = treasuresInVault[i];
            long treasureAmount = Long.parseLong(treasuresInVault[i + 1]);
            bag.dispatch(treasureType, treasureAmount);
        }
        bag.getTreasure().printTreasures();
    }
}