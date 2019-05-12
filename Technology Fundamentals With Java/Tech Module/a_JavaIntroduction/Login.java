package a_JavaIntroduction;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String pass = "";
        int count = 1;

        for (int i = username.length(); i > 0 ; i--) {
            char n = username.charAt(i-1);
            pass += n;
        }

        while (true){
            String input = scanner.nextLine();
            if (input.equals(pass)){
                System.out.printf("User %s logged in.",username);
                break;
            }else {
                if (count == 4){
                    System.out.printf("User %s blocked!",username);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
                count ++;
            }
        }

    }
}
