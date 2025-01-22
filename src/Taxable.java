public sealed interface Taxable permits FullTimeEmployee, PartTimeEmployee {
    //static constant
    static final double LOWER_TAX_RATE = 0.2;
    static final double HIGHER_TAX_RATE = 0.4;

    //abstract method
    double calculateTax();

    //default method
    default double getLowerTaxRate() {
        return LOWER_TAX_RATE;
    }

    default double getHigherTaxRate() {
        return HIGHER_TAX_RATE;
    }

    //static method
    static double calculateTax(double amount, double taxRate) {
        return amount * taxRate;
    }

    //private method
    private static void logTaxCalculation(double amount, double taxRate) {
        System.out.printf("Calculating tax for amount %.2f with rate %.2f%n", amount, taxRate);
    }
}
