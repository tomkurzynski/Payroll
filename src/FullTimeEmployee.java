public final class FullTimeEmployee extends Employee implements Taxable {

    public FullTimeEmployee(String name, EmployeeLevel level, Salary salary) throws InsufficientDataException {
        super(name, level, salary);
    }

    @Override
    public double calculateMonthlyPay() {
        return getSalary().getBaseSalary();
    }

    @Override
    public double calculateTax() {
        var empSalary = getSalary().getBaseSalary();
        if (empSalary < 40000)
            return empSalary * getLowerTaxRate();
        else
            return empSalary * getHigherTaxRate();
    }
}
