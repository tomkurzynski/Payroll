public class PayrollSystem {
    public static void main(String[] args) {

        //TODO:
        //TODO: ADD INTERACTIVE MENU ALLOWING THE USER TO ADD/DISPLAY/ETC
        //TODO: ADD, DISPLAY ALL, FILTER BY SALARY, SORT BY NAME, EXIT
        //TODO: CREATE AN INTERFACE -> TAX INFO + METHODS TO CALCULATE TAX DUE (20% & 40%)
        //TODO: GENERATE PAYSLIP METHOD
        //TODO: RECORDS???

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
}