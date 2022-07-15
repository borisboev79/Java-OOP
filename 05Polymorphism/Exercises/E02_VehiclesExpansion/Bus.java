package vehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends BaseVehicle implements EmptyDriveable {

    private static final double AC_FUEL_CONSUMPTION_INCREASE = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity, String vehicleType) {
        super(fuelQuantity, fuelConsumption + AC_FUEL_CONSUMPTION_INCREASE, tankCapacity, vehicleType);
    }

    public String driveEmpty(double kilometers) {
        if (hasEnoughFuel(kilometers)) {
            double fuelSpent = kilometers * (getFuelConsumption() - AC_FUEL_CONSUMPTION_INCREASE);
            setFuelQuantity(getFuelQuantity() - fuelSpent);
            String df = new DecimalFormat("####.##").format(kilometers);
            return String.format("%s travelled %s km", getVehicleType(), df);
        }
        return String.format("%s needs refueling", getVehicleType());
    }
}
