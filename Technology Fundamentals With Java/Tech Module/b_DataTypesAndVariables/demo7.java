package b_DataTypesAndVariables;

public class demo7 {
    public static void main(String[] args) {
        System.out.println(10 / 4);    // 2 (integral division)
        System.out.println(10 / 4.0);  // 2.5 (real division)
        System.out.println(10 / 0.0);  // Infinity
        System.out.println(-10 / 0.0); // -Infinity
        System.out.println(0 / 0.0);   // NaN (not a number)
        System.out.println(8 % 2.5);   // 0.5 (3 * 2.5 + 0.5 = 8)
        System.out.println(10 / 0);    // ArithmeticException


    }
}
