package a_JavaIntroduction;

import java.io.BufferedReader;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // scanner. nextInt()
        // BufferedReader   - като сканер
        String format = "%s, %d";
        System.out.println(String.format(format));

        String a = "asd";
        //String c = scanner.nextLine();
        String b = "asd";
        System.out.println(a = b);

        String dayType = scanner.nextLine();

        if ("Weekday".equals(dayType)) {  // instead of if ( dayType.equals("Weekday")

        }
    }
}
