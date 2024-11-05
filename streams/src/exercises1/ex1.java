package exercises1;

import java.util.Arrays;
import java.util.List;

public class ex1 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35));

        List<String> list = people.stream()
                .map(p -> "Name: " + p.getName() + " Age: " + p.getAge())
                .toList();
        System.out.println(list);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
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

    // Constructor, getters, and setters
}