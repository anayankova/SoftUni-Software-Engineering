package f_ObjectsAndClasses;

import java.util.Scanner;

public class demoException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"break".equals(input)){

            try {
                int num = Integer.parseInt(input);
                System.out.println(num);
            } catch (Exception e){

            }

            input = scanner.nextLine();
        }

    }
}
