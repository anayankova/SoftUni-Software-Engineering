package m_NestedLoop_Exercise;

import java.util.Scanner;

public class SumPrimeNoPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumPrime = 0;
        int sumNoPrime = 0;
        String number = scanner.nextLine();

        while (!number.equals("stop")) {
            int num = Integer.parseInt(number);

            if (num < 0) {
                System.out.println("Number is negative.");
                num = 0;
            }

            boolean isPrime = true;
            for (int divisor = 2; divisor <= num/2 ; divisor++) {

                if (num % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (num == 1){
                isPrime = false;
            }

            if (isPrime) {
                sumPrime += num;
            } else {
                sumNoPrime += num;

            }
            number = scanner.nextLine();

        }
        System.out.println("Sum of all prime numbers is: " + sumPrime);
        System.out.println("Sum of all non prime numbers is: " + sumNoPrime);

    }
}
