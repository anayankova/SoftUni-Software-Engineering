package l_NestedLoop_Lab;

import java.util.Scanner;

public class EvenPowersOf3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currentNum = 1;

        for (int i = 0; i <= n ; i+=2) {
            System.out.println(currentNum);
            currentNum *= 4;
        }

    }
}
