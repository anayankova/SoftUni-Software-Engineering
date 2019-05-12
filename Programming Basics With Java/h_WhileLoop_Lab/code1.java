package h_WhileLoop_Lab;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;

        int a = Integer.parseInt(scanner.nextLine());
        if (a < min){
            min = a;
            System.out.println(min);
        }

    }
}
