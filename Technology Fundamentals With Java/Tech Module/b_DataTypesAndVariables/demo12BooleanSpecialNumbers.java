package b_DataTypesAndVariables;

import java.util.Scanner;

public class demo12BooleanSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
           boolean special = i == 5 || i == 7 || i == 11;
            System.out.println(special);
        }

    }
}
