package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startHour = Integer.parseInt(scanner.nextLine());
        int startMinutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = startHour * 60 + startMinutes + 15;

        int hour = totalMinutes/60;
        int minutes = totalMinutes%60;

        if(hour == 24){
            hour = 0;
        }

        System.out.printf("%d:%02d", hour , minutes);

    }
}
