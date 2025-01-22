public final class PartTimeEmployee extends Employee implements Taxable{

    private int hoursWorked;

    public PartTimeEmployee(String name, EmployeeLevel level, Salary salary, int hoursWorked) throws InsufficientDataException {
        super(name, level, salary);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateMonthlyPay() {
        return getSalary().getBaseHourlyRate() * hoursWorked;
    }

    @Override
    public double calculateTax() {
        var monthlyPay = calculateMonthlyPay();
        if (monthlyPay < 1000)
            return monthlyPay * getLowerTaxRate();
        else
            return monthlyPay * getHigherTaxRate();
    }
}
