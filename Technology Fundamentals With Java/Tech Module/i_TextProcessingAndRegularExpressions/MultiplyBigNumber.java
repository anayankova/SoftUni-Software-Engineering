package i_TextProcessingAndRegularExpressions;

import java.math.BigDecimal;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal x = new BigDecimal(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        BigDecimal result = x.multiply(new BigDecimal(y));
        System.out.println(result);

    }
}
