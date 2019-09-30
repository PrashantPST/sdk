package core.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * 1) remove  setters
 * 2) add an all-args constructor
 * 3) mark class as final to protect it from being extended
 * 4) initialize all non-primitive mutable fields via constructor by performing a deep copy
 * 5) perform cloning of the returned non-primitive mutable object in getter methods
 * 6) marking all class fields as final (optional)
 */

final class Hobbit {
    private final String name;
    private final Address address;
    private final List<String> stuff;


    // all args constructor :=>
    Hobbit(String name, Address address, List<String> stuff) {
        this.name = name;
        this.address = new Address(address.getCountry(), address.getCity());
        this.stuff = new ArrayList<>(stuff);
    }

    String getName() {
        return name;
    }

    Address getAddress() {
        return new Address(address.getCountry(), address.getCity());
    }

    List<String> getStuff() {
        return new ArrayList<>(stuff);
    }
}
