package homework8;

import lesson8.RubberList;

/**
 * Java Professional Homework #8
 *
 * @author Artysh
 * @version 24.11 - 28.11
 */

public class HomeWork8 {
    public static void main(String[] args) {
        lesson8.RubberList<String> cities = new RubberList<>();
        System.out.println(cities);
        cities.add("New York");
        cities.add("Barcelona");
        cities.add("Los Angeles");
        cities.add("Jerusalem");
        System.out.println(cities);
        cities.remove("New York");
        cities.remove("Jerusalem");
        System.out.println(cities);
    }
}
