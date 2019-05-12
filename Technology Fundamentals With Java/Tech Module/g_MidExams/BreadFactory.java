package g_MidExams;

import java.util.Scanner;

public class BreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        int energy = 100;
        int coins = 100;
        int succes = 0;
        boolean isTrue = false;

        for (int i = 0; i < input.length; i++) {

            if (isTrue){
                break;
            }

            String[] event = input[i].split("-");
            String message = event[0];
            int n = Integer.parseInt(event[1]);

            switch (message) {
                case "rest":
                    energy += n;
                    if (energy >= 100) {
                        System.out.println("You gained 0 energy.");
                        System.out.println("Current energy: 100.");
                        energy = 100;
                    } else {
                        System.out.printf("You gained %d energy.%n", n);
                        System.out.printf("Current energy: %d.%n", energy);
                    }
                    succes++;
                    break;
                case "order":
                    energy -= 30;
                    if (energy <= 0) {
                        energy += 50;
                        System.out.println("You had to rest!");
                        break;
                    } else {
                        coins += n;
                        System.out.printf("You earned %d coins.%n", n);
                    }
                    succes++;
                    break;
                default:
                    coins -= n;
                    if (coins >= 0) {
                        System.out.printf("You bought %s.%n", message);
                        succes++;
                    } else {
                        System.out.printf("Closed! Cannot afford %s.%n", message);
                        isTrue = true;
                    }
                    break;
            }

        }

        if (succes == input.length) {
            System.out.println("Day completed!");
            System.out.printf("Coins: %d%n", coins);
            System.out.printf("Energy: %d%n", energy);
        }

    }
}
