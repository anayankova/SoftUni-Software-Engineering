package d_Methods;

import java.util.Scanner;

public class example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        one(n);
        second(n);

    }

    static void one(int n){
        for (int i = 1; i <= n ; i++) {
            if (i == 8){
                System.out.println(i);
            }
        }
    }

    static void second (int n){
        for (int i = 1; i <= n ; i++) {
            if (i % 2 ==0){
                System.out.println(i);
            }
        }
    }
}
