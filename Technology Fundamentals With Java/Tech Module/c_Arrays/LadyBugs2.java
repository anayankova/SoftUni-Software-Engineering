package c_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LadyBugs2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int fieldSize = Integer.parseInt(reader.readLine());

        int[] ladyBugs = new int[fieldSize];

        int[] ladybugIndices = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(e -> e >= 0 && e < fieldSize).toArray();

        for (int i = 0; i < ladybugIndices.length; i++) {
            ladyBugs[ladybugIndices[i]] = 1;
        }

        String input = "";

        while (!"end".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            int ladybugIndex = Integer.parseInt(data[0]);
            String direction = data[1];
            int flyLength = Integer.parseInt(data[2]);

            if (ladybugIndex >= 0 && ladybugIndex < ladyBugs.length
                    && ladyBugs[ladybugIndex] == 1) {

                ladyBugs[ladybugIndex] = 0;

                while (true) {
                    switch (direction) {
                        case "left":
                            ladybugIndex -= flyLength;
                            break;
                        case "right":
                            ladybugIndex += flyLength;
                            break;
                    }

                    if (ladybugIndex < 0 || ladybugIndex >= fieldSize) {
                        break;
                    }

                    if (ladyBugs[ladybugIndex] == 1) {
                        continue;
                    }

                    if (ladyBugs[ladybugIndex] == 0) {
                        ladyBugs[ladybugIndex] = 1;
                        break;
                    }
                }
            }

        }
        System.out.println(Arrays.stream(ladyBugs)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
