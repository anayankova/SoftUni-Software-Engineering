package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class Choreography {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = Integer.parseInt(scanner.nextLine());
        int dancers = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        double percentPerDay = Math.ceil((steps*1.0/days)/steps*100);
        double percentPerDancer = percentPerDay/dancers;

        if(percentPerDay<=13){
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.",percentPerDancer);
        }else{
            System.out.printf("No, they will not succeed in that goal! Required %.2f%% steps to be learned per day.",percentPerDancer);
        }

    }
}
