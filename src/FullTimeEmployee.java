public final class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, EmployeeLevel level, Salary salary) throws InsufficientDataException {
        super(name, level, salary);
    }

    @Override
    public double calculateMonthlyPay() {
        return getSalary().getBaseSalary();
    }
}
