package f_NestedConditionalStatements_Lab;

import java.util.Scanner;

public class demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isValid = (number > 10) && (number % 2 == 0);
        if (!isValid)
            System.out.println("Invalid");


    }
}
