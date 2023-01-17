package L05SetsAndMapsAdvanced;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> gradesByStudent = new TreeMap<>();
        for (int i = 0; i < students; i++) {
            String currentData = scanner.nextLine();
            String studentsName = currentData.split("\\s+")[0];
            double studentsGrade = Double.parseDouble(currentData.split("\\s+")[1]);
            gradesByStudent.putIfAbsent(studentsName, new ArrayList<>());
            gradesByStudent.get(studentsName).add(studentsGrade);
        }
        for (Map.Entry<String, List<Double>> entry : gradesByStudent.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            double sumOfGrades = 0;
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
                sumOfGrades += grade;
            }
            System.out.printf("(avg: %.2f)%n", sumOfGrades / entry.getValue().size());
        }
    }
}
