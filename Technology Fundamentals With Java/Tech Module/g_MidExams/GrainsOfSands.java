package g_MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrainsOfSands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> data = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = "";
        while (!("Mort".equals(input = scanner.nextLine())) && data.size() > 0) {
            String[] line = input.split("\\s+");
            String command = line[0];
            int value = Integer.parseInt(line[1]);

            switch (command) {
                case "Add":
                    data.add(value);
                    break;
                case "Remove":
                    if (data.contains(value)) {
                        data.remove(data.indexOf(value));
                    } else {
                        if (value >= 0 && value < data.size()) {
                            data.remove(value);
                        }
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(line[2]);
                    if (data.contains(value)) {
                        data.set(data.indexOf(value), replacement);
                    }
                    break;
                case "Increase":
                    int num = 0;
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i) >= value) {
                            num = data.get(i);
                            break;
                        }
                        num = data.get(data.size() - 1);
                    }

                    for (int i = 0; i < data.size(); i++) {
                        data.set(i, data.get(i) + num);
                    }
                    break;
                case "Collapse":
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i) < value) {
                            data.remove(i);
                            i--;
                        }
                    }
                    break;
            }
        }

        for (Integer element : data) {
            System.out.print(element + " ");
        }
    }
}