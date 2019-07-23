package e_Polymorphism.vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = produceVehicle(scanner.nextLine().split("\\s+"));
        Vehicle truck = produceVehicle(scanner.nextLine().split("\\s+"));

        Map<String, Vehicle> vehicles = new HashMap<>();

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            String output = null;

            if(tokens[0].equals("Drive")){
                output = vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            }else {
                vehicles.get(tokens[1]).reFuel(Double.parseDouble(tokens[2]));
            }

            if(output != null){
                System.out.println(output);
            }
        }

        vehicles.forEach((key, value) -> System.out.println(value));


    }

    public static Vehicle produceVehicle(String[] data) {

        Vehicle vehicle = null;

        if (data[0].equals("Car")) {
            vehicle = new Car(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]));
        } else if(data[0].equals("Truck")){
            vehicle = new Truck(Double.parseDouble(data[1]),
                    Double.parseDouble(data[2]));
        }

        return vehicle;
    }
}
