package E01_Vehicle;

import java.util.Map;
import java.util.Scanner;

public class Truck extends BaseVehicle {

    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, String vehicleType) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, vehicleType);
    }

    @Override
    public void refuel(double litres) {
        setFuelQuantity(getFuelQuantity() + litres * 0.95);
    }

    public static void buildVehicle(Scanner scanner, Map<String, Vehicle> vehicles) {
        String[] input = scanner.nextLine().split("\\s+");
        String vehicleType = input[0];
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelConsumption = Double.parseDouble(input[2]);
        Vehicle truck = new Truck(fuelQuantity, fuelConsumption, vehicleType);
        vehicles.put(input[0], truck);
    }
}
