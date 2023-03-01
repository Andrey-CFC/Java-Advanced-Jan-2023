package L16GenericsEx.P05GenericCountMethodString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            Box<String> box = new Box<>(data);
            boxList.add(box);
        }
        Box<String> boxToCompareTo = new Box<>(scanner.nextLine());
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
