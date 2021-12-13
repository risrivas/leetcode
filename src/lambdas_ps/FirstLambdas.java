package lambdas_ps;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdas {

    public static void main(String[] args) {
        // Supplier
        Supplier<String> supplier = () -> {
            System.out.println("Inside Supplier");
            return "Hello";
        };
        System.out.println(supplier.get());

        // Consumer
        Consumer<String> consumer = (str) -> {
            System.out.println("Inside Consumer");
            System.out.println(str);
        };
        consumer.accept("Hello From Consumer");
    }

}
