package lambdas_ps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SomeMappings {

    public static void main(String[] args) {
        User sarah = new User("Sarah");
        User james = new User("James");
        User mary = new User("Mary");
        User john = new User("John");

        List<User> users = Stream.of(sarah, james, mary, john).collect(Collectors.toList());
        List<String> names = new ArrayList<>();

        Function<User, String> toName = User::getName;

        for (User user :
                users) {
            names.add(toName.apply(user));
        }

        Consumer<User> action = System.out::println;
        users.forEach(action);
    }

}
