package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsInput = scanner.nextLine().split(";"); //всички роботи с времената
        LinkedHashMap<String, Integer> robots = getRobotsMap(robotsInput);
        String time = scanner.nextLine();
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);
        long totalTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        int[] workingTime = new int[robots.size()];
        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            //увеличавам текущото време
            totalTimeInSeconds++;
            boolean isProduced = false;
            //намалям работното време с 1 секунда
            for (int robot = 0; robot < workingTime.length; robot++) {
                if (workingTime[robot] > 0) {
                    --workingTime[robot];
                }
            }
            //обхождане на работното време
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0) {
                    //свободен -> кой е робота -> времето
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i) {
                            workingTime[i] = robot.getValue();
                            long takenHour = totalTimeInSeconds / 3600 % 24;
                            long takenMinute = totalTimeInSeconds % 3600 / 60;
                            long takenSeconds = totalTimeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct, takenHour, takenMinute, takenSeconds);
                            isProduced = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!isProduced) {
                products.offer(currentProduct);
            }
        }
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsInput) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < robotsInput.length; i++) {
            String name = robotsInput[i].split("-")[0];
            int time = Integer.parseInt(robotsInput[i].split("-")[1]);
            robots.put(name, time);
        }
        return robots;
    }
}
