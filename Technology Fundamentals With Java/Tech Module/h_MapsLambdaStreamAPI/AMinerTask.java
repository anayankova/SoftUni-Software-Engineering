package h_MapsLambdaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = "";

        while (!"stop".equals(input = scanner.nextLine())){
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(resource)){
                resources.put(resource,quantity);
            }else{
                resources.put(resource,resources.get(resource)+quantity);
            }
        }

        resources.forEach((key, value) -> System.out.println(String.format("%s -> %d", key, value)));

    }
}
