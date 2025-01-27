import java.util.List;
import java.util.Scanner;

public class PayrollSystem {

    private static final EmployeeManager employeeManager = new EmployeeManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //TODO:
        //TODO: ADD INTERACTIVE MENU ALLOWING THE USER TO ADD/DISPLAY/ETC
        //TODO: ADD, DISPLAY ALL, FILTER BY SALARY, SORT BY NAME, EXIT
        //TODO: CREATE AN INTERFACE -> TAX INFO + METHODS TO CALCULATE TAX DUE (20% & 40%)
        //TODO: GENERATE PAYSLIP METHOD
        //TODO: RECORDS???

        System.out.println("Welcome to Payroll System!");

        boolean quit = false;

        while (!quit) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAllEmployees();
                case 3 -> generatePayslip();
                case 4 -> filterEmployeesBySalary();
                case 5 -> sortEmployeesByName();
                case 6 -> {
                    System.out.println("Closing the program...");
                    quit = true;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }


        EmployeeManager manager = new EmployeeManager();

        try {
            //create employees
            var e1 = new FullTimeEmployee("Tom", EmployeeLevel.MID, new Salary(70000,0));
            var e2 = new PartTimeEmployee("Sam", EmployeeLevel.JUNIOR, new Salary(0,50), 40);
            var e3 = new FullTimeEmployee("Bob", EmployeeLevel.JUNIOR, new Salary(40000,0));
            var e4 = new FullTimeEmployee("Sue", EmployeeLevel.JUNIOR, new Salary(35000,0));
            var e5 = new FullTimeEmployee("Tim", EmployeeLevel.MID, new Salary(65000,0));
            var e6 = new FullTimeEmployee("Eve", EmployeeLevel.SENIOR, new Salary(120000,0));
            var e7 = new PartTimeEmployee("Pam", EmployeeLevel.MID, new Salary(0,90), 40);
            var e8 = new PartTimeEmployee("Joe", EmployeeLevel.SENIOR, new Salary(0,120), 40);
            var e9 = new PartTimeEmployee("Liz", EmployeeLevel.MID, new Salary(0,85), 40);


            //add employees
            manager.addEmployees(e1, e2, e3, e4, e5, e6, e7, e8, e9);

            //using pattern match
            System.out.println("Printing employee details");
            manager.printEmployeeDetails(e1);
            manager.printEmployeeDetails(e2);



            //calculate bonus
            System.out.println("Tom's base bonus: " + e1.calculateBonus());
            System.out.println("Tom's increased bonus: " + e1.calculateBonus(1.15));

        } catch (InsufficientDataException ex) {
            System.out.println("Error creating employee" + ex.getMessage());
        }

    }

    private static void printMenu() {
        System.out.println("\n--- Menu ---\n");
        System.out.println("1. Add Employee");
        System.out.println("2. Display All Employees");
        System.out.println("3. Generate Payslip");
        System.out.println("4. Filter Employees by Salary");
        System.out.println("5. Sort Employees");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid choice, please try again");
            return -1;
        }
    }

    private static void addEmployee() {
        try {
            System.out.println("Select employee type: ");
            System.out.println("1. Full Time");
            System.out.println("2. Part Time");

            int type = getChoice();

            System.out.println("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.println("Enter level (JUNIOR, MID, SENIOR): ");
            EmployeeLevel level = EmployeeLevel.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Enter base salary: ");
            double baseSalary = Double.parseDouble(scanner.nextLine());

            if (type == 1) {
                employeeManager.addEmployees(new FullTimeEmployee(name, level, new Salary(baseSalary, 0)));
                System.out.println("Full time employee added successfully.");
            } else if (type == 2) {
                System.out.println("Enter the hourly rate:");
                double hourlyRate = Double.parseDouble(scanner.nextLine());

                System.out.println("Enter hours worked: ");
                int hoursWorked = Integer.parseInt(scanner.nextLine());

                employeeManager.addEmployees(new PartTimeEmployee(name, level, new Salary(0, hourlyRate), hoursWorked));
                System.out.println("Part time employee added successfully.");
            } else {
                System.out.println("Invalid employee type, please try again!");
            }
        } catch (Exception ex) {
            System.out.println("Error adding employee" + ex.getMessage());
        }
    }

    private static void displayAllEmployees() {
        List<Employee> employees = employeeManager.getEmployees();

        if (employees.isEmpty()) {
            System.out.println("There are no employees.");
            return;
        }

        System.out.println("\n--- Employee List ---\n");
        employees.forEach(System.out::println);
    }

    private static void generatePayslip() {
        List<PayslipRecord> payslips = employeeManager.generatePayslips();

        if (payslips.isEmpty()) {
            System.out.println("There are no payslips.");
            return;
        }

        System.out.println("\n--- Payslips ---\n");
        payslips.forEach(p -> System.out.printf(
                "Employee: %s | Pay: %.2f | Date: %s%n",
                p.employeeName(), p.payAmount(), p.date()
        ));
    }

    private static void filterEmployeesBySalary() {
        try {
            System.out.println("Enter minimum salary: ");
            double minSalary = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter maximum salary: ");
            double maxSalary = Double.parseDouble(scanner.nextLine());

            List<Employee> filteredEmployees = employeeManager.filterEmployeesBySalary(minSalary, maxSalary);

            if (filteredEmployees.isEmpty()) {
                System.out.println("No employees found in the specified salary range.");
                return;
            }

            System.out.println("\n--- Filtered employees ---\n");
            filteredEmployees.forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error filtering employees");
        }
    }

    private static void sortEmployeesByName() {
        List<Employee> sortedEmployees = employeeManager.sortEmployeesByName();

        if (sortedEmployees.isEmpty()) {
            System.out.println("There are no employees to display.");
            return;
        }
        System.out.println("\n--- Sorted employees ---\n");
        sortedEmployees.forEach(System.out::println);
    }
}