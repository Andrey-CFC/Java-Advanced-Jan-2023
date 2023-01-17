package L05SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Set<String> parking = new LinkedHashSet<>();
        while (!command.equals("END")){
            String commandName = command.split(", ")[0];
            String carPlate = command.split(", ")[1];
            switch (commandName){
                case "IN":
                    parking.add(carPlate);
                    break;
                case "OUT":
                    parking.remove(carPlate);
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        if (!parking.isEmpty()){
            for (String car:parking){
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
