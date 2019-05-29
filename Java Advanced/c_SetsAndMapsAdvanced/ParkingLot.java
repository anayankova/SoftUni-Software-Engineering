package c_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parkingLot = new HashSet<String>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] reminder = input.split(", ");
                if (reminder[0].equals("IN")) {
                    parkingLot.add(reminder[1]);
                } else {
                    parkingLot.remove(reminder[1]);
                }
            }
        }

        if(!parkingLot.isEmpty()) {

            for (String s : parkingLot) {
                System.out.println(s);
            }

            //parkingLot.forEach(System.out::println);

            //System.out.println(String.join(System.lineSeparator(), parkingLot));

        }else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
