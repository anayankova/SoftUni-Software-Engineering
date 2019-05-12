package k_ForLoop_Exercise;

import java.util.Scanner;

public class OddEvenPositions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double number = 0;
        double oddSum = 0;
        double oddMin = 1000000000;
        double oddMax = -1000000000;
        double evenSum = 0;
        double evenMin = 1000000000;
        double evenMax = -1000000000;

        for (int i = 1; i <= n; i++) {
            number = Double.parseDouble(scanner.nextLine());
            if (i % 2 != 0) {
                oddSum += number;
                if (number < oddMin) {
                    oddMin = number;
                }
                if (number > oddMax) {
                    oddMax = number;
                }
            }

            if (i % 2 == 0) {
                evenSum += number;
                if (number < evenMin) {
                    evenMin = number;
                }
                if (number > evenMax) {
                    evenMax = number;
                }
            }
        }

        //oddMin= Double.parseDouble("No");

        if ((oddMin == 1000000000 || oddMax == -1000000000) && (evenMin == 1000000000 || evenMax == -1000000000)) {
            System.out.println("OddSum=" + oddSum + ",");
            System.out.println("OddMin=" + "No" + ",");
            System.out.println("OddMax=" + "No" + ",");
            System.out.println("EvenSum=" + evenSum + ",");
            System.out.println("EvenMin=" + "No" + ",");
            System.out.println("EvenMax=" + "No" + ",");
        }else if (oddMin == 1000000000 || oddMax == -1000000000) {
            System.out.println("OddSum=" + oddSum + ",");
            System.out.println("OddMin=" + "No" + ",");
            System.out.println("OddMax=" + "No" + ",");
            System.out.println("EvenSum=" + evenSum + ",");
            System.out.println("EvenMin=" + evenMin + ",");
            System.out.println("EvenMax=" + evenMax + ",");
        } else if (evenMin == 1000000000 || evenMax == -1000000000) {
            System.out.println("OddSum=" + oddSum + ",");
            System.out.println("OddMin=" + oddMin + ",");
            System.out.println("OddMax=" + oddMax + ",");
            System.out.println("EvenSum=" + evenSum + ",");
            System.out.println("EvenMin=" + "No" + ",");
            System.out.println("EvenMax=" + "No" + ",");
        } else{
            System.out.println("OddSum=" + oddSum + ",");
            System.out.println("OddMin=" + oddMin + ",");
            System.out.println("OddMax=" + oddMax + ",");
            System.out.println("EvenSum=" + evenSum + ",");
            System.out.println("EvenMin=" + evenMin + ",");
            System.out.println("EvenMax=" + evenMax + ",");
        }

    }
}
