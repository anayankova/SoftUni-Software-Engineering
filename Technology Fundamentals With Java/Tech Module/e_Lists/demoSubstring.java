package e_Lists;

import java.util.Scanner;

public class demoSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(input.substring(0, 1));
        System.out.println(input.substring(1, 2));
        System.out.println(input.substring(2, 3));

    }
}
