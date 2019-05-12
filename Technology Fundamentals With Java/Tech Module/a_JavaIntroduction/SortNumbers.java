package a_JavaIntroduction;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        if (a > max) {
            a = max;
            if (b > a){
                b = max;
                if (c > b){
                    c = max;
                }
            }
            System.out.println(max);
        } else if (b > max) {
            b = max;
        }else if (c > max){
            c = max;
        }

    }
}
