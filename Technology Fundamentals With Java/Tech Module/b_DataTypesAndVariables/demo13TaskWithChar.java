package b_DataTypesAndVariables;

import java.util.Scanner;

public class demo13TaskWithChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char c1 = scanner.nextLine().charAt(0);
        char c2 = scanner.nextLine().charAt(0);
        char c3 = scanner.nextLine().charAt(0);

        System.out.printf("%c %c %c",c3,c2,c1);

    }
}
