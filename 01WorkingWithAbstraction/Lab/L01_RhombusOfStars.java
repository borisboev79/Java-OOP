package OOP.WorkingWithAbstraction_Lab;

import java.util.Scanner;

public class L01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printRhombus(n);
    }

    public static void printRhombus(int size) {
        for (int i = 1; i <= size; i++) {
            printTriangle(size - i, i);
        }
        for (int i = 1; i < size; i++) {
            printTriangle(i, size - i);
        }
    }

    private static void printTriangle(int first, int second) {
        for (int j = 0; j < first; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < second; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}

