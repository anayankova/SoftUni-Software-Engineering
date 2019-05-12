package k_ForLoop_Exercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OddEvenPositions2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddSum = 0.0;
        double oddMin = 10000000000.0;
        double oddMax = -10000000000.0;
        double evenSum = 0.0;
        double evenMin = 10000000000.0;
        double evenMax = -10000000000.0;

        for (int i = 1; i <= n ; i++) {
            double number = Double.parseDouble(scanner.nextLine());

            if (i % 2 ==0){
                evenSum += number;
                if (number > evenMax){
                    evenMax = number;
                }
                if (number < evenMin) {
                    evenMin = number;
                }
            } else {
                oddSum += number;
                if (number > oddMax){
                    oddMax = number;
                }
                if (number < oddMin){
                    oddMin = number;
                }
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("OddSum="+ df.format(oddSum));
        if (oddMin == 10000000000.0){
            System.out.println("OddMin=No");
        } else{
            System.out.println("OddMin="+ df.format(oddMin));
        }
        if (oddMax == -10000000000.0){
            System.out.println("OddMax=No");
        } else {
            System.out.println("OddMax="+ df.format(oddMax));
        }

        System.out.println("EvenSum="+ df.format(evenSum));
        if (evenMin == 10000000000.0){
            System.out.println("EvenMin=No");
        } else {
            System.out.println("EvenMin="+ df.format(evenMin));
        }
        if (evenMax == -10000000000.0){
            System.out.println("EvenMax=No");
        } else {
            System.out.println("EvenMax=" + df.format(evenMax));
        }

    }
}
