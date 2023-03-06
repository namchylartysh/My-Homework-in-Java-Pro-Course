package homework31;

import java.lang.reflect.Field;

public class ReflectionDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Richie", 5);
        System.out.println(dog);

        try {
            Field field = dog.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(dog, 8);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dog);
    }
}
