package L16GenericsEx.P06GenericCountMethodDouble;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double data = Double.parseDouble(scanner.nextLine());;
            Box<Double> box = new Box<>(data);
            boxList.add(box);
        }
        Box<Double> boxToCompareTo = new Box<>(Double.parseDouble(scanner.nextLine()));
        System.out.println(greaterResultsCounter(boxList,boxToCompareTo));
    }
    static <T extends Comparable<T>> int greaterResultsCounter(List<T> data, T element){
        int total = 0;
        for (T el : data) {
            int result = el.compareTo(element);
            if (result > 0) {
                total ++;
            }
        }
        return total;
    }
}
