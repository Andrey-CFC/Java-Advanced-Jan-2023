package L12DefiningClassesEx.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelConsumptionPerKm = Double.parseDouble(data[2]);
            Car car = new Car(model,fuelAmount, fuelConsumptionPerKm);
            cars.put(model,car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String carModelToDrive= command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);
            Car carToDrive = cars.get(carModelToDrive);
            if (!carToDrive.drive(kmToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }

        for (Car car: cars.values()) {
            System.out.println(car.toString());
        }
    }
}
