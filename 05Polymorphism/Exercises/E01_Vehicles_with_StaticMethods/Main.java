package E01_Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Vehicle> vehicles = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car.buildVehicle(scanner, vehicles);
        Truck.buildVehicle(scanner, vehicles);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Vehicle.executeCommand(scanner, vehicles);
        }
        vehicles.values().forEach(System.out::println);
    }
}
