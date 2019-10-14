package core.java8;

public class DefaultAndStaticMethodsInAnInterface {
    public static void main(String[] args) {
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.turnAlarmOn());
        System.out.println(Vehicle.getHorsePower(231233, 34));
    }
}


interface Vehicle {

    String getBrand();

    String speedUp();

    /**
     * The most typical use of default methods in interfaces is to incrementally provide additional functionality to a given
     * type without breaking down the implementing classes.
     */
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }

    static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }
}

interface Alarm {

    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }
}

class Car implements Vehicle, Alarm {

    private String brand;

    Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
    }
}