package L16GenericsEx.P10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String firstEl = data[0];
            String secondEl = data[1];
            switch (i){
                case 0:
                    firstEl = data[0] + " " + data[1];
                    secondEl = data[2];
                    Tuple<String,String> firstTuple = new Tuple<>(firstEl,secondEl);
                    System.out.println(firstTuple);
                    break;
                case 1:
                    Tuple<String,Integer> secondTuple = new Tuple<>(firstEl,Integer.parseInt(secondEl));
                    System.out.println(secondTuple);
                    break;
                case 2:
                    Tuple<Integer,Double> thirdTuple = new Tuple<>(Integer.parseInt(firstEl),Double.parseDouble(secondEl));
                    System.out.println(thirdTuple);
                    break;
            }
        }
    }
}
