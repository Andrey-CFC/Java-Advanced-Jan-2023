package L12DefiningClassesEx.P02CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 1; i <= lines; i++) {

            String[] currentLineArr = scanner.nextLine().split("\\s+");
            Employee currentEmployee = new Employee();
            currentEmployee.setName(currentLineArr[0]);
            currentEmployee.setSalary(Double.parseDouble(currentLineArr[1]));
            currentEmployee.setPosition(currentLineArr[2]);
            currentEmployee.setDepartment(currentLineArr[3]);

            if (currentLineArr.length == 5) {
                if (currentLineArr[4].contains("@")) {
                    currentEmployee.setEmail(currentLineArr[4]);
                } else {
                    currentEmployee.setAge(Integer.parseInt(currentLineArr[4]));
                }
            } else if (currentLineArr.length == 6) {
                if (currentLineArr[4].contains("@")) {
                    currentEmployee.setEmail(currentLineArr[4]);
                    currentEmployee.setAge(Integer.parseInt(currentLineArr[5]));
                } else {
                    currentEmployee.setAge(Integer.parseInt(currentLineArr[4]));
                    currentEmployee.setEmail(currentLineArr[5]);
                }
            }
            employeeList.add(currentEmployee);
        }
        List<String> departmentList = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        List<Department> departments = new ArrayList<>();
        for (String department : departmentList) {
            departments.add(new Department(department, employeeList.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = departments.get(0);
        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n",department.getName());
        for (Employee employee:department.getEmployee()) {
            System.out.printf("%s %.2f %s %d%n",employee.getName(),employee.getSalary(),employee.getEmail(),employee.getAge());
        }
    }
}
