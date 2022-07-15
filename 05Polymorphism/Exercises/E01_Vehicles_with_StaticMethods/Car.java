package E01_Vehicle;

import java.util.Map;
import java.util.Scanner;

public class Car extends BaseVehicle {

    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, String vehicleType ) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, vehicleType);
    }

    @Override
    public void refuel(double litres) {
        setFuelQuantity(getFuelQuantity() + litres);
    }

    public static void buildVehicle(Scanner scanner, Map<String, Vehicle> vehicles) {
        String[] input = scanner.nextLine().split("\\s+");
        String vehicleType = input[0];
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelConsumption = Double.parseDouble(input[2]);
        Vehicle car = new Car(fuelQuantity, fuelConsumption, vehicleType);
        vehicles.put(input[0], car);
    }
}
