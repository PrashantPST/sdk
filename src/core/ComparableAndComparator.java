package core;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableAndComparator {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Tom", "", 45, 80000);
        employees[1] = new Employee("Sam", "", 56, 75000);
        employees[2] = new Employee("Alex", "", 30, 120000);
        employees[3] = new Employee("Peter", "",25, 60000);
        employees[4] = new Employee("Peter", "",45, 60000);


        System.out.println("Before sorting: " + Arrays.toString(employees));
        Arrays.sort(employees, new NameSorter().thenComparing(new AgeSorter()).thenComparing(new SalarySorter()));
        System.out.println("After sorting: " + Arrays.toString(employees));
    }
}


class Employee {
    String getName() {
        return name;
    }

    private String name;
    private String jobTitle;

    int getAge() {
        return age;
    }

    int getSalary() {
        return salary;
    }

    private int age;
    private int salary;

    Employee(String name, String jobTitle, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return String.format("%s\t%s\t%d\t%d", name, jobTitle, age, salary);
    }
}

class NameSorter implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class AgeSorter implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
    }
}

class SalarySorter implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
