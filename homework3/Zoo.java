package homework3;

public class Zoo {
    public static void main(String[] args) {
        Cat cat = new Cat(100, 5);
        Dog dog = new Dog(400, 8);

        Animal [] animals = {cat, dog};
        for (Animal animal : animals) {
            animal.run();
            animal.swim();
        }
    }
}
