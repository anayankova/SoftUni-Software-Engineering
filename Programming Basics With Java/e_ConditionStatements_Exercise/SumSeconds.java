package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int time1 = Integer.parseInt(scanner.nextLine());
        int time2 = Integer.parseInt(scanner.nextLine());
        int time3 = Integer.parseInt(scanner.nextLine());

        int totalTime = time1 + time2 + time3;

        int minutes = totalTime/60; //изчисляваме минути
        int seconds = totalTime%60; //изчисляваме секунди

        if(seconds < 10){
            System.out.printf("%d:0%d", minutes, seconds);
        }else {
            System.out.printf("%d:%d", minutes,seconds);

        }

    }
}
