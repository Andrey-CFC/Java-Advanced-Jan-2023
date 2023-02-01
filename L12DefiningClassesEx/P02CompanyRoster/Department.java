package L12DefiningClassesEx.P02CompanyRoster;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employee;
    private double avgSalary;

    public Department(String name, List<Employee> employee) {
        this.employee = employee;
        this.name = name;
        this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public double getAvgSalary() {
        return this.avgSalary;
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployee() {
        return this.employee;
    }
}

