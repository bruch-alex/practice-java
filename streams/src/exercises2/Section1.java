package exercises2;

import java.util.List;

public class Section1 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 82, 3, 15, 6);

        var minResult = list.stream().reduce((x, y) -> x < y ? x : y);
        //int minResult = list.stream().reduce(list.get(0),(x, y) -> x < y ? x : y);
        //System.out.println(minResult);
        var maxResult = list.stream().reduce((x, y) -> x > y ? x : y);

        System.out.println(minResult.get());
        System.out.println(maxResult.get());
    }

}
