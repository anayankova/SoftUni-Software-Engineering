package b_DataTypesAndVariables;

import java.util.Scanner;

public class demo16String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String result = firstName + delimiter + lastName;
        System.out.println(result);


    }
}
