package d_Methods;

import java.util.Scanner;

public class sample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char f = scanner.nextLine().charAt(0);
        char s = scanner.nextLine().charAt(0);
        if (f > s) {
            System.out.println(f);
        }else {
            System.out.println(s);
        }

    }
}