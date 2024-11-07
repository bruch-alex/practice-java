package exercises3;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStreams {
    public static void main(String[] args) {

        // Practice
        System.out.println("=1 to 10=");
        IntStream.range(1, 11)
                .boxed()
                .forEach(System.out::println);

        System.out.println("\n=Double stream 5 elements with 1.5=");
        DoubleStream.generate(() -> 1.5)
                .limit(5)
                .boxed()
                .forEach(System.out::println);

        // Extra
        System.out.println("\n=Sum of 100 numbers=");
        var sum = IntStream.rangeClosed(1, 100)
                .sum();
        System.out.println(sum);

        System.out.println("\n=Even numbers from 1 to 20=");
        IntStream.rangeClosed(1, 20)
                .filter(s -> s % 2 == 0)
                .boxed()
                .forEach(System.out::println);

        // Bonus
        System.out.println("\n=First 5 squares=");
        DoubleStream.iterate(1, s -> s + 1)
                .filter(s -> Math.sqrt(s) % 1 == 0)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n=First 10 primes=");
        /* Stupid but why not? xD
           IntStream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
                .boxed()
                .forEach(System.out::println);
        */

        IntStream.iterate(1, s -> s + 1)
                .filter(NumericStreams::isPrime)
                .limit(10)
                .forEach(System.out::println);

        // Challenge
        System.out.println("=Triangular numbers=");
        IntStream.iterate(1, s -> s + 1)
                .filter(NumericStreams::isTriangular)
                .limit(8)
                .forEach(System.out::println);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isTriangular(int number) {
        int sum = 0;
        for (int i = 1; sum < number; i++) {
            sum += i;
            if (sum == number) return true;
        }
        return false;
    }
}
