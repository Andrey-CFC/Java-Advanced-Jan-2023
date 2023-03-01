package L15Generics.P04ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(231);
        ints.add(5);
        ints.add(4123);
        ints.add(231);
        ints.add(2);
        System.out.println(ListUtils.getMax(ints));
        System.out.println(ListUtils.getMin(ints));
    }
}
