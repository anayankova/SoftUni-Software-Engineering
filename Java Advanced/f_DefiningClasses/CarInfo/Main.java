package f_DefiningClasses.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = new Car();

       //car.setMake("Chevrolet");
       //car.setModel("Impala");
       //car.setHorsePower(390);

       //System.out.println(String.format("The car is: %s %s - %d HP", car.getMake(), car.getModel(), car.getHorsePower()));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            car.setMake(data[0]);
            car.setModel(data[1]);
            car.setHorsePower(Integer.parseInt(data[2]));
            System.out.println(car.carInfo());
        }


    }

}
