package homework31;

final public class Dog {
    private String name;
    private int age;
    private int a;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                '}';
    }

    // вызов метода voice() объекта cat с помощью рефлекции
    // просмотреть статью и методичку
    // знать аннотации (для чего) - suppresswarning, override functional interface depricate  test

}
