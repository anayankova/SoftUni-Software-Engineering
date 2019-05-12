package g_NestedConditionalStatements_Exercise;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourExam = Integer.parseInt(scanner.nextLine());
        int minuteExam = Integer.parseInt(scanner.nextLine());
        int hourArrive = Integer.parseInt(scanner.nextLine());
        int minuteArrive = Integer.parseInt(scanner.nextLine());

        int totalExam = hourExam *60 + minuteExam;
        int totalArrive = hourArrive * 60 + minuteArrive;

        if (totalArrive > totalExam){
            System.out.println("Late");
            if ((totalArrive-totalExam) <=59){
                System.out.printf("%d minutes after the start", totalArrive-totalExam);
            }else if ((totalArrive-totalExam) >59){
                System.out.printf("%d:%02d hours after the start", (totalArrive-totalExam)/60,(totalArrive-totalExam)%60);
            }
        }else if (totalArrive == totalExam || (totalExam-totalArrive)<=30){
            System.out.println("On time");
            if (totalArrive != totalExam){
                System.out.printf("%d minutes before the start", totalExam - totalArrive);
            }
        }else if ((totalExam-totalArrive) > 30){
            System.out.println("Early");
            if((totalExam-totalArrive) <= 59){
                System.out.printf("%d minutes before the start", totalExam - totalArrive);
            }else if ((totalExam-totalArrive) > 59){
                System.out.printf("%d:%02d hours before the start",(totalExam-totalArrive)/60,(totalExam-totalArrive)%60);
            }
        }

    }
}
