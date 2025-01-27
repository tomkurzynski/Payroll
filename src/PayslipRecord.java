import java.time.LocalDate;

public record PayslipRecord(String employeeName, double payAmount, LocalDate date) {
    public PayslipRecord {
        if (employeeName == null || employeeName.isBlank()) {
            throw new IllegalArgumentException("Employee name cannot be blank");
        }
        if (payAmount < 0) {
            throw new IllegalArgumentException("Pay amount cannot be negative");
        }
        if (date == null) {
            date = LocalDate.now();
        }
    }
}
