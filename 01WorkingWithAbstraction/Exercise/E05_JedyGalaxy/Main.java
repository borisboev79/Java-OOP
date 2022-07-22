package OOP.WorkingWithAbstraction_Exercise.E05_JedyGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPositions(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

        StarsField starsField = new StarsField(rows, cols);
        Galaxy galaxy = new Galaxy(starsField);

        String command = scanner.nextLine();
        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] jediPosition = readPositions(command);
            int[] evilPosition = readPositions(scanner.nextLine());

            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            galaxy.moveEvil(evilRow, evilCol);

            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];

           starsCollected += galaxy.moveJedi(jediRow, jediCol);

            command = scanner.nextLine();

        }
        System.out.println(starsCollected);
    }

    private static int[] readPositions(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
