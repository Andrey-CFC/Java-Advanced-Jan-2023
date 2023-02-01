package L12DefiningClassesEx.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelConsumptionPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.distanceTravelled = 0;
    }

    public boolean drive(int kmDrive) {
        double neededFuel = kmDrive * this.fuelConsumptionPerKm;
        if (neededFuel <= this.fuelAmount){
            this.fuelAmount -= neededFuel;
            this.distanceTravelled += kmDrive;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString(){
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTravelled);
    }
}
