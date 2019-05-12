package d_Methods;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        readFullName();

    }

    public static String readFullName() {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        return firstName + " " + lastName;
    }

    //Return value can be:
    //Assigned to a variable
               //int max = getMax(5, 10);

    //Used in expression
             //double total = getPrice() * quantity * 1.20;

    //Passed to another method
            //int age = Integer.parseInt(sc.nextLine());


}
