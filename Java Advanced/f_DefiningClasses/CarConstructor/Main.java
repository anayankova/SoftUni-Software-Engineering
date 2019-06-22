package f_DefiningClasses.CarConstructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
                Car car = new Car(data[0]);
                if(data.length == 1){
                    car.setMake(data[0]);
                    System.out.println(car.carInfo());
                }else {
                    car.setMake(data[0]);
                    car.setModel(data[1]);
                    car.setHorsePower(Integer.parseInt(data[2]));
                    System.out.println(car.carInfo());
                }
        }


    }
}
