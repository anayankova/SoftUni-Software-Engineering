package f_DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            ArrayList<Tire> tires = new ArrayList<>();
            Tire tire;

            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            tire = new Tire(tire1Pressure,tire1Age);
            tires.add(tire);

            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            tire = new Tire(tire2Pressure,tire2Age);
            tires.add(tire);

            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            tire = new Tire(tire3Pressure,tire3Age);
            tires.add(tire);

            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            tire = new Tire(tire4Pressure,tire4Age);
            tires.add(tire);

            Car car = new Car(model, engine, cargo, tires);
            cars.put(model, car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")){
            cars.values().stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> {
                        for (Tire tire : car.getTires()) {
                            if (tire.getPressure() < 1) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .forEach(car -> System.out.println(car.getModel()));
        }else if (command.equals("flamable")){
            cars.values().stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}