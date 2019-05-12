package b_DataTypesAndVariables;

import java.util.Scanner;

public class WaterOverflow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int capacity = 255;

        for (int i = 0; i < n; i++) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (sum + quantity > capacity){
                System.out.println("Insufficient capacity!");
            }else {
                sum += quantity;
            }
        }
        System.out.println(sum);

    }
}
