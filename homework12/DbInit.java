package homework12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbInit {
    public static List<Employee> init() {
        List<Employee> employees = Arrays.asList(
            new Employee("john", Position.BOSS, 45, 1500),
            new Employee("gina", Position.ASSISTANT, 21, 650),
            new Employee("bill", Position.ENGINEER, 34, 1050),
            new Employee("john", Position.ENGINEER, 35, 1100),
            new Employee("mike", Position.ENGINEER, 33, 1150)
        );
        return employees;
    }
}
