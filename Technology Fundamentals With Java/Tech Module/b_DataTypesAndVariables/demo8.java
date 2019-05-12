package b_DataTypesAndVariables;

import java.util.Scanner;

public class demo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 1.0f;
        double b = 0.33f;
        double sum = 1.33d;
        System.out.printf("a+b=%f sum=%f equal=%b",
                a + b, sum, (a + b == sum));
// a+b=1.33000001311302 sum=1.33 equal = false
        double num = 0;
        for (int i = 0; i < 10000; i++) num += 0.0001;
        System.out.println(num); // 0.9999999999999062

        int n = 5;
        int m = 6;
        int p = Integer.parseInt(scanner.nextLine());

        System.out.printf("%d = %b", n + m, n + m == p);


    }
}
