package homework17;

import lesson12.DbInit;
import lesson12.Employee;
import lesson12.Position;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Java Professional Homework #17
 *
 * @author Artysh
 * @version 12.01 - 16.01
 */


public class Homework17 {
    public static void main(String[] args) {
        List<Employee> employees = DbInit.init();

        // фильтрация списка
        List<Employee> engineers = employees.stream()
                .filter(e -> e.getPosition() == Position.ASSISTANT)
                .collect(Collectors.toList());
        System.out.println(engineers);

        // преобразование списка
        Set<Position> positions = employees.stream()
                .map(e -> e.getPosition())
                //.distinct()
                .collect(Collectors.toSet());
        System.out.println(positions);

        // преобразование списка в map
        Map<Integer, Employee> employeeMap = employees.stream()
                //.collect(Collectors.toMap(e -> e.getId(), e -> e));
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println(employeeMap);

        // преобразование в сложнуюю map
        Map<Position, List<Employee>> positionMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition));
        System.out.println(positionMap);

        codeFromArticle();
        task();

    }

    static void codeFromArticle() {
        // найти сумму нечетных чисел в коллекции

        Collection<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        // посчитать сколько раз объект "High" встречается в коллекции
        System.out.println(collection.stream()
                .filter(e -> e.equals("High"))
                .count());
        // получить первый элемент в коллекции. если коллекция пустая, то возвращается 0
        System.out.println(collection.stream()
                .findFirst()
                .orElse("0"));
        // получить первый элемент, соответствующий заданному условию
        System.out.println(collection.stream()
                .filter(e -> e.equals("Load"))
                .findFirst()
                .get());
        // получить последний элемент в коллекции. Если нет, возвращает 0
        System.out.println(collection.stream()
                .skip(collection.size() - 1)
                .findFirst()
                .orElse("0"));
        // получить первый элемент после заданного порядка
        System.out.println(collection.stream()
                .skip(1)
                .findFirst()
                .get());
        // получить определенные элементы коллекции, превратить в массив
        System.out.println(Arrays.toString(collection.stream()
                .skip(1)
                .limit(2)
                .toArray()));
        Collection<String> collection2 = Arrays.asList("f10", "f15", "f2", "f4");
        // получить самый маленький элемент
        System.out.println(collection2.stream().min(String::compareTo).get()); // не работает
        // получить максимальное значение
        System.out.println(collection2.stream().max(String::compareTo).get()); // не работает
        // отсортировать строки в алфавитном порядке и добавить в массив
        System.out.println(collection2.stream().sorted().collect(Collectors.toList()));

    }

    static void task() {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );
        // посчитать средний возраст
        System.out.println(students.stream()
                .filter(e -> e.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .getAsDouble());
        // кто из студентов получит повестку
        System.out.println(students.stream()
                .filter(e -> e.getAge() >= 18 && e.getAge() < 27 && e.getGender() == Gender.MAN)
                .collect(Collectors.toList()));
    }





    static void firstMeeting() {
        List<Employee> employees = DbInit.init();

        long count = 0;
        for (Employee employee : employees) {
            if (employee.getPosition() == Position.ENGINEER) {
                count++;
            }
        }
        System.out.println(count);

        count = 0;
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getPosition() == Position.ENGINEER) {
                count++;
            }
        }
        System.out.println(count);

        count = employees.stream()
                .filter(employee -> employee.getPosition() == Position.ENGINEER)
                .count();
        System.out.println(count);

        int sum = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }
}
