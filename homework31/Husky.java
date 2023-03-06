package homework31;

public class Husky {
    private String name;
    private int age;

    public Husky(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void voice() {
        System.out.println("woof-woof");
    }

    public void jump(int age) {
        System.out.println("Husky jumped");
    }
}
