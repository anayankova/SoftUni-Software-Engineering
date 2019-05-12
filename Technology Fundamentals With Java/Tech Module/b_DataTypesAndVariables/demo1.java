package b_DataTypesAndVariables;

import java.math.BigDecimal;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.MAX_VALUE;
        int a = Integer.MAX_VALUE;
        short b = Short.MAX_VALUE;
        byte c = Byte.MAX_VALUE;

        System.out.println(n);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        long m = 0;

        System.out.println(Long.MAX_VALUE);

        String text = scanner.nextLine();

        System.out.println(String.valueOf(text));
        System.out.println(BigDecimal.valueOf(m));

    }
}
