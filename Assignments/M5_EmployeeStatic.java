class EmployeeStatic {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_EmployeeStatic {
    public static void main(String[] args) {

        EmployeeStatic employee1 = new EmployeeStatic("Aarav", 60000);
        EmployeeStatic employee2 = new EmployeeStatic("Priya", 65000);
        EmployeeStatic employee3 = new EmployeeStatic("Rohan", 70000);

        System.out.println("3 Employee objects created");

        EmployeeStatic.printCompanyInfo();
    }
}