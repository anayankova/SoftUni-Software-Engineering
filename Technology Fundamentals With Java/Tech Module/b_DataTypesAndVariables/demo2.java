package b_DataTypesAndVariables;

import java.math.BigDecimal;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal bd = new BigDecimal("123.2265653");
        BigDecimal bd2 = BigDecimal.ONE; //new BigDecimal("1")
        BigDecimal bd3 = bd.add(bd);
        System.out.println(bd3);

    }
}
