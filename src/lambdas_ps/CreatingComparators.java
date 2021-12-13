package lambdas_ps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreatingComparators {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        Comparator<String> cmp = Comparator.comparingInt(String::length);
        strings.sort(cmp);
        strings.forEach(System.out::println);
    }

}
