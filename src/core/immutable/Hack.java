package core.immutable;

import java.util.ArrayList;
import java.util.List;

public class Hack {
    public static void main(String[] args) {
        Address address = new Address("Hobitton", "Shire");

        List<String> stuff = new ArrayList<>();
        stuff.add("Sword");
        stuff.add("Ring of Power");

        Hobbit hobbit = new Hobbit("Frodo Baggins", address, stuff);

        System.out.println("Hobbit country: " + hobbit.getAddress().getCountry());
        System.out.println("Hobbit city: " + hobbit.getAddress().getCity());
        System.out.println("Hobbit stuff: " + hobbit.getStuff());

        List<String> hobbitStuff = hobbit.getStuff();
        hobbitStuff.remove("Ring of Power");
        hobbitStuff.remove("Sword");

        System.out.println("Immutability has been hacked!");

        System.out.println("Hobbit country: " + hobbit.getAddress().getCountry());
        System.out.println("Hobbit city: " + hobbit.getAddress().getCity());
        System.out.println("Hobbit stuff: " + hobbit.getStuff());
    }
}
