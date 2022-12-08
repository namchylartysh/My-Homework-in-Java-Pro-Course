package homeworks11;

import java.util.*;

public class Database {
    List<Employee> employees;
    Map<Integer, Employee> index;

    public Database(List<Employee> employees) {
        // create List
        this.employees = new ArrayList<>();
        this.employees.addAll(employees);
        // create map (index)
        this.index = new HashMap<>();
        for (Employee employee : employees) {
            index.put(employee.getId(), employee);
        }
    }

    public void create() {
        Employee employee = DataUtil.getEmployee("create: ");
        employees.add(employee);
        index.put(employee.getId(), employee);
    }

    public void read() {
        DataUtil.print(employees);
    }

    public void find() {
        String name = DataUtil.getString("find: ");
        List<Employee> found = new ArrayList<>();
        for (Employee employee : employees) {
        //    if (employee.getName().equalsIgnoreCase(name)) {
            if (employee.getName().contains(name)) {
                found.add(employee);
            }
        }
        DataUtil.print(found);
    }

    private Employee findById(int id) {
        return index.get(id);
 //       for (Employee employee : employees) {
 //           if (employee.getId() == id) {
 //               return employee;
 //           }
  //             }
  //      return null;
    }

    public void update() {
        int id = DataUtil.getInt("update, find by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            Employee tmp = DataUtil.getEmployeePart("update (position, salary, age): ");
            employee.update(tmp.getPosition(), tmp.getSalary(), tmp.getAge());
            System.out.println("Updated " + employee);
        }
    }

    public void delete() {
        int id = DataUtil.getInt("remove, find by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            employees.remove(employee);
            index.remove(employee.getId());
            System.out.println("Deleted " + employee);
        }
    }
}
