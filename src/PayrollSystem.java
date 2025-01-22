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

            //filter by salary
            var filteredEmployees = manager.filterEmployeesBySalary(65000, 70000);
            System.out.println("Filtered employees:");
            filteredEmployees.forEach(System.out::println);

            //sort by name
            var sortedEmployees = manager.sortEmployeesByName();
            System.out.println("Sorted employees:");
            sortedEmployees.forEach(System.out::println);

            //calcuate bonus
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

    }

    private static void displayAllEmployees() {

    }

    private static void generatePayslip() {

    }
    private static void filterEmployeesBySalary() {

    }
    private static void sortEmployeesByName() {

    }
}