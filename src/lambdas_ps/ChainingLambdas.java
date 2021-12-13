package lambdas_ps;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChainingLambdas {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("c1 consumes " + s);
        Consumer<String> c2 = s -> System.out.println("c2 consumes " + s);

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("Hello");

        Consumer<String> c4 = c1.andThen(c2);
        c4.accept("compose");

        Predicate<String> isNull = s -> s==null;
        System.out.println("For null = " + isNull.test(null));
        System.out.println("For hello = " + isNull.test("Hello"));

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("For empty = " + isEmpty.test(""));
        System.out.println("For hello = " + isEmpty.test("Hello"));

        Predicate<String> p = isNull.negate().and(isEmpty.negate());
        System.out.println("For null = " + p.test(null));
        System.out.println("For empty = " + p.test(""));
        System.out.println("For hello = " + p.test("Hello"));

    }

}
