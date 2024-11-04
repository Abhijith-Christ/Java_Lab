import java.util.Scanner;

class Employee 
{
    private int employeeId;
    private String employeeName;
    private String designation;

    public Employee(int employeeId, String employeeName, String designation) 
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public double calculateWeeklySalary() {
        return 0;
    }

    public double calculateAnnualEarnings() {
        return calculateWeeklySalary() * 52;
    }

    public double calculateBonus() {
        return 0;
    }

    public void displayEmployeeInfo() 
    {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Annual Earnings: " + calculateAnnualEarnings());
        System.out.println("Bonus: " + calculateBonus());
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateWeeklySalary() 
    {
        return hourlyRate * hoursWorked;
    }

    public double calculateBonus()
    {
        return calculateWeeklySalary() * 0.05;
    }
}

class SalariedEmployee extends Employee 
{
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) 
    {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double calculateWeeklySalary() 
    {
        return monthlySalary / 4;
    }

    public double calculateBonus() 
    {
        return monthlySalary * 0.1; //Calculated as 10% of weekly salary
    }
}

class ExecutiveEmployee extends SalariedEmployee 
{
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateBonus() 
    {
        return super.calculateBonus() + (getMonthlySalary() * 12 * (bonusPercentage / 100));
    }
}

public class lab3 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Hourly Employee:");
        System.out.print("Employee ID: ");
        int hourlyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Employee Name: ");
        String hourlyName = scanner.nextLine();
        System.out.print("Designation: ");
        String hourlyDesignation = scanner.nextLine();
        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();

        HourlyEmployee hourlyEmployee = new HourlyEmployee(hourlyId, hourlyName, hourlyDesignation, hourlyRate, hoursWorked);
        hourlyEmployee.displayEmployeeInfo();
        System.out.println();

        System.out.println("Enter details for Salaried Employee:");
        System.out.print("Employee ID: ");
        int salariedId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Employee Name: ");
        String salariedName = scanner.nextLine();
        System.out.print("Designation: ");
        String salariedDesignation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();

        SalariedEmployee salariedEmployee = new SalariedEmployee(salariedId, salariedName, salariedDesignation, monthlySalary);
        salariedEmployee.displayEmployeeInfo();
        System.out.println();

        System.out.println("Enter details for Executive Employee:");
        System.out.print("Employee ID: ");
        int executiveId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Employee Name: ");
        String executiveName = scanner.nextLine();
        System.out.print("Designation: ");
        String executiveDesignation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double execMonthlySalary = scanner.nextDouble();
        System.out.print("Bonus Percentage: ");
        double bonusPercentage = scanner.nextDouble();

        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(executiveId, executiveName, executiveDesignation, execMonthlySalary, bonusPercentage);
        executiveEmployee.displayEmployeeInfo();
        System.out.println();

        double totalPayroll = hourlyEmployee.calculateAnnualEarnings() + salariedEmployee.calculateAnnualEarnings() + executiveEmployee.calculateAnnualEarnings();
        System.out.println("Total Payroll: " + totalPayroll);

        scanner.close();
    }
}
