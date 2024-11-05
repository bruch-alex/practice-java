package exercises2;

import java.util.List;
import java.util.stream.IntStream;

public class Section3 {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(-1,10)
                .boxed()
                .toList();

        Boolean areAllEven = list.stream()
                .allMatch(s -> s % 2 == 0);
        System.out.println(areAllEven);

        List<String> words = List.of(
                "ab",
                "abc",
                "abcd",
                "abcde",
                "abcdef"
        );

        Boolean hasWordWithLengthGreaterThan5 = words.stream()
                .anyMatch(s -> s.length() > 5);
        System.out.println(hasWordWithLengthGreaterThan5);


    }
}
