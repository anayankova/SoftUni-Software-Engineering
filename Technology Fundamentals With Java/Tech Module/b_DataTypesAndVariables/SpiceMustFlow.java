package b_DataTypesAndVariables;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int sum = 0;
        int spice = 0;

        if (n >= 100) {

            for (int i = n; i >= 100; i -= 10) {
                sum = i - 26;
                days++;
                spice += sum;

            }
            spice = spice - 26;
        }


        System.out.println(days);
        System.out.println(spice);

    }
}
