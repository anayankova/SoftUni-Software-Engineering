package c_SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, String> phonebook = new HashMap<>();

        while (!(input = scanner.nextLine()).equals("search")) {
            String[] data = input.split("-");
            phonebook.put(data[0], data[1]);
        }

        while (!(input = scanner.nextLine()).equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            }else {
                System.out.println("Contact " + input + " does not exist.");
            }
        }


    }
}
