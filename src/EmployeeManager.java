import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManager {
    private final List<Employee> employees = new ArrayList<>();

    //add employees => varargs
    public void addEmployees(Employee... newEmployees) {
        Collections.addAll(employees, newEmployees);
    }

    //return employees => defensive copy
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    //filter by salary range => lambda + predicate
    public List<Employee> filterEmployeesBySalary(double min, double max) {
        return employees.stream()
                .filter(e -> {
                    double monthlyPay = e.calculateMonthlyPay();
                    return monthlyPay >= min && monthlyPay <= max;
                })
                .toList();
    }

    //sort by name => method reference
    public List<Employee> sortEmployeesByName() {
        return employees.stream()
                .sorted(EmployeeManager::compareByName)
                .toList();
    }

    private static int compareByName(Employee e1, Employee e2) {
        return e1.getName().compareToIgnoreCase(e2.getName());
    }
}
