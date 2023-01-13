package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < line.length; i++) {
            nums.push(Integer.parseInt(line[i]));
        }
      for (int i = 0; i < line.length; i++) {
            System.out.print(nums.pop()+" ");
        }
    }
}
