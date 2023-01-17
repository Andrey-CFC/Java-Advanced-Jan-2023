package L05SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        Map<String, Double[]> gradesPerStudent = new TreeMap<>();
        for (int i = 0; i < students; i++) {
            String name = scanner.nextLine();
            String[] inputGrades = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[inputGrades.length];
            for (int j = 0; j < inputGrades.length; j++) {
                grades[j] = Double.parseDouble(inputGrades[j]);
            }
            gradesPerStudent.put(name, grades);
        }
        for (String student : gradesPerStudent.keySet()) {
            Double[] grades = gradesPerStudent.get(student);
            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            System.out.printf("%s is graduated with %s%n", student, sum / grades.length);
        }
    }
}
