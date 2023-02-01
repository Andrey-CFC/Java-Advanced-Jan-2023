package L11DefiningClasses.P01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            int hp = Integer.parseInt(carInfo[2]);
            Car car = new Car(carInfo[0], carInfo[1], hp);

            System.out.println(car.carInfo());
        }
    }

    public static void test() {
        Car firstCar = new Car();
        Car secondCar = new Car();

        firstCar.setBrand("Opel");
        firstCar.setModel("Astra");
        firstCar.setHorsePower(90);


        System.out.println(firstCar.carInfo());
    }
}

