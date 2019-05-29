package c_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while (!name.equalsIgnoreCase("stop")){
            String email = scanner.nextLine();

            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                emails.putIfAbsent(name, email);
            }
            name = scanner.nextLine();
        }

        for(Map.Entry<String, String> entry : emails.entrySet()){
            System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue()));
        }

    }
}
