package OOP.Polymorphism_Exercise.E01_Vehicle;

import java.util.*;

public class Main {

    static Map<String, Vehicle> vehicles = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        buildVehicle(scanner);
        buildVehicle(scanner);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            executeCommand(scanner);
        }
        vehicles.values().forEach(System.out::println);

    }

    private static void buildVehicle(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        String vehicleType = input[0];
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelConsumption = Double.parseDouble(input[2]);

        switch (vehicleType) {
            case"Car":
                Vehicle car = new Car(fuelQuantity, fuelConsumption, vehicleType);
                vehicles.put(input[0], car);
                break;
            case"Truck":
                Vehicle truck = new Truck(fuelQuantity, fuelConsumption, vehicleType);
                vehicles.put(input[0], truck);
                break;
        }
    }

    private static void executeCommand(Scanner scanner) {
        String[] commands = scanner.nextLine().split("\\s+");
        String command = commands[0];
        String vehicleType = commands[1];

        switch (command) {
            case "Drive":
                double kilometers = Double.parseDouble(commands[2]);
                System.out.println(vehicles.get(vehicleType).drive(kilometers));
                break;
            case "Refuel":
                double litres = Double.parseDouble(commands[2]);
                vehicles.get(vehicleType).refuel(litres);
                break;
        }
    }

}
