package j_ForLoop_Lab;

import java.util.Scanner;

public class code9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        for (int i = 1; i <= n ; i++) {
            leftSum += Integer.parseInt(scanner.nextLine());;
        }
        System.out.println(leftSum);

    }
}
