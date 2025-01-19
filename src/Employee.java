public sealed abstract class Employee permits FullTimeEmployee, PartTimeEmployee {
    private String name;
    private EmployeeLevel level;
    private Salary salary;

    protected Employee(String name, EmployeeLevel level, Salary salary) throws InsufficientDataException {
        if (name == null || name.trim().equals("") || name.isBlank()) {
            throw new InsufficientDataException("Employee name is missing");
        }
        if (salary == null) {
            throw new InsufficientDataException("Employee salary is missing");
        }
        this.name = name;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public EmployeeLevel getLevel() {
        return level;
    }

    public Salary getSalary() {
        return salary;
    }

    public abstract double calculateMonthlyPay();

    public double calculateBonus() {
        return switch (level) {
            case JUNIOR -> salary.getBaseSalary() * 0.05;
            case MID -> salary.getBaseSalary() * 0.1;
            case SENIOR -> salary.getBaseSalary() * 0.15;
        };
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Salary: %.2f", name, level, salary.getBaseSalary());
    }
}
