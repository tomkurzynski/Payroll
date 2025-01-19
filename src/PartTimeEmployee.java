public final class PartTimeEmployee extends Employee {

    private int hoursWorked;

    public PartTimeEmployee(String name, EmployeeLevel level, Salary salary, int hoursWorked) throws InsufficientDataException {
        super(name, level, salary);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateMonthlyPay() {
        return getSalary().getBaseHourlyRate() * hoursWorked;
    }
}
