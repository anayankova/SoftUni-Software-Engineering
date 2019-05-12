package b_DataTypesAndVariables;

import java.math.BigDecimal;

public class demo9BigDecimal {
    public static void main(String[] args) {
        BigDecimal number = new BigDecimal(0);
        number = number.add(BigDecimal.valueOf(2.5));
        System.out.println(number);
        number = number.subtract(BigDecimal.valueOf(1.5));
        System.out.println(number);
        number = number.multiply(BigDecimal.valueOf(2));
        System.out.println(number);
        number = number.divide(BigDecimal.valueOf(2));
        System.out.println(number);


    }
}
