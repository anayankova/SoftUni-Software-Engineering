package l_NestedLoop_Lab;

import java.util.Scanner;

public class NmeWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int winnerPoints = 0;
        String winnerName = "";

        while (true) {
            String name = scanner.nextLine();
            if (name.equals("STOP")) {
                break;
            }
            //name.charAt(1);

            int points = 0;

            for (int i = 0; i < name.length(); i++) {
                points += name.charAt(i);
            }

            if (points > winnerPoints) {
                winnerPoints = points;
                winnerName = name;
            }
        }

        System.out.printf("Winner is %s - %d!", winnerName, winnerPoints);

    }
}
