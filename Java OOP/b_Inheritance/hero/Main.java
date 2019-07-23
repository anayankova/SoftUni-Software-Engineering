package b_Inheritance.hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        Knight knight = new Knight(name,n);

        System.out.println(knight.toString());

    }
}
