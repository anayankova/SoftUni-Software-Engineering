package g_MidExams;

import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int coins = 0;

        for (int day = 1; day <= days; day++) {
            if (day % 10 == 0) {
                partySize -= 2;
            }

            if (day % 15 == 0) {
                partySize += 5;
            }

            coins += (50 - 2 * partySize);

            if (day % 3 == 0) {
                coins -= (3 * partySize);
            }

            if (day % 5 == 0) {
                if (day % 3 == 0) {
                    coins += (18 * partySize);
                } else {
                    coins += (20 * partySize);
                }
            }


        }
        System.out.println(partySize + " companions received " + coins / partySize + " coins each.");

    }
}
