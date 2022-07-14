package OOP.Polymorphism_Exercise.E01_Vehicle;

public class Car extends BaseVehicle {

    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, String vehicleType ) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, vehicleType);
    }

    @Override
    public void refuel(double litres) {
        setFuelQuantity(getFuelQuantity() + litres);
    }

}
