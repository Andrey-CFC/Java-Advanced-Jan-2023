package L12DefiningClassesEx.P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String engineModel = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement = 0;
            String efficiency = null;
            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else {
                    efficiency = engineData[2];
                }
            }
            Engine engine = new Engine(engineModel, power, displacement, efficiency);
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            String carEngineModel = carData[1];
            int carWeight = 0;
            String colour = null;
            if (carData.length == 4) {
                carWeight = Integer.parseInt(carData[2]);
                colour = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    carWeight = Integer.parseInt(carData[2]);
                } else {
                    colour = carData[2];
                }
            }
            Engine carEngine = null;
            for (Engine currentEngine : engines) {
                if (carEngineModel.equals(currentEngine.getModel())) {
                    carEngine = currentEngine;
                    break;
                }
            }
            Car car = new Car(carModel, carEngine, carWeight, colour);
            System.out.println(car.toString());
        }
    }
}
