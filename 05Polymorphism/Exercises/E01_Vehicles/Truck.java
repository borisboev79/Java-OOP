package OOP.Polymorphism_Exercise.E01_Vehicle;

public class Truck extends BaseVehicle{

    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, String vehicleType) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, vehicleType);
    }

    @Override
    public void refuel(double litres) {
        setFuelQuantity(getFuelQuantity() + litres * 0.95);
    }

}
