package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class ThreeBrothers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double timeBrother1 = Double.parseDouble(scanner.nextLine());
        double timeBrother2 = Double.parseDouble(scanner.nextLine());
        double timeBrother3 = Double.parseDouble(scanner.nextLine());
        double timeFatherFishing = Double.parseDouble(scanner.nextLine());

        double totalTime = 1/(1/timeBrother1 + 1/timeBrother2 + 1/timeBrother3);
        double timeWithRest =  totalTime + 0.15*totalTime;

        System.out.printf("Cleaning time: %.2f%n", timeWithRest);

        if (timeWithRest <= timeFatherFishing){
            double left = Math.floor(timeFatherFishing-timeWithRest);
            System.out.printf("Yes, there is a surprise - time left -> %.0f hours.", left);
        }else{
            double needTime = Math.ceil(timeWithRest-timeFatherFishing);
            System.out.printf("No, there isn't a surprise - shortage of time -> %.0f hours.", needTime);
        }

    }
}
