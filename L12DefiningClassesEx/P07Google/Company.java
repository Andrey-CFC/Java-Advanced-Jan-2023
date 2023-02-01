package L12DefiningClassesEx.P07Google;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.companyName = name;
        this.department = department;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
