package L15Generics.P04ListUtilities;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        T maxElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (maxElement.compareTo(list.get(i)) < 0) {
                maxElement = list.get(i);
            }
        }
        return maxElement;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        T minElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (minElement.compareTo(list.get(i)) > 0) {
                minElement = list.get(i);
            }
        }
        return minElement;
    }
}
