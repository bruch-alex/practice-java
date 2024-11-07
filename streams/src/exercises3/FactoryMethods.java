package exercises3;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

public class FactoryMethods {
    public static void main(String[] args) {
        // Practice
        Stream.of(1, 2, 3, 4, 5)
                .forEach(System.out::println);

        Stream.of("Apple", "Orange", "Banana")
                .forEach(System.out::println);

        // Extra
        Stream.generate(() -> new Random().nextInt(100) + 1)
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(UUID::randomUUID)
                .limit(5)
                .forEach(System.out::println);

        //Bonus
        Stream.iterate(1, s -> s * 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
                .map(s -> s[0])
                .limit(8)
                .forEach(System.out::println);

        // Challenge
        Stream.iterate(new int[]{1, 1}, s -> new int[]{s[0] * -1, (s[1] + s[0]) * -1})
                .map(s -> s[1])
                .limit(10)
                .forEach(System.out::println);
    }
}
