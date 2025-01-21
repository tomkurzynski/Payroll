public sealed abstract class Employee permits FullTimeEmployee, PartTimeEmployee {
    private String name;
    private EmployeeLevel level;
    private Salary salary; //immutable type

    //constructor
    protected Employee(String name, EmployeeLevel level, Salary salary) throws InsufficientDataException {
        if (name == null || name.trim().isEmpty() || name.isBlank()) {
            throw new InsufficientDataException("Employee name is missing");
        }
        if (salary == null) {
            throw new InsufficientDataException("Employee salary is missing");
        }
        this.name = name;
        this.level = level;
        this.salary = salary;
    }

    //getters
    public String getName() {
        return name;
    }

    public EmployeeLevel getLevel() {
        return level;
    }

    public Salary getSalary() {
        return salary;
    }

    //abstract method
    public abstract double calculateMonthlyPay();

    public double calculateBonus() {
        return switch (level) {
            case JUNIOR -> salary.getBaseSalary() * 0.05;
            case MID -> salary.getBaseSalary() * 0.1;
            case SENIOR -> salary.getBaseSalary() * 0.15;
        };
    }

    //overloaded calculateBonus
    public double calculateBonus(double performanceIncrease) {
        double baseBonus = this.calculateBonus();
        return baseBonus * performanceIncrease;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Salary: %.2f", name, level, salary.getBaseSalary());
    }
}
