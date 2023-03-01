package L16GenericsEx.P11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String firstEl = data[0];
            String secondEl = data[1];
            String thirdEl = data[2];
            switch (i){
                case 0:
                    firstEl = data[0] + " " + data[1];
                    secondEl = data[2];
                    thirdEl = data[3];
                    Threeuple<String,String,String> firstThreeuple = new Threeuple<>(firstEl,secondEl,thirdEl);
                    System.out.println(firstThreeuple);
                    break;
                case 1:
                    boolean isDrunk = thirdEl.equals("drunk");
                    Threeuple<String,Integer,Boolean> secondThreeuple = new Threeuple<>(firstEl,Integer.parseInt(secondEl),isDrunk);
                    System.out.println(secondThreeuple);
                                        break;
                case 2:
                    Threeuple<String,Double,String> thirdThreeuple = new Threeuple<>(firstEl,Double.parseDouble(secondEl),thirdEl);
                    System.out.println(thirdThreeuple);
                    break;
            }
        }
    }
}
