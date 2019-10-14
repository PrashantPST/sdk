package core.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Java 8 allows 4 types of method references (these are references to a method).
 * A method reference to a static method => Class::staticMethod
 * A method reference to an instance method of an object of a particular type.
 * A method reference to an instance method of an existing object.
 * A method reference to a constructor.
 * In a method reference, you place the object (or class) that contains the method before the :: operator
 * and the name of the method after it without arguments.
 */
public class MethodReferences {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 12, 433, 5);
        Optional<Integer> max = integers
                .stream()
                .reduce(Math::max);
        max.ifPresent(System.out::println);
    }
}
