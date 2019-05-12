package g_MidExams;

import java.util.Scanner;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int coins = 0;

        String[] rooms = scanner.nextLine().split("\\|");

        int bestRoom = 0;

        for (int i = 0; i < rooms.length; i++) {
            String[] roomData = rooms[i].split("\\s+");
            String firstToken = roomData[0];
            int tokenValue = Integer.parseInt(roomData[1]);

            if (firstToken.equals("potion")) {
                if (health + tokenValue > 100) {
                    tokenValue = 100 - health;
                }

                health += tokenValue;

                System.out.printf("You healed for %d hp.%n", tokenValue);
                System.out.printf("Current health: %d hp.%n", health);
            } else if (firstToken.equals("chest")) {
                System.out.printf("You found %d coins.%n", tokenValue);
                coins += tokenValue;
            } else {
                health -= tokenValue;

                if (health > 0) {
                    System.out.printf("You slayed %s.%n", firstToken);
                } else {
                    System.out.printf("You died! Killed by %s.%n", firstToken);
                    bestRoom = i + 1;
                    break;
                }
            }
        }

        if (health <= 0){
            System.out.println("Best room: " + bestRoom);
        }else {
            System.out.println("You've made it!");
            System.out.println("Coins: " + coins);
            System.out.println("Health: " + health);
        }

    }
}
