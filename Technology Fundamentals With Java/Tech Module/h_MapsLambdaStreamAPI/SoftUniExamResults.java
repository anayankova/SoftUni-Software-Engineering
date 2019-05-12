package h_MapsLambdaStreamAPI;

import java.util.HashMap;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> results = new HashMap<>();
        HashMap<String, Integer> submissions = new HashMap<>();

        String input = "";

        while (!"exam finished".equals(input = scanner.nextLine())) {
            String[] data = input.split("-");

            String name = data[0];
            String language = data[1];
            Integer result = 0;
            if(data.length >= 3) {
                result = Integer.parseInt(data[2]);
            }

            if (!results.containsKey(name)) {
                results.put(name, result);
            }else {
                if(result > results.get(name)){
                    results.replace(name, result);
                }
            }

            if (!submissions.containsKey(language)) {
                submissions.put(language, 1);
            }else{
                submissions.put(language, submissions.get(language) + 1);
            }

            if(language.equals("banned")){
                results.remove(name);
                submissions.remove(language);
            }

        }

        System.out.println("Results:");

        results.entrySet().stream()
                .sorted((e1,e2) -> {
                    int sort = Integer.compare(e2.getValue(),e1.getValue());
                    if(sort == 0){
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                }).forEach(kvp -> {
            System.out.println(String.format("%s | %d", kvp.getKey(), kvp.getValue()));
        });

        System.out.println("Submissions:");

        submissions.entrySet().stream()
                .sorted((e1,e2) -> {
                    int sort = Integer.compare(e2.getValue(),e1.getValue());
                    if(sort == 0){
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                }).forEach(kvp -> {
            System.out.println(String.format("%s - %d", kvp.getKey(), kvp.getValue()));
        });

    }
}
