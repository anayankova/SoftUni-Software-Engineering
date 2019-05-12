package d_Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int result = smallestNumber(a, b, c);
        System.out.println(result);

    }

    static int smallestNumber(int a, int b, int c) {
        int smallestNumber = 0;
        if (a <= b && a <= c) {
            smallestNumber = a;
        } else if (b <= a && b <= c) {
            smallestNumber = b;
        } else {
            smallestNumber = c;
        }
        return smallestNumber;
    }
}
