package homework6;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void addAll(T... fruits) {
        for (T fruit : fruits) {
            add(fruit);
        }
    }

    public void remove(T... fruits) {
        for (T fruit : fruits) {
            this.fruits.remove(fruit);
        }
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void clear() {
        fruits.clear();
    }

    public double getWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        double weight = 0;

        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<? super T> box) {
        box.fruits.addAll(this.fruits);
        clear();
    }

    @Override
    public String toString() {
        StringBuilder bc = new StringBuilder();
        bc.append("[");
        bc.append(fruits);
        bc.append("]");
        return bc.toString();
    }
}
