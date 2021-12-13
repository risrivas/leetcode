package lambdas_ps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoreLambdas {

    public static void main(String[] args) {
        List<String> strings = Stream.of("one", "two", "three", "four", "five").collect(Collectors.toList());

//        Predicate<String> predicate = (str) -> str.startsWith("t");
        strings.removeIf((str) -> str.startsWith("t"));

//        Consumer<String> consumer = System.out::println;
        strings.forEach(System.out::println);
    }

}
