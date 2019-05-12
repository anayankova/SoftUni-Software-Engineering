package h_MapsLambdaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> parkingLicenses = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];

            switch (command) {
                case "register":
                    String username = data[1];
                    String licensePlateNumber = data[2];
                    if (!parkingLicenses.containsKey(username)) {
                        parkingLicenses.put(username, licensePlateNumber);
                        System.out.println(String.format("%s registered %s successfully", username, licensePlateNumber));
                    } else {
                        System.out.println(String.format("ERROR: already registered with plate number %s", licensePlateNumber));
                    }

                    break;

                case "unregister":
                    String unregisterUser = data[1];
                    if (!parkingLicenses.containsKey(unregisterUser)) {
                        System.out.println(String.format("ERROR: user %s not found", unregisterUser));
                    } else {
                        parkingLicenses.remove(unregisterUser);
                        System.out.println(String.format("%s unregistered successfully", unregisterUser));
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> kvp : parkingLicenses.entrySet()) {
            System.out.println(String.format("%s => %s", kvp.getKey(), kvp.getValue()));
        }
    }
}