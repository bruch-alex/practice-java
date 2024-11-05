package exercises2;

import java.util.List;
import java.util.stream.IntStream;

public class Section4 {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(11,50)
                .boxed()
                .toList();

        int firstEven = list.stream()
                .filter(s -> s % 2 == 0)
                .findFirst()
                .get();

    }
}
