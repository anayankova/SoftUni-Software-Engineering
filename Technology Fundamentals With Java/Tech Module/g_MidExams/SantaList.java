package g_MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantaList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> kids = Arrays.stream(sc.nextLine().split("\\&"))
                .collect(Collectors.toList());

        String input = "";

        while (!"Finished!".equals(input = sc.nextLine())) {
            String[] command = input.split("\\s+");
            String option = command[0];
            String kidName = command[1];

            switch (option) {
                case "Bad":
                    if (!kids.contains(kidName)) {
                        kids.add(0, kidName);
                    }
                    break;
                case "Good":
                    if (kids.contains(kidName)) {
                        kids.remove(kidName);
                    }
                    break;
                case "Rename":
                    String newName = command[2];
                    if (kids.contains(kidName)) {
                        kids.set(kids.indexOf(kidName), newName);
                    }
                    break;
                case "Rearrange":
                    if (kids.contains(kidName)) {
                        String name = kidName;
                        kids.remove(kidName);
                        kids.add(name);
                    }
                    break;
            }
        }

        System.out.println(kids.toString().replaceAll("\\[|\\]", ""));
    }
}