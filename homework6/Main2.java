package homework6;

public class Main2 {
    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Apple> box11 = new Box<>();
        Box<Orange> box22 = new Box<>();

        box1.addAll(apple1, apple2, apple3, apple4, apple5, apple6);
        box2.addAll(orange1, orange2, orange3);
        System.out.println(box1.compare(box2));
        box2.add(orange4);
        System.out.println(box1.compare(box2));
        box1.remove(apple2);
        System.out.println(box1.compare(box2));

        box1.transfer(box11);
        System.out.println(box2);
    }
}
