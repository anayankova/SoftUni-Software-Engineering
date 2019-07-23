package b_Inheritance.vehicle;

public class Main {
    public static void main(String[] args) {
        SportCar car = new SportCar(11,150);

        car.drive(1);

        System.out.println(car.getFuel());

    }
}
