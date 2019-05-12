package a_JavaIntroduction;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String pass = "";


            for (int i = username.length(); i > 0 ; i--) {
                char n = username.charAt(i-1);
                pass += n;

            }
        System.out.println(pass);


    }
}
