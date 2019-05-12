package b_DataTypesAndVariables;

import java.util.Scanner;

public class demo2StringsScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter strings:");
        String[] a = input.nextLine().split(" ");

        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

    }
}
