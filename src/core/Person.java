package core;

import java.util.Date;

/**
 * Simple Java Class to represent Person with name, id and date of birth.
 *
 * @author Prashant Kumar
 */
public class Person implements Comparable<Person> {

    private int id;
    private String name;
    private int weight;
    private Date dob;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && weight == person.weight && name.equals(person.name) && dob.equals(person.dob);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + weight;
        result = 31 * result + dob.hashCode();
        return result;
    }

    Person( int id, String name, int weight, Date dob) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.dob = dob;
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }


}
