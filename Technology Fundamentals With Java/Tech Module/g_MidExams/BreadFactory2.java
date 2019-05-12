package g_MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BreadFactory2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> line = Arrays.stream(scan.nextLine().split("\\|")).
                collect(Collectors.toList());


        int energy = 100;
        int coins = 100;

        for (String s : line) {

            String[] data = s.split("-");
            int value = Integer.parseInt(data[1]);

            switch (data[0]) {

                case "rest":
                    if (energy + value <= 100) {
                        energy += value;
                        System.out.printf("You gained %d energy.%n", value);
                        System.out.printf("Current energy: %d.%n", energy);
                        break;
                    } else if (energy + value > 100) {
                        energy += 100 - energy;
                        System.out.printf("You gained %d energy.%n", 100 - energy);
                        System.out.printf("Current energy: %d.%n", energy);
                    }
                    break;
                case "order":
                    if (energy >= 30) {
                        coins += value;
                        System.out.printf("You earned %d coins.%n", value);
                        energy -= 30;
                        break;
                    } else {
                        System.out.println("You had to rest!");
                        energy += 50;
                    }
                    break;
                default:
                    if (value >= coins) {
                        System.out.printf("Closed! Cannot afford %s.%n", data[0]);

                        return;
                    } else {
                        System.out.printf("You bought %s.%n", data[0]);
                        coins -= value;
                        break;
                    }
            }
        }


        System.out.println("Day completed!");
        System.out.printf("Coins: %d%n", coins);
        System.out.printf("Energy: %d%n", energy);

    }
}