package homework31;

/**
 * Java Professional Homework #31
 *
 * @author Artysh
 * @version 27.02 - 02.03
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Homework31 {
    public static void main(String[] args) {
        String s = "Java";
        // первый вариант получения объекта
        Class stringClass = s.getClass();

        // второй вариант
        Class strClass = String.class;
        Class intClass = int.class;
        Class voidClass = void.class;

        // вывод на консоль
        System.out.println(stringClass.getName());
        System.out.println(stringClass.getSimpleName());

        System.out.println(intClass.getName());
        System.out.println(voidClass.getName());

        Class dogClass = Dog.class;
        System.out.println(dogClass.getName());
        System.out.println("Superclass: " + dogClass.getSuperclass().getName());
        int m = dogClass.getModifiers();
        if (Modifier.isPublic(m)) {
            System.out.println("public");
        }
        if (Modifier.isAbstract(m)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(m)) {
            System.out.println("final");
        }

        System.out.println("Fields: ");
        Field[] fields = dogClass.getFields();
        for (Field f : fields) {
            System.out.println(f.getType() + ": " + f.getName());
        }

        fields = dogClass.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType() + ": " + f.getName());
        }

        System.out.println("Methods:");
        Method[] methods = Husky.class.getDeclaredMethods();
        for (Method o : methods) {
            System.out.println(
                    "Type of method: " + o.getReturnType() + ";\nName of method: " + o.getName() + ";\nParameter type: " + Arrays.toString(o.getParameterTypes()));
        }
    }
}
