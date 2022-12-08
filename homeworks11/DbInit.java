package homeworks11;

import java.util.ArrayList;
import java.util.List;

public class DbInit {
    public static List<Employee> init() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "boss", 1500, 45));
        employees.add(new Employee("Gina", "assistent", 650, 21));
        employees.add(new Employee("Bill", "engineer", 1050, 34));
        employees.add(new Employee("John", "engineer", 1100, 35));
        return employees;
    }
}
