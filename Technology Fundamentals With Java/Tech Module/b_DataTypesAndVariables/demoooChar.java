package b_DataTypesAndVariables;

import java.util.Scanner;

public class demoooChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            int num = Integer.parseInt(c + "");

            int d = input.charAt(i);

            sum1 += num;
            sum2 += d;
        }
        System.out.println(sum1);
        System.out.println(sum2);


    }
}
