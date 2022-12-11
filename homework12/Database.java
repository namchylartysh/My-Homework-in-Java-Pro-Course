package homework12;

import java.util.*;

public class Database {
    List<Employee> employees;
    Map<Integer, Employee> indexMap;


    public void init(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
        this.indexMap = new HashMap<>();
        for (Employee employee : employees) {
            indexMap.put(employee.getId(), employee);
        }
    }

    public void create() {
        Employee employee = DataUtil.getEmployee("create: ");
        if (employee != null) {
            employees.add(employee);
            indexMap.put(employee.getId(), employee);
            System.out.println("Added " + employee);
        }
    }

    public void read() {
        DataUtil.print(employees);
    }

    public void find() {
        String name = DataUtil.getString("find: ");
        List<Employee> found = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().contains(name)) {
                found.add(employee);
            }
        }
        DataUtil.print(found);
    }

    private Employee findById(int id) {
        return indexMap.get(id);
    /*  for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;  */
    }

    public void update() {
        int id = DataUtil.getInt("update, find by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            Employee tmp = DataUtil.getEmployeePart("update (position, age, salary): ");
            if (tmp != null) {
                employee.update(tmp.getPosition(), tmp.getAge(), tmp.getSalary());
                System.out.println("updated" + employee);
            }
        }
    }

    public void delete() {
        int id = DataUtil.getInt("remove, find by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            employees.remove(employee);
            indexMap.remove(employee.getId());
            System.out.println("Deleted " + employee);
        }
    }

    public void positions() {
        List<Position> positions = new ArrayList<>();
        for (Employee employee : employees) {
            positions.add(employee.getPosition());
        }
        System.out.println(new HashSet<>(positions));
    }

    public void sort() {
        Map<Integer, Employee> sortMap = new TreeMap<>();
        for (Employee employee : employees) {
            sortMap.put(employee.getAge(), employee);
        }
        // create sorted list
        List<Employee> sortList = new ArrayList<>();
        for (Integer key : sortMap.keySet()) {
            sortList.add(sortMap.get(key));
        }
        DataUtil.print(sortList);
    }
}
