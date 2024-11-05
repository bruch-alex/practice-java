package exercises2;

import java.util.List;
import java.util.stream.IntStream;

public class Section2 {
    public static void main(String[] args) {
        // Original list
        List<Integer> list = IntStream.range(1, 101)
                .boxed()
                .toList();

        //list.forEach(System.out::println);

        // First 5 even numbers
        List<Integer> first5Even = list.stream()
                .filter(s -> s % 2 == 0)
                .limit(5)
                .toList();

        first5Even.forEach(System.out::println);

        // 10 after 50 numbers
        var list10After50 = list.stream()
                .skip(50)
                .limit(10)
                .toList();

        list10After50.forEach(System.out::println);
    }
}
