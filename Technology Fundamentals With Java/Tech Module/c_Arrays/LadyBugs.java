package c_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeField = Integer.parseInt(scanner.nextLine());
        if (sizeField == 0){
            return;
        }
        int[] indexes = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();

        int[] field = new int[sizeField];


        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] >= 0 && indexes[i] < field.length){
                field[indexes[i]] = 1;
            }
        }
        while (!command.equals("end")) {

            String[] commandsFly = command.split(" ");

            int ladybugIndex = Integer.parseInt(commandsFly[0]);
            String direction = commandsFly[1];
            int flyLength = Integer.parseInt(commandsFly[2]);

            if (ladybugIndex >= 0
                    && ladybugIndex <= field.length - 1
                    && field[ladybugIndex] == 1
                    && Math.abs(flyLength) > 0) {
                if (flyLength < 0) {
                    flyLength *= -1;
                    if (direction.equals("right")) {
                        direction = "left";
                    } else {
                        direction = "right";
                    }
                }
                field[ladybugIndex] = 0;
                switch (direction) {
                    case "right":
                        if (ladybugIndex + flyLength < field.length) {
                            for (int i = ladybugIndex + flyLength; i < field.length; i += flyLength) {
                                if (field[i] == 0) {
                                    field[i] = 1;
                                    break;
                                }
                            }
                        }
                        break;
                    case "left":
                        if (ladybugIndex >= flyLength) {
                            for (int i = ladybugIndex - flyLength; i >= 0; i -= flyLength) {
                                if (field[i] == 0) {
                                    field[i] = 1;
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
            command = scanner.nextLine();
        }
        for (int element : field) {
            System.out.print(element + " ");
        }

    }
}
