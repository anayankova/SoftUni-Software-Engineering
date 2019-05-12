package h_WhileLoop_Lab;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        while (true){
            String input = scanner.nextLine();
            if (input.equals("END")){
                break;
            }
            Integer num = Integer.parseInt(input);
            if (num > max){
                max = num;
            }
            if (num < min){
                min = num;
            }
        }
        System.out.println("Max number: " + max);
        System.out.println("Min number: " + min);

    }
}
