package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfYear = scanner.nextLine();
        int holidays = Integer.parseInt(scanner.nextLine());
        int weekendsInHomeTown = Integer.parseInt(scanner.nextLine());

        int totalWeekends = 48;

        int weekendsInSofia = totalWeekends - weekendsInHomeTown;
        double saturdayGamesInSofia = weekendsInSofia * 3.0  / 4;
        double holidayGames = 2.0 / 3 * holidays;

        double totalGames = saturdayGamesInSofia + weekendsInHomeTown + holidayGames;

        if(typeOfYear.equals("leap")){
            totalGames = totalGames + totalGames * 0.15;
        }

        System.out.printf("%.0f",Math.floor(totalGames));

    }
}
