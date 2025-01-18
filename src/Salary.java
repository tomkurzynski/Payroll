public final class Salary {
    private final double baseSalary;
    private final double baseHourlyRate;

    public Salary(double baseSalary, double baseHourlyRate) {
        if (baseSalary < 0 || baseHourlyRate < 0) {
            throw new IllegalArgumentException("baseSalary and baseHourlyRate must be non-negative");
        }
        this.baseSalary = baseSalary;
        this.baseHourlyRate = baseHourlyRate;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBaseHourlyRate() {
        return baseHourlyRate;
    }
}
