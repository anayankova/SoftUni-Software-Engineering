package a_JavaIntroduction;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String number = n + "";

        int totalResult = 0;

        for (int i = 1; i <= number.length(); i++) {
            char count = number.charAt(i - 1);
            int counter = Integer.parseInt(count + "");
            int result = 1;
            for (int j = 1; j <= counter ; j++) {
                result *= j;
            }
            totalResult += result;
        }

        if (totalResult == n){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
}
