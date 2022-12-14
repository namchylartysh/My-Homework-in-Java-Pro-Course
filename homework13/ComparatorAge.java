package homework13;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getAge() - o1.getAge();
    }
}
