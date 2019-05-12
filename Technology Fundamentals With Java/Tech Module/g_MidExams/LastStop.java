package g_MidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> paints = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";

        while (!"END".equals(input = scanner.nextLine())){
            List<String> data = Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.toList());

            String command = data.get(0);

            switch (command){
                case "Change":
                    if (paints.contains(data.get(1))){
                        int indexOf = paints.indexOf(data.get(1));
                        paints.set(indexOf,data.get(2));
                    }
                    break;
                case "Hide":
                        paints.remove(data.get(1));
                    break;
                case "Switch":
                    if(paints.contains(data.get(1)) && paints.contains(data.get(2))){
                        int indexOf1 = paints.indexOf(data.get(1));
                        int indexOf2 = paints.indexOf(data.get(2));
                        String element1 = data.get(1);
                        String element2 = data.get(2);
                        paints.set(indexOf1,element2);
                        paints.set(indexOf2,element1);
                    }
                    break;
                case "Insert":
                    if(paints.size() > Integer.parseInt(data.get(1))){
                        paints.add(Integer.parseInt(data.get(1))+1,data.get(2));
                    }
                    break;
                case "Reverse":
                    Collections.reverse(paints);
                    break;
            }


        }



        System.out.println(paints.toString().replaceAll("[\\[\\],]", ""));



    }
}
