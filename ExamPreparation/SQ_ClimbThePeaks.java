package ExamPreparation;

import java.util.*;

public class SQ_ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> peaksDifficulty = new LinkedHashMap<>();
        peaksDifficulty.put("Vihren", 80);
        peaksDifficulty.put("Kutelo", 90);
        peaksDifficulty.put("Banski Suhodol", 100);
        peaksDifficulty.put("Polezhan", 60);
        peaksDifficulty.put("Kamenitza", 60);
        ArrayDeque<String> allPeaksQueue = new ArrayDeque<>();
        allPeaksQueue.offer("Vihren");
        allPeaksQueue.offer("Kutelo");
        allPeaksQueue.offer("Banski Suhodol");
        allPeaksQueue.offer("Polezhan");
        allPeaksQueue.offer("Kamenitza");
        List<String> climbedPeaks = new ArrayList<>();
        String[] line1 = scanner.nextLine().split(", ");
        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        for (String foodQuantity : line1) {
            foodStack.push(Integer.parseInt(foodQuantity));
        }
        String[] line2 = scanner.nextLine().split(", ");
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();
        for (String dailyStamina : line2) {
            staminaQueue.add(Integer.parseInt(dailyStamina));
        }
        for (int i = 0; i < 7; i++) {
            int currentPower = foodStack.pop() + staminaQueue.poll();
            if (!allPeaksQueue.isEmpty()) {
                if (currentPower >= peaksDifficulty.get(allPeaksQueue.getFirst())) {
                    climbedPeaks.add(allPeaksQueue.getFirst());
                    allPeaksQueue.removeFirst();
                }
            }
        }
        if (allPeaksQueue.isEmpty()){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!climbedPeaks.isEmpty()){
            System.out.println("Conquered peaks:");
            for (String climbed: climbedPeaks) {
                System.out.println(climbed);
            }
        }
    }
}
