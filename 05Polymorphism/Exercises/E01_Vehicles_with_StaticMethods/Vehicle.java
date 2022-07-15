package E01_Vehicle;

import java.util.Map;
import java.util.Scanner;

public interface Vehicle {
    String drive(double kilometers);


    void refuel(double litres);


    static void executeCommand(Scanner scanner, Map<String, Vehicle> vehicles){
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
