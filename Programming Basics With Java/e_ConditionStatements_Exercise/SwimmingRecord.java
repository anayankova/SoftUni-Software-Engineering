package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class SwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double speed = Double.parseDouble(scanner.nextLine());

        double swimmingTime = distance*speed;
        double delay = Math.floor(distance/15)*12.5;

        double totalTime = swimmingTime+delay;

        if(totalTime<record){
            System.out.printf(" Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        }else {
            double needsSeconds = totalTime - record;

            System.out.printf("No, he failed! He was %.2f seconds slower.", needsSeconds);
        }
    }
}
