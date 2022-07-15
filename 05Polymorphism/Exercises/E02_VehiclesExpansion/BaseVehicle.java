package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class BaseVehicle implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private String vehicleType;
    private double tankCapacity;


    public BaseVehicle(double fuelQuantity, double fuelConsumption, double tankCapacity, String vehicleType) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
        setVehicleType(vehicleType);

    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    protected void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String drive(double kilometers) {
        if(hasEnoughFuel(kilometers)) {
            double fuelSpent = kilometers * getFuelConsumption();
            setFuelQuantity(getFuelQuantity() - fuelSpent);
            String df = new DecimalFormat("####.##").format(kilometers);
            return String.format("%s travelled %s km", getVehicleType(), df);
        }
        return String.format("%s needs refueling", getVehicleType());
    }

    @Override
    public void refuel(double litres) {
        if(litres <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (litres + getFuelQuantity() > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        setFuelQuantity(getFuelQuantity() + litres);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getVehicleType(), getFuelQuantity());
    }


    protected boolean hasEnoughFuel(double kilometers) {
        double totalFuelConsumed = kilometers * getFuelConsumption();
        if(totalFuelConsumed >fuelQuantity) {
            return false;
        }
        return true;
    }
}
